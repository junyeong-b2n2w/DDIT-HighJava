package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


//
public class DBUtil2 {

	private static Properties prop;
	
	
	
	
	static{
		prop = new Properties();
		File file = new File("res/dbinfo.properties");
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream(file);
			
			prop.load(fin);
			
			
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection(){
		
		
		try {
			return DriverManager.getConnection(prop.getProperty("url") , prop.getProperty("user"),prop.getProperty("pass"));
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
//			e.printStackTrace();
			return null;
		}
		
	}
	
}
