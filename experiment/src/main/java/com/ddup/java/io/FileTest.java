package com.ddup.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

/**
 * 文件I/O。
 * 
 * <p>读1个文件将内容写入另外1个</p>
 * <ul><li></li></ul>
 * 
 * <strong>Time</strong>&nbsp;&nbsp;&nbsp;&nbsp;2016年4月21日<br>
 * <strong>copyright</strong>&nbsp;&nbsp;&nbsp;&nbsp;2016, 北京都在哪网讯科技有限公司<br>
 *
 * @version  1.0.0
 * @author   30459
 */
public class FileTest {
	
	/**
	 * 文件byte流读取和写入
	 * @throws IOException
	 */
	@Test
	public void fileBytesTest() throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			File fileIn = new File("F:" + File.separator + "logo.png");
			in = new FileInputStream(fileIn);
			
			File fileOut = new File("F:" + File.separator + "logo1.png");
			out = new FileOutputStream(fileOut);
			
			byte[] bf = new byte[1024];
			int len = 0;
			while ((len = in.read(bf)) > 0) {
				out.write(bf, 0, len);
			}
		} finally {
			in.close();
			out.close();
		}
	}
	
	/**
	 * char流读取和写入
	 * @throws IOException
	 */
	@Test
	public void fileCharsTest() throws IOException {
		Reader reader = null;
		Writer writer = null;
		try {
			File fileIn = new File("F:" + File.separator + "2.txt");
			reader = new FileReader(fileIn);
			
			File fileOut = new File("F:" + File.separator + "2.1.txt");
			writer = new FileWriter(fileOut);
			
			char[] cbuf = new char[1024];
			
			int len = 0;
			while ((len = reader.read(cbuf)) > 0) {
				writer.write(cbuf, 0, len);
			}
			
		} finally {
			reader.close();
			writer.close();
		}
	}

}
