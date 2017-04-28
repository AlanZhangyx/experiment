package com.ddup.mysql;

import java.sql.DriverManager;

public class MaxConnection {

	public static void main(String[] args) {
//	    Class.forName("com.mysql.jdbc.Driver");
	    
	    //2、驱动注册过后，可以继续使用这个驱动管理器对象来获取链接对象。
		/*Properties info=new Properties();
		info.put("user", "root");
		info.put("password", "root");
		String url="jdbc:mysql://localhost:3306/test";
		Connection conn=DriverManager.getConnection(url, info);
		//3、有了conn就可以创建三个语句对象了。
	        a: Statement st=conn.createStatement();     //这叫简单语句对象，不能创建的时候直接指定SQL，必须之后执行的时候指定。
	            ResultSet rs=st.executeQuery("select * from firsttable");
	        b: PreparedStatement pst=conn.prepareStatement("select * from firsttable");    //这叫预先编译好的语句对象，必须在创建的时候指定SQL；
	            pst.setString(1, "sss");   //如果有参数，这里是扯淡
	            ResultSet rs=pst.executeQuery();
	        c: CallableStatement cst=conn.prepareCall(query1);   //这是创建一个存储过程语句，query1是string的存储过程。
*/	}

}
