package com.ddup.java.beans;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        PersonBean personBean = new PersonBean();
        System.out.println(personBean.toString());
        Map<String, Object> map = BeanUtils.bean2Map(personBean);
        
        
        System.out.println(map);
    }

}
