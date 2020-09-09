package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 * lprod테이블에 새로운 데이터 추가하기
 * 
 * 
 */


public class JdbcTest05 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] inStr = new String[2];
		
		
		System.out.print("lprodgu 입력 : ");
		inStr[0] = scan.nextLine();
		
		if(checkGu(inStr[0]) == 1){
			while(true){
				System.out.println("lprod_pu 가 중복됩니다.");
				System.out.print("lprod_pu 입력 : ");
				inStr[0] = scan.nextLine();
				if(checkGu(inStr[0]) == 0){
					break;
				}
			}
		}
		
		System.out.print("lprod_name 입력 : ");
		inStr[1] = scan.nextLine();
		
		int result = insertGu(inStr);
		
		System.out.println(result + "건이 입력 되었습니다.");
		
	}

	public static int checkGu(String gu){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DBUtil.getConnection();
			
			String sql = "select count(*) cnt from lprod where lprod_gu = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setObject(1, gu);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				result = rs.getInt(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)try {rs.close();} catch (Exception e2) {}
			if(ps!=null)try {ps.close();} catch (Exception e2) {}
			if(conn!=null)try {conn.close();} catch (Exception e2) {}
			
		}
		
		return result;
	}
	
	public static int insertGu(String[] inputs){
		Connection conn = null;
		PreparedStatement ps = null;
		int result=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jun","java");
			
			String sql = "insert into lprod (LPROD_ID, LPROD_GU, LPROD_NM)"
					+ " values ( (select NVL(max(LPROD_ID),0)+ 1 from lprod ) , ? ,? )";
			
			ps = conn.prepareStatement(sql);
			
			ps.setObject(1, inputs[0]);
			ps.setObject(2, inputs[1]);
			
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ps!=null)try {ps.close();} catch (Exception e2) {}
			if(conn!=null)try {conn.close();} catch (Exception e2) {}
			
		}
		
		
		
		
		return result;
		
	}
}
