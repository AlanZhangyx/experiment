package com.ddup.designpatterns.proxy.jdk.staticc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Launcher {
    
    private static BuyGoodsService service;

    public static void main(String[] args) throws Exception {
        // 现在你要上网买东西
        
        // 1. 正常来说，你直接找到了淘宝，然后买买买  ---- 买完结束
        service = new TaobaoBuyGoodsServiceImpl();
        System.err.println(service.buy("节操"));
        
        // 代理模式：在Java的最基本应用，静态代理 - 写代码的时候就知道用哪个类做代理类了
        // 2. 可是你笨，你不会用淘宝，没账号，你让“A同学”帮你买
        service = new AProxyBuyGoodsImpl();
        System.err.println(service.buy("节操"));
        
        InvocationHandler handler = new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(proxy, args);
            }
        };
        Class<?> proxyClass = Proxy.getProxyClass(BuyGoodsService.class.getClassLoader(), BuyGoodsService.class);
        service = (BuyGoodsService) proxyClass.getConstructor(InvocationHandler.class).newInstance(handler);
        System.err.println(service.buy("节操"));
        
    }

}
