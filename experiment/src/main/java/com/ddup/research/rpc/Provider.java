package com.ddup.research.rpc;

/**
 * XX。
 * 
 * <p>XX</p>
 * <ul><li></li></ul>
 * <br>
 * <strong>Copyright</strong> ©1990-2016 ddupa.com. All Rights Reserved.<br>
 *
 * @version 1.0.0
 * @author 30459 2016年9月2日
 */
public class Provider {

    /**
     * 利用RpcFramwork将想要发布的Service发布出去。
     * <br>
     * 本机要提供服务的，所以本机不会能停。其实就是应该一直处于阻塞监听状态；
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        // 在本机的20881端口发布一个实现类
        RpcFramework2.export(new HellowWorldRemoteServiceImpl(), 20881);
    }
}
