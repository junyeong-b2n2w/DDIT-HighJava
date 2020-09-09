package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//
public class DBUtil {

	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection(){
		
		
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jun","java");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
//			e.printStackTrace();
			return null;
		}
		
	}
	
}
