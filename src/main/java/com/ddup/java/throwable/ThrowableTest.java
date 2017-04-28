package com.ddup.java.throwable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * <br>
 * <br>
 * <br>
 * <strong>Time</strong>:2016年4月14日<br>
 * <strong>copyright</strong>: 2016, 北京都在哪网讯科技有限公司<br>
 *
 * @version : 1.0.0
 * @author dznzyx
 */
public class ThrowableTest {

	public static void main(String[] args) {
		Throwable t1 = new Error();
		Throwable t2 = new Exception();
		
		System.out.println(testReturn());

	}

	/**
	 * 1. try{}里有一个return语句，那么紧跟在这个try后的finally{}里的代码会不会被执行，什么时候被执行，在return前还是后?
	 * @return
	 */
	public static int testReturn() {
		int i = 1;
		try {
			return i;
			//return 1; -group2
		} catch (Exception ex) {

		} finally {
			i = -1;
			System.out.println("finally：" + i);
			//return 0;//或者i，都一样有作用 -group2
		}
		return 0;//显然，这句不会被执行，只是为了应付编译时异常
		//解释：：：：：：
		//第1种情况：在try的return前，会先将return值“记录”，然后执行finally，此时你当然可以改变返回变量的值，但是这不会改变return结果，因为会返回之前记录的那一份
		//第2种情况（group2）：在finally中也写个return，你可以这样做，并且这样将会最终返回finally中的renturn值。
		//	但是，这种情况非常不好，其实在C#中这就是编译错误，Java语法没有严格控制而已，不过Eclipse会报告警告“finally block does not complete normally”
	}
	
	/**
	 * 2. try catch 允许的语法
	 */
	public static void testBlock(){
		try { } catch (Exception e) { }
		try { } catch (NullPointerException e) { } catch (Exception e){}
		try {} finally {}
	}
	
	/**
	 * 3. throws的用法
	 * throws和throw都用在方法上
	 * 	1. throws用在方法声明部分，用逗号分隔可thorws多个
	 * 	2， throw用在方法体中，用于具体抛出一个Exception
	 * @throws Exception 
	 */
	public void testThorwsMethod() throws Exception{
		throw new Exception();
		
		//也可以抛出Error，但是正如Error的定义一样，不用捕获
		// throw new Error();
	}

}
