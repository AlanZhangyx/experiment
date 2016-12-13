package com.ddup.designpatterns.proxy.jdk.staticc;

/**
 * 买东西。
 * 
 * <p>XX</p>
 * <ul><li></li></ul>
 * <strong>Copyright</strong> ©2013-2016 Lagou.com LLC. All Rights Reserved.<br>
 *
 * @version 1.0.0
 * @author 
 * <ul>
 * <li>alanzhang 2016年12月13日<br></li>
 * </ul>
 */
public interface BuyGoodsService {

    /**
     * 买东西；
     * @param goodsName 商品名
     * @return 返回购买结果
     */
    public String buy(String goodsName);
    
}
