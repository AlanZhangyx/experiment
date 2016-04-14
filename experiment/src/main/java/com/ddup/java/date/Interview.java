package com.ddup.java.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Interview {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*日期和时间： 
		- 1. 如何取得年月日、小时分钟秒？ 
		- 2. 如何取得从1970年1月1日0时0分0秒到现在的毫秒数？ 
		- 3. 如何取得某月的最后一天？ 
		- 4. 如何格式化日期？ */
		
		//1
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH));//0-11
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));
		System.out.println(calendar.get(Calendar.MILLISECOND));
		
		//2
		long currentTimeMillis1 = calendar.getTimeInMillis();//2.1
		long currentTimeMillis2 = System.currentTimeMillis();//2.2
		System.out.println(currentTimeMillis1 + "==" + currentTimeMillis2);
		
		//3 求2月最后一天
		calendar.set(Calendar.MONTH, 1);//设置2月
		System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		//4 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString4 = df.format(new Date());
		System.out.println(dateString4);
		
	}

}
