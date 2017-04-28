package com.ddup.java.exception;

/**
 * XX。
 * 
 * <p>XX</p>
 * <ul><li></li></ul>
 * <br>
 * <strong>Copyright</strong> ©1990-2016 ddupa.com. All Rights Reserved.<br>
 *
 * @version 1.0.0
 * @author 30459 2016年9月24日
 */
public class MainTest {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        System.out.println("哈哈哈");
        throw new MessageException("你在干什么啊，出异常了，赶紧看看");
    }

}
