package com.shieldsquare.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	/*static{
		try{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			
		}catch(Exception e){
			System.out.println("Util class Exception:class not found"+e);
		}
	}
	
	
	public static Connection getMSSQLConnection()throws SQLException{
		
		String url="jdbc:sqlserver://gt2nlewnrh.database.windows.net:1433;databaseName=stag-admin-db";
		Connection con=DriverManager.getConnection(url, "kaalbitec@gt2nlewnrh", "shieldsquare@123");
		System.out.println("Util Class_Connecting to DataBase");
		return con;
		
	}*/
	
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getMySqlConnection()throws SQLException{
		System.out.println("Connecting");
		//String url="jdbc:mysql://173.194.250.247:3306;databaseName=stag-admin-db";
	String url="jdbc:mysql://173.194.250.247:3306/stag-admin-db";
		//String url="jdbc:mysql://127.0.0.1:3306/stag-admin-db";
		Connection con=DriverManager.getConnection(url,"ssuser","jnvskjvnksdvnslczfdszv");
		System.out.println("Connectingmysql");
		return con;
	
	}
	
	
	/*public static Connection getMySqlConnection()throws SQLException{
		System.out.println("Connecting");
		//String url="jdbc:mysql://173.194.250.247:3306;databaseName=stag-admin-db";
	String url="jdbc:mysql://173.194.243.223:3306/prod-mysql-db";
		//String url="jdbc:mysql://127.0.0.1:3306/stag-admin-db";
		Connection con=DriverManager.getConnection(url,"ssuser","hdfgdbdxfhdxg");
		System.out.println("Connectingmysql");
		return con;
	
	}*/
		

}
