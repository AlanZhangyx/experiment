/**
 * 
 */
package com.ddup.research;

import java.util.Map;

/**
 * XX。
 * 
 * <p>XX</p>
 * <ul><li></li></ul>
 * <br>
 * <strong>Copyright</strong> ©1990-2016 ddupa.com. All Rights Reserved.<br>
 *
 * @version 1.0.0
 * @author 30459 2016年9月3日
 */
public class HellowWorldRemoteServiceImpl implements HellowWorldRemoteService {

    /* (non-Javadoc)
     * @see com.ddup.research.HelloWorldService#sayHellowByUserName(java.lang.String)
     */
    @Override
    public String sayHellowByUserName(String userName) {
        return "HellowWorld1" + userName;
    }

    @Override
    public String sayHellowByUserName2(String userName) {
        return "HellowWorld2" + userName;
    }

    @Override
    public void changeMap(Map<String, Object> map) {
        map.put("1", "被改变");
    }

}
