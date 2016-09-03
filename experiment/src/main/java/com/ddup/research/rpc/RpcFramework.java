package com.ddup.research.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RpcFramework {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
    /**
     * 绑定端口提供ServerSocket。
     * 监听端口，如果有Socket连接上，就将对象写给Socket；
     * <p>
     * 最终是将什么写回给socket了呢？是对象没错，但是是调用结果对象。
     * </p>
     * @param service
     * @param port
     * @throws Exception 
     */
    public static void export(final Object service, int port) throws Exception{
        ServerSocket server = new ServerSocket(port);  
        for(;;) {
            try {  
                final Socket socket = server.accept();
                System.out.println("有consumer来了："+ sdf.format(new Date()));
                new Thread(new Runnable() {
                    @Override  
                    public void run() {  
                        try {  
                            try {
                                Thread.sleep(2000l);
                                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());  
                                try {  
                                    String methodName = input.readUTF();  
                                    Class<?>[] parameterTypes = (Class<?>[])input.readObject();  
                                    Object[] arguments = (Object[])input.readObject();  
                                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());  
                                    try {  
                                        Method method = service.getClass().getMethod(methodName, parameterTypes);  
                                        Object result = method.invoke(service, arguments);
                                        output.writeObject(result);
                                    } catch (Throwable t) {  
                                        output.writeObject(t);  
                                    } finally {  
                                        output.close();  
                                    }  
                                } finally {  
                                    input.close();  
                                }  
                            } finally {  
                                socket.close();  
                            }  
                        } catch (Exception e) {  
                            e.printStackTrace();  
                        }  
                    }  
                }).start();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        } 
        
    }
    
    /**
     * 引用服务。
     * <p>
     * 这里因为比较简单，所以必须指明host和端口。
     * 一个完善的RPC应当有个“协调服务中心”，客户端只需要连接上此中心，中心会告诉客户端服务的地址；
     * </p>
     * <p>
     * 最终给调用这的是什么呢？
     * 
     * </p>
     * @param interfaceClass 接口类型
     * @param host 主机
     * @param port 端口
     * @return
     */
    @SuppressWarnings(value = { "unchecked" })
    public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) throws Exception{
        return (T)Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[] {interfaceClass}, 
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {  
                Socket socket = new Socket(host, port);
                try {  
                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                    try {  
                        output.writeUTF(method.getName());
                        output.writeObject(method.getParameterTypes());
                        output.writeObject(arguments);
                        System.out.println("输出要调用的方法信息完毕，开始等待读取结果："+ sdf.format(new Date()));
                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());  
                        try {
                            System.out.println("成功："+ sdf.format(new Date()));
                            Object result = input.readObject();
                            if (result instanceof Throwable) {  
                                throw (Throwable) result;
                            }  
                            return result;
                        } finally {  
                            input.close();  
                        }  
                    } finally {  
                        output.close();  
                    }  
                } finally {  
                    socket.close();  
                }  
            }  
        }); 
    }
    
    
}
