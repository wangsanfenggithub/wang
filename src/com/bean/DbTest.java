package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest {
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
		String sql="insert into student(sname,sex,address,birthday,classid) values('����','��','����','1990-10-10',1)";
		int rows=st.executeUpdate(sql);
		if(rows>0){
			System.out.println("��ӳɹ�");
		}else{
			System.out.println("���ʧ��");
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
