package com.ddup.designpatterns.proxy.jdk.staticc;

public class TaobaoBuyGoodsServiceImpl implements BuyGoodsService {

    @Override
    public String buy(String goodsName) {
        String result = "[从淘宝买了：1个" + goodsName + "]";
        // System.err.println(result);
        return result;
    }

}
