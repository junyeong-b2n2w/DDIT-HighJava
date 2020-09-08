package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest01 {

	public static void main(String[] args) {
		//DB작업에 필요한 객체변수들 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB시스템 접속 => Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "jun","java");
			
					
			//3. SQL문 작성
			String sql = "select * from lprod";
			

			//4. statement 객체 생성
			stmt = conn.createStatement();
			
			//5. SQL문을 DB서버로 보내서 결과를 얻어온다
			rs = stmt.executeQuery(sql);
			
			//6. 결과 처리하기 => 한 레크드씩 화면에 출력하기
			//		(ResultSet 에 저장된 데이터를 차례로 꺼내오려면 반복문과 next()메서드를 이용한다,)
			
			// rs.next()  => ResultSet객체의 데이터를 가르키는 포인터를
			//					다음번째 레코드 위치로 이동시키고 그곳에 데이터가 있으면 true, 없으면false;
			while(rs.next()){
				//포인터가 가리키는 위치의 데이터를 가져오는 방법
				// 형식 1) rs.get자료형이름("컬럼명");
				// 형식 2) rs.get자료형이름(컬럼번호); => 1부터시작
				// 형식 3) rs.get자료형이름("컬럼의 alias명");
				
				System.out.println("Lprod_id : " + rs.getInt("lprod_id"));
				System.out.println("Lprod_gu : " + rs.getString(2));
				System.out.println("Lprod_nm : " + rs.getString("lprod_nm"));
				System.out.println("-----------------------");
				
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
