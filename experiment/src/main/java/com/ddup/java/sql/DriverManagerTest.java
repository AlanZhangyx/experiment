package com.ddup.java.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 用来管理具体的Driver。
 * 1. Driver是每个JDBC具体实现类都必须实现的接口
 * 2. 每个Driver必须向DriveManager注册；
 * 3. 从1.4开始，提供了DataSource用来代替DriverManager
 * 
 * @author 30459
 *
 */
public class DriverManagerTest {
	
	
	/**
	 * 获得连接Connection之后，才能创建
	 * 	1. 静态语句 Statement
	 *  2. 预定义语句 PrepareStatement
	 *  2. 预定义存储过程CallableStatment
	 *  
	 * 之前需要手动注册驱动：Class.forName("com.mysql.jdbc.Driver")
	 * 才能使用DriverManager，自从JDBC4.0后就不需要了
	 * @throws SQLException 
	 */
	@Test
	public void testConnect() throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sqltest", "root", "root");
		
		int paraId = 4;
		
		/**************************** 1. 静态语句 ****************************/
		/*1. 为什么需要Connection才能创建语句呢？
		我的理解：
		因为Connection、Statement、PrepareStatement、CallableStatement都是Interface，
		它们都依赖与具体的Driver中的具体实现类们。
		所以要使用具体的Connection才能获取可用的具体的语句*/
		Statement statement = connection.createStatement();
		
		//1. 静态语句Statement的特点，Statement可以随时改变SQL，因为在查询时才需要指定
		//2. 参数必须写在语句中，和语句是一个String
		ResultSet resultSet1 = statement.executeQuery("select * from tb_test1 where id = " + paraId);
		while (resultSet1.next()) {
			int id = resultSet1.getInt("id");
			String name = resultSet1.getString("name");
			System.out.println(id + " and " + name);
		}
		
		
		/**************************** 2. 预定义语句 ****************************/
		//1. 预定义语句PreparedStatement，一经创建SQL就不能改变
		//2. 使用?代值参数，index从1开始
		PreparedStatement preparedStatement = connection.prepareStatement("select * from tb_test1 where id = ?");
		preparedStatement.setInt(1, 4);
		ResultSet resultSet2 = preparedStatement.executeQuery();
		while (resultSet2.next()) {
			int id = resultSet2.getInt("id");
			String name = resultSet2.getString("name");
			System.out.println(id + " and " + name);
		}
		
		
		/**************************** 3. 存储过程 ****************************/
		//1. 存储过程的调用
		 /*
		  * 语法：
		  * {?= call <procedure-name>[(<arg1>,<arg2>, ...)]}
		  * {call <procedure-name>[(<arg1>,<arg2>, ...)]}
		  */
		CallableStatement callableStatement = connection.prepareCall("{call proc_1(?, ?)}");//第2个参数是OUT参数
		callableStatement.setInt(1, 4);
		
		//特殊的地方，需要注册返回参数的JDBC类型
		callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
		
		//调用execute来执行，然后继续使用callableStatement提供的get来获取返回值
		callableStatement.execute();//返回的boolean不是判断成功失败的！只是来判断是否是ResultSet类型
		System.out.println(callableStatement.getString(2));
	}
	
}
