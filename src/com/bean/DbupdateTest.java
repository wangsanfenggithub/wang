package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DbupdateTest {
 public static void main(String[] args) {
	 try {
		//1.数据库加载
		Class.forName("com.mysql.jdbc.Driver");
		//2.使用驱动管理器类获取数据库连接对象
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/db", 
				"root", 
				"root"
				);
		//3.获取语句执行器类对象
		Statement st=conn.createStatement();
		//4.执行增加表中数据的sql语句
		String sql="update student set sname=?,sex=?,address=?,birthday=?,classid=? where stuid=?";
		//5.使用预处理语句执行器对象，执行sql语句
		PreparedStatement ps=conn.prepareStatement(sql);
		  //5-1设置参数
		 ps.setString(1, "李四");
		 ps.setString(2, "女");
		 ps.setString(3, "长安");
		 ps.setString(4, "1992-11-04");
		 ps.setInt(5, 2);
		 ps.setInt(6, 3);
		 int rows=ps.executeUpdate();//执行
		if(rows>0){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
		//关闭连接
				st.close();
				conn.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
