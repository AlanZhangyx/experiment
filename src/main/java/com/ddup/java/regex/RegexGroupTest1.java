package com.ddup.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexGroupTest1 {
    
	public static void main(String[] args) {
		
		getMatchInfo("/hangzhou", "(/beijing/?|/shanghai/?|/hangzhou/?|/guangzhou/?|/shenzhen/?|/chengdu/?)", 1);
		
	}
	
	/**
	 * 当时遇到问题是，这个方法不能改变结构；它是从第1组开始获取的。
	 * 那我只能将本来这样就够的正则："/(beijing)/?|/(shanghai)/?|/(hangzhou)/?|/(guangzhou)/?|/(shenzhen)/?|/(chengdu)/?"
	 * 改为外围加一对括号("/(beijing)/?|/(shanghai)/?|/(hangzhou)/?|/(guangzhou)/?|/(shenzhen)/?|/(chengdu)/?")
	 * @param content
	 * @param regex
	 * @param groupCount
	 * @return
	 */
	public static String[] getMatchInfo(String content, String regex, int groupCount) {
	    if(groupCount <= 0){
            groupCount = 1;
        }
        String[] keyInfos = new String[groupCount];
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            for (int i = 0; i < groupCount; i++) {
                keyInfos[i] = matcher.group(i+1);//group从1开始
            }
        }
        return keyInfos;
    }

}
