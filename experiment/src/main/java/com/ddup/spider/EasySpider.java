package com.ddup.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ddup.utils.GsonUtils;

public class EasySpider {
    
    private final static Logger logger = LoggerFactory.getLogger(EasySpider.class);

    public static void main(String[] args) {
        // 注册
//        NameValuePair usernamePassword = signup();
        // 登陆
        NameValuePair usernamePassword = new BasicNameValuePair("username", "73no7gwy8g");
        login(usernamePassword);
        
        // 下载3个文件
       
    }
    
    /**
     * 注册
     */
    public static NameValuePair signup() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        
        // 创建参数队列    
        List<NameValuePair> formparams = generateSingupMsg();
        UrlEncodedFormEntity uefEntity;  
        try {
            HttpPost httpPost = new HttpPost("http://www.99ff0.com/signup.php");
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8"); 
            httpPost.setEntity(uefEntity);
            response = httpclient.execute(httpPost);
            response.getEntity();
            return formparams.get(1);
        } catch (Exception e) {
            logger.error("" ,e);
            return null;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (IOException e) {
                logger.error("", e);
            }
        }
    }
    
    /**
     * 下载
     */
    public static void download(Header sessionCookie) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        
        List<NameValuePair> formparams = null;
        UrlEncodedFormEntity uefEntity;  
        try {
            HttpPost httpPost = new HttpPost("http://www.99ff0.com/login.php");
            httpPost.setHeader("Cookie", sessionCookie.getValue());
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8"); 
            httpPost.setEntity(uefEntity);
            response = httpclient.execute(httpPost);
            // cookies[0]就是 ==== Set-Cookie: PHPSESSID=ce79eaoisk36259efgoo6o6in2; path=/; domain=.99ff0.com, 
            Header[] cookies = response.getHeaders("Set-Cookie");
            System.out.println(cookies[0].getValue());
            System.out.println(cookies[0].getName());
            logger.warn("cookies：{}", cookies[0]);
//            HttpEntity entity = response.getEntity();
        } catch (Exception e) {
            logger.error("" ,e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (IOException e) {
                logger.error("", e);
            }
        }
    }
    
    /**
     * 登录
     */
    public static Header login(NameValuePair usernamePassword) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        
        List<NameValuePair> formparams = generateLoginMsg(usernamePassword);
        UrlEncodedFormEntity uefEntity;  
        try {
            HttpPost httpPost = new HttpPost("http://www.99ff0.com/login.php");
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8"); 
            httpPost.setEntity(uefEntity);
            response = httpclient.execute(httpPost);
            // cookies[0]就是 ==== Set-Cookie: PHPSESSID=ce79eaoisk36259efgoo6o6in2; path=/; domain=.99ff0.com, 
            Header[] cookies = response.getHeaders("Set-Cookie");
//            System.out.println(cookies[0].getValue());
//            System.out.println(cookies[0].getName());
            logger.warn("cookies：{}", cookies[0]);
            return cookies[0];
//            HttpEntity entity = response.getEntity();
        } catch (Exception e) {
            logger.error("" ,e);
            return null;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (IOException e) {
                logger.error("", e);
            }
        }
    }
    
    private static List<NameValuePair> generateLoginMsg(NameValuePair usernamePassword) {
        List<NameValuePair> formparams = new ArrayList<>();
        formparams.add(new BasicNameValuePair("action", "login"));
        formparams.add(new BasicNameValuePair("username", usernamePassword.getValue()));
        formparams.add(new BasicNameValuePair("pass", usernamePassword.getValue()));
        return formparams;
    }


    private static List<NameValuePair> generateSingupMsg() {
        // 26
        char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        // 36
        char[] lettersAndfigure = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        
        StringBuilder username = new StringBuilder();
        StringBuilder password = new StringBuilder();
        StringBuilder email = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = new Random().nextInt(36);
            System.out.println(index);
            username.append(lettersAndfigure[index]);
            password.append(lettersAndfigure[index]);
            index = new Random().nextInt(26);
            System.out.println(index);
            email.append(letters[index]);
        }
        email.append("@");
        for (int i = 0; i < 6; i++) {
            int index = new Random().nextInt(26);
            System.out.println(index);
            email.append(letters[index]);
        }
        email.append(".");
        for (int i = 0; i < 5; i++) {
            int index = new Random().nextInt(26);
            System.out.println(index);
            email.append(letters[index]);
        }
        
        List<NameValuePair> formparams = new ArrayList<>();
        formparams.add(new BasicNameValuePair("action", "signup"));
        formparams.add(new BasicNameValuePair("username", username.toString()));
        formparams.add(new BasicNameValuePair("pass", password.toString()));
        formparams.add(new BasicNameValuePair("pass2", password.toString()));
        formparams.add(new BasicNameValuePair("email", email.toString()));
        formparams.add(new BasicNameValuePair("code", "xxxxx"));
        logger.warn("formparams：{}", GsonUtils.toJson(formparams));
        
        return formparams;
    }
} 
    

class EasyContext {
    private String cookies = "";
    
    
}
