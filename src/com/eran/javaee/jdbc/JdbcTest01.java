package com.eran.javaee.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.xdevapi.JsonString;

import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONFunctions;

public class JdbcTest01 {
	/*
	 * 总结一下java ee 十三式，巩固一下认知
	 * 1.JDBC
	 * 		1.1 Statement;静态sql
	 * 		1.2 PrepareStatement;动态sql
	 * 		1.3 CallableStatement;存储过程
	 */
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";
	static final String USER = "root";
	static final String PASS = "";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Properties properties = new Properties();
			properties.setProperty("user", USER);
			properties.setProperty("passward", PASS);
			conn = DriverManager.getConnection(DB_URL, properties);
//			
//			stmt = conn.createStatement();
//			String sql = "select id,name from employee";
//			ResultSet res = stmt.executeQuery(sql);
//			
//			while(res.next()) {
//				int id = res.getInt("id");
//				String name = res.getString("name");
//				System.out.println(id + "," + name);
//			}
//			res.close();
//			stmt.close();
//			conn.close();
//			-----------------------
//			PreparedStatement prepareStatement = conn.prepareStatement("update employee set name = ? where id = 1");
//			prepareStatement.setString(1, "prepareStatement");
//			int executeUpdate = prepareStatement.executeUpdate();
//			System.out.println(executeUpdate);
//			
//			PreparedStatement prepareStatement2 = conn.prepareStatement("select * from employee where id = 1");
//			ResultSet executeQuery = prepareStatement2.executeQuery();
//			while(executeQuery.next()) {
//				System.out.println(executeQuery.getString("name"));
//			}
//			prepareStatement.close();
//			conn.close();
//			-------------------------
			String sql = "{call first_procedure(?,?)}";
			CallableStatement prepareCall = conn.prepareCall(sql);
			prepareCall.setInt(1, 1);
			prepareCall.registerOutParameter(2, java.sql.Types.VARCHAR);
			prepareCall.execute();
			String empName = prepareCall.getString(2);
			System.out.println(empName);
			prepareCall.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
