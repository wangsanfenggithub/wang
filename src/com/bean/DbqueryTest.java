package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbqueryTest {
 public static void main(String[] args) {
	 try {
		//1.���ݿ����
		Class.forName("com.mysql.jdbc.Driver");
		//2.ʹ���������������ȡ���ݿ����Ӷ���
		Connection conn=DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/db", 
				"root", 
				"root"
				);
		//3.��ȡ���ִ���������
		Statement st=conn.createStatement();
		//4.ִ�в�ѯ�������ݵ�sql��䣬��ȡ���������
		String sql="select * from  student";
		ResultSet rst=st.executeQuery(sql);
		while (rst.next()) {
			System.out.println("��ţ�"+rst.getInt(1));
			System.out.println("������"+rst.getString(2));
			System.out.println("�Ա�"+rst.getString(3));
			System.out.println("סַ��"+rst.getString(4));
			System.out.println("���գ�"+rst.getString(5));
			System.out.println("�༶��"+rst.getInt(6));
			
		}
		//�ر�����
				st.close();
				rst.close();
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
