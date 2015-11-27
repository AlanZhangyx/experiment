package com.ddup.spring.i18n;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSourceTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        
        @SuppressWarnings("resource")
        MessageSource messageSource = new ClassPathXmlApplicationContext("spring-context-i18n.xml");
        //ApplicationContext messageSource = new ClassPathXmlApplicationContext("spring-context-i18n.xml");
        String message1 = messageSource.getMessage("error.user.userName.NotBlank", null, Locale.CHINA);
        //String message2 = messageSource.getMessage("error.user.userName.Length", new Object[]{"1","10"}, Locale.CHINESE);
        
        //1 第一种方式：文件是UTF-8有中文，没有设置defaultEncoding情况下
        /*byte[] bytes = message1.getBytes("ISO-8859-1");
        System.out.println(new String(bytes, "UTF-8"));*/
        
        //2 第二种方式：文件是UTF-8有中文，设置defaultEncoding为UTF-8
        /*System.out.println(message1);*/
        
        //3 第三种方式：文件是ISO-8859-1有中文，但将中文编码为十六进制unicode
        /*System.out.println(message1);*/
        
        System.out.println(message1);
    }

}
