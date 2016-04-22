package com.ddup.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

import org.junit.Test;

public class BufferedTest {
	
	/**
	 * 这里做一个使用BufferedReader读File的research。
	 * 
	 * 通过查看源码可知
	 * BufferedReader目的是为了解决使用各种Reader的子类中的read()方法时一次只读一个char的低效
	 * 所以它默认有个8192大小的char[]，然后71%常用的方法readLine()会一次一行的读(用\r或\n判断，就是下标取char[])；
	 * 其实，这种做法和直接使用read(char[])我认为差不多
	 * 
	 * ！！！注：想下面这样操作是会出现乱码的，这是因为：
	 * 	1. 最好不用字符流读取文本文件，因为你不知道文本文件的编码格式；
	 *  2. 又由于字符流不提供编码转换的方法；
	 *  
	 *  ！！！so，看下边的方法 bufferedReaderTest2() ↓↓↓↓↓↓↓↓↓↓↓↓
	 * @throws Exception 
	 */
	@Test
	public void bufferedReaderTest() throws Exception{
		
		File file = new File("F:\\3.txt");
		BufferedReader bufR = new BufferedReader(new FileReader(file));
		File file2 = new File("F:\\3.1.txt");
		BufferedWriter bufW = new BufferedWriter(new FileWriter(file2));
		
		String content = null;
		while ((content = bufR.readLine()) != null) {
			bufW.write(content);
		}
		bufW.close();
		bufR.close();
		
	}
	
	/**
	 * 读取字符文件（如.txt）最好使用InputStream的子类，因为不能确定这个字符文件的编码。
	 * 
	 * @throws Exception
	 */
	@Test
	public void bufferedReaderTest2() throws Exception{
		/*如下这样写的意义：
		1. 首先，不能用字符流读文件，那么使用FileInputStream；
		2. 接着，（最终来说）我们想要字符流BufferedReader，因为效率原因，那么我们就需要字符流而不是字节流，所以需要转换，所以需要InputStreamReader；
		3. 最终我们需要字符流我们想要字符流BufferedReader*/
		
		File file = new File("F:\\3.txt");
		InputStreamReader inR = new InputStreamReader(new FileInputStream(file), "GBK");//指定解码方式为GBK，因为我知道文件是GBK编码
		
		BufferedReader bufR = new BufferedReader(inR);
		File file2 = new File("F:\\3.1.txt");
		BufferedWriter bufW = new BufferedWriter(new FileWriter(file2));
		
		String content = null;
		while ((content = bufR.readLine()) != null) {
			bufW.write(content);
		}
		bufW.close();
		bufR.close();
	}
}