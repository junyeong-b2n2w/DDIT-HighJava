package kr.or.ddit.basic;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;


// 문제 2) lprod_id 값을 2개 입력받아서 두값 중 작은값부터 큰값 사이의 자료들을 출력하시오.

public class JdbcTest03 {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		
		int[] inputArr = new int[2];
		System.out.println("숫자입력1!");
		inputArr[0] = Integer.parseInt(scan.nextLine());
		System.out.println("숫자입력2!");
		inputArr[1] = Integer.parseInt(scan.nextLine());
		
		Arrays.sort(inputArr);
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jun","java");
			
					
			String sql = "select * from lprod where lprod_id > "
			+ inputArr[0] + " AND lprod_id < " + inputArr[1];
			

			

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
