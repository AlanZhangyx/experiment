package com.ddup.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest1 {
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * 1. 匹配
		 * 方法：使用String的matches()
		 * 规则：第一位必须是1，第二位可以是3/5/8，后面是9位数字
		 */
		/*String str1 = "13812312319";
		String regex1 = "1[358]\\d{9}";
		System.out.println(str1.matches(regex1));//true
*/		
		/**
		 * 2. 分割
		 * 方法：使用String的split()
		 * 目标：
		 * 	2.1 任意个空格的分割
		 * 	2.2 以.分割：需要注意取消.在正则中代表任意字符的含义
		 * 	2.3 重复的字符来分割，需要使用分组，因为要求第2个字符跟第1个相同
		 */
		/*String str21 = "asdf 909  sdfd sadf           sdf";
		String regex21 = "\u0020+";//空格就是\u0020(十进制32)，也可以直接敲个 (前面是个空格)，或者使用\\s
		String [] strs21 = str21.split(regex21);
		
		String str22 = "asdf.909.sdfd.sadf.sdf";
		String regex22 = "\\.";//首先\.代表想正常使用点(而不是正则字符)，又因为在Java的String中，所以再加\
		String [] strs22 = str22.split(regex22);
		
		String str23 = "asdfssss909aaaasdfdbbbbbsadfttttsdf";
		String regex23 = "([a-z])\\1+";//首先，第一个字符是任意小写英文；接着，第二个字符和第一个一样；最后，第二个字符出现至少一次
		String [] strs23 = str23.split(regex23);*/
		
		/**
		 * 3. 替换
		 * 方法：使用String的replaceAll()
		 * 目标：
		 * 	3.1 简单替换
		 * 	3.2 使用被替换的内容替换，将重复的变为1个：需使用组，可以在方法第二个参数中使用美元符号$选取组
		 * 	3.3 手机号码中4位用*号代替
		 */
		/*String str31 = "asdf 909  sdfd sadf           sdf";
		String regex31 = "\u0020+";
		str31 = str31.replaceAll(regex31, "1");//asdf19091sdfd1sadf1sdf
		
		String str32 = "asdf 909  sdfd sadf           sdf";
		String regex32 = "(\u0020)+";
		str32 = str32.replaceAll(regex32, "$1");//asdf 909 sdfd sadf sdf
		
		String str33 = "13812312319";
		String regex33 = "(.{3}).{4}(.{4})";//将需要保留的内容编组保留，以便之后还原，然后整体替换
		str33 = str33.replaceAll(regex33, "$1****$2");*/
		
		/**
		 * 4. 获取
		 * 方法：
		 * 目标：
		 * 	4.1 获取3个字母组成的单词
		 */
		String str41 = "asdf, sdd*adf%$$sdsf";
		String regex41 = "[a-z]{3}";
		Pattern p = Pattern.compile(regex41);
		Matcher m = p.matcher(str41);
		while(m.find()){//查找一个匹配的子序列
			System.out.println(m.group());//返回之前匹配的输入子序列
		}
		 
		
	}
	
	

}
