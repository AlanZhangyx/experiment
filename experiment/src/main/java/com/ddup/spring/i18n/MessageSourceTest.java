package com.ddup.spring.i18n;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSourceTest {

    public static void main(String[] args) {
        
        MessageSource messageSource = new ClassPathXmlApplicationContext("spring-context-i18n.xml");
        String message1 = messageSource.getMessage("error.user.userName.NotBlank", null, Locale.CHINESE);
        //String message4 = messageSource.getMessage("message.user.context", new Object[]{"ycl"}, Locale.CHINESE);
        System.out.println(message1);
        //System.out.println(message4);
    }

}
