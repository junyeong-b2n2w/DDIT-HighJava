package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jun","java");
				
			System.out.println("게좌 번호정보 추가하기");
			System.out.print("계좌번호 : ");
			String bankNo = scan.next();
			
			System.out.print("은 행 명 : ");
			String bankName = scan.next();
			
			System.out.print("예금주명: ");
			String bankUser = scan.next();
			
			//Statement 객체를 이용해서 데이터 추가하기
			
			String sql = "insert into bankinfo (bank_no, bank_name, bank_user_name, bank_date) "
					+ " values ( '" + bankNo + "' , '" + bankName + "' , '" + bankUser + "' , sysdate )";
			
			stmt = conn.createStatement();
			
			int cnt = stmt.executeUpdate(sql);
			
			System.out.println("반환값 : " + cnt);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(stmt!=null)try {stmt.close();} catch (Exception e2) {}
			if(conn!=null)try {conn.close();} catch (Exception e2) {}
			
		}
	}

}
