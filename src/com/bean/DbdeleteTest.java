package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbdeleteTest {
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
		//4.ִ�����ӱ������ݵ�sql���
		String sql="delete from student where stuid=2";
		int rows=st.executeUpdate(sql);
		if(rows>0){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}
		//�ر�����
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
