package com.ddup.java;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class Generic<T> {
	
    T model;

	public Generic() throws InstantiationException, IllegalAccessException {
		ParameterizedType pt=(ParameterizedType)this.getClass().getGenericSuperclass();//当前类(BaseAction<T>)的类型的泛型的类型(T)
		Class<T> clazz=(Class<T>)pt.getActualTypeArguments()[0];//有可能有多个，如Map<K,V>
		model=clazz.newInstance();//生成T的实例
	}

	public T getModel(){
		return model;
	}
	
	public static void main(String[] args) {
		
	}
	
	
	/***  ***/

}
