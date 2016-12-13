package com.ddup.designpatterns.proxy.jdk.staticc;

public class AProxyBuyGoodsImpl implements BuyGoodsService {

    @Override
    public String buy(String goodsName) {
        BuyGoodsService service = new TaobaoBuyGoodsServiceImpl();
        String result = service.buy(goodsName);
        result = "委托“A”做为代理，" + result;
        // System.err.println(result);
        return result;
    }

}
