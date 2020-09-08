package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제 1) 사용자로부터 Lprod_id 값을 입력받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오

// 문제 2) lprod_id 값을 2개 입력받아서 두값 중 작은값부터 큰값 사이의 자료들을 출력하시오.

public class JdbcTest02 {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자입력!");
		int input = Integer.parseInt(scan.nextLine());
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jun","java");
			
					
			String sql = "select * from lprod where lprod_id > " + input;
			

			

			stmt = conn.createStatement();

		
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				System.out.println("Lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("Lprod_gu : " + rs.getString(2));
				System.out.println("Lprod_nm : " + rs.getString("lprod_nm"));
				System.out.println("-----------");
			}
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null)try {rs.close();} catch (Exception e2) {}
			if(stmt!=null)try {stmt.close();} catch (Exception e2) {}
			if(conn!=null)try {conn.close();} catch (Exception e2) {}
			
		}
		
		
	
		
	}

}
