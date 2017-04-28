package com.ddup.java.beans;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 处理bean的工具类。
 * @Author alanzhang
 * @Date 2016年6月7日 上午11:31:13 
 */
public class BeanUtils {

    public static Map<String, Object> bean2Map(Object obj){
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            /** 1. BeanInfo的实现类实现了此 BeanInfo接口并提供有关其 bean的方法、属性、事件等"显式信息" **/
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());//一定要使用ojb的getClass来获取
            /** 2. PropertyDescriptor 描述 Java Bean 通过一对存储器方法导出的一个属性。 **/
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                /** 3. 可以被称为property的是一个或一对(get/is)/set方法的方法名的后缀。
                 * 也就是说它们的名字是这样，isHaoRen() --> haoRen
                 **/
                String propertyName = propertyDescriptor.getName();
                if (!propertyName.equals("class")) {//因为有getClass()所以要过滤掉class
                    /** 4. 一定要通过ReadMethod来读取，这样才符合Bean的设计意图 **/
                    Method method = propertyDescriptor.getReadMethod();
                    Object value = method.invoke(obj);
                    map.put(propertyName, value);
                }
            }
        } catch (Exception e) {
            System.err.println("bean2Map Exception" + e);
        }
        return map;
    }
}
