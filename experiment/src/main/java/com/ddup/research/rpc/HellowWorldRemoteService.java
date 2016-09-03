/**
 * 
 */
package com.ddup.research.rpc;

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
public interface HellowWorldRemoteService {

    public String sayHellowByUserName(String userName);
    
    public String sayHellowByUserName2(String userName);
    
    public void changeMap(Map<String, Object> map);
    
}