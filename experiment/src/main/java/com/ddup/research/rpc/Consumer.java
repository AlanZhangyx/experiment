package com.ddup.research.rpc;

import java.util.HashMap;
import java.util.Map;

public class Consumer {

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("1", "初始值");
        HellowWorldRemoteService s = RpcFramework2.refer(HellowWorldRemoteService.class, "127.0.0.1", 20881);
        for (int i = 0; i < 10; i++) {
            String content = s.sayHellowByUserName(i + "AlanZhang");
            String content2 = s.sayHellowByUserName2(i + "AlanZhang");
            s.changeMap(map);
            System.out.println(content);
            System.out.println(content2);
            System.out.println((String)map.get("1"));
            Thread.sleep(1000);
        }
    }

}
