/**
 * 构建一个Remote Procedure Call - RPC框架。
 * 
 * 核心是：
 * <br>“提供者”借助RPC将自己以ServerSocket的形式提供出去，并执行{@link java.net.ServerSocket#accept()}阻塞自己。
 * <br>     当接收到socket之后，获取socket所指定的类型、方法、方法参数，然后将执行结果返回。
 * <br>“消费者”借助RPC，传入Interface类型，来得到一个Interface的实例。此实例不是Interface的实现类，而是实现类的代理类。
 * <br>     得到此代理类后，消费者每次调用代理类的“方法”时，RPC中其实是执行了代理类的invoke方法，根据调用的“方法名和参数”去开启socket，调用“提供者”。
 * 
 * 
 * <p>
 * 以防以后来看一时想不起来，在此记录一些简单点
 * <br>
 * “消费者”是怎么在Socket中找到正确的类的呢？事实上是没有去找，因为这是Socket，我们将“出口”和“引用”都限定了必须写port，所以我们根据端口即可。
 * <br>
 * </p>
 * <ul>
 * 描述一遍思路：
 * <li>
 * 1. “服务提供者”将自己的实例对象obj绑定在本机host的端口port上。阻塞自己
 * </li>
 * <li>
 * 2. “消费者”根据host和port找到ServerSocket。然后打开输出流，将需要的“方法名、参数类型们、参数们”写入输出流中。最后等待输入流
 * </li>
 * <li>
 * 3. “服务提供者”监听到有“消费者”过来了，从输入流中读取“方法名、参数类型们、参数们”利用反射调用obj相应的“方法”。最后将方法调用结果返回。
 * </li>
 * <li>
 * 4. “消费者”终于等到了输入流，从输入流中读取对象，然后直接返回。RPC流程结束。
 * </ul>
 * <strong>Copyright</strong> ©2013-2016 Lagou.com LLC. All Rights Reserved.<br>
 *
 * @version 1.0.0
 * @author 
 * <ul>
 * <li>alanzhang 2016年9月2日<br></li>
 * </ul>
 */
package com.ddup.research.rpc;