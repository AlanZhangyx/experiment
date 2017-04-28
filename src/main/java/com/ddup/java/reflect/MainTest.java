package com.ddup.java.reflect;

import java.lang.reflect.Field;

import com.ddup.java.reflect.beans.PersonBean;

public class MainTest {

    public static void main(String[] args) throws Exception {
        Class<? extends PersonBean> clazz = new PersonBean().getClass();
        
        Field nameField = clazz.getField("name");
//        clazz.getDeclaredField(name)
        
        String name = (String)nameField.get(clazz);
        System.out.println(name);
        
    }

}
