package com.ddup.research.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcFramework2 {

    /**
     * 引用。
     * 
     * 引用的结果只能通过“返回值”来实现，如果参数中输入一个类，期望看到类的属性变化是做不到了…
     * 
     * @param interfaceClass
     * @param host
     * @param port
     * @return
     */
    @SuppressWarnings(value = { "unchecked" })
    public static <t>t refer(final Class<t> interfaceClass, final String host, final int port){
        return (t)Proxy.newProxyInstance(interfaceClass.getClassLoader(), 
                new Class<?>[]{interfaceClass}, new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        
                        Socket socket = new Socket(host, port);
                        
                        // 类型已经确定了，所以只需要将method名字、参数、参数类型告诉“提供者”
                        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeUTF(method.getName());
                        output.writeObject(method.getParameterTypes());
                        output.writeObject(args);
                        
                        // 开始(等待)读取喽
                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        
                        // 读到了……  返回吧
                        return input.readObject();
                    }
                    
                }
          );
    }
    
    /**
     * 出口。
     * 
     * 这种方式最明显的缺点就是一个port只能绑定一个Object；
     * 
     * @param obj
     * @param port
     * @throws Exception
     */
    public static void export(final Object obj, final int port) throws Exception{
        // 将对象“出口”后，就是建立的ServerSocket，此时程序阻塞监听  
        ServerSocket server = new ServerSocket(port);
        
        while (true) {
            // 要在无限循环中阻塞监听，因为时刻准备着其它“消费者”访问呀
            final Socket socket = server.accept();
            
            // 当监听到“消费者”后要开启子线程来实现，这和循环是配合使用的。使得接下来的步骤异步进行，好让主线程继续监听。
            new Thread(){
                @Override
                public void run() {
                    try {
                        // 获取需要调用的方法的类型
                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        String methodName = input.readUTF();
                        Class<?>[] paramsType = (Class<?>[])input.readObject();
                        Object[] params = (Object[])input.readObject();
                        
                        // 使用反射调用相关方法
                        Method method = obj.getClass().getMethod(methodName, paramsType);
                        Object result = method.invoke(obj, params);
                        
                        // 将结果写回给socket 
                        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeObject(result);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            
        }
    }
}
