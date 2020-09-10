package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;

public class JdbcTest06 {

	
	public static void main(String[] args) {
		new JdbcTest06().start();
	}

	private void start() {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		
		while(true){
		System.out.println("--- 작 업 선 택 ---");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 종료");
		System.out.println("---------------");
		System.out.print("입력 >>");
		input = Integer.parseInt(scan.nextLine());
		
		switch (input) {
		case 1:
			dataInsert();
			
			break;
		case 2:
			dataDelete();
			break;
		case 3:
			dataUpdate();
			break;
		case 4:
			showData();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			
			break;

		
		
			}
		}
		
		
	}

	private void showData() {
		
		List<Map<String, Object>> memList = selectAll();
		System.out.println("----------전체데이터 -------");
		System.out.println("ID\tName\tTel\tAddr");
		for(Map<String, Object> mem : memList){
			System.out.println(mem.get("MEM_ID") + "\t"+mem.get("MEM_NAME") + "\t"+
					mem.get("MEM_TEL") + "\t"+mem.get("MEM_ADDR"));
		}
		System.out.println("------------------------");
		
		
	}



	private void dataUpdate() {
		Scanner scan = new Scanner(System.in);
		List<String> param = new ArrayList<>();
		
		System.out.println("자료를 수정합니다.");
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		
		if(idCheck(id) == 0){
			while(true){
			System.out.println("해당 아이디가 존재하지 않습니다.");
			System.out.print("아이디 : ");
			id = scan.nextLine();
			if(idCheck(id) ==1) break;
			}
		}
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("연락처 : ");
		String tel = scan.nextLine();
		System.out.print("주소 : ");
		String addr = scan.nextLine();
		
		param.add(id);
		param.add(name);
		param.add(tel);
		param.add(addr);
		param.add(id);
		
		String sql = "UPDATE mymember SET mem_id = ?, mem_name = ? , mem_tel = ? , mem_addr = ? where mem_id = ?";
		
		int result = jdbcUpdate(sql, param);
		
		System.out.println(result + "건 수정 성공하였습니다.");
		
		return;
	}

	

	private void dataDelete() {
		Scanner scan = new Scanner(System.in);
		List<String> param = new ArrayList<>();
		
		System.out.println("자료를 삭제합니다.");
		System.out.print("삭제할 아이디 : ");
		String id = scan.nextLine();
		
		if(idCheck(id) == 0){
			while(true){
			System.out.println("해당 아이디가 존재하지 않습니다.");
			System.out.print("아이디 : ");
			id = scan.nextLine();
			if(idCheck(id) ==1) break;
			}
		}
		
		
		param.add(id);
			
		String sql = "DELETE mymember where mem_id = ?";
		
		int result = jdbcUpdate(sql, param);
		
		System.out.println(result + "건 삭제 성공하였습니다.");
		
		return;
	}

	private void dataInsert() {
		Scanner scan = new Scanner(System.in);
		List<String> param = new ArrayList<>();
		
		System.out.println("자료를 입력합니다.");
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		
		// 아이디 중복확인
		if(idCheck(id) == 1){
			while(true){
			System.out.println("해당 아이디가 존재합니다 다른 아이디를 입력해주세요");
			System.out.print("아이디 : ");
			id = scan.nextLine();
			if(idCheck(id) ==0) break;
			}
		}
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("연락처 : ");
		String tel = scan.nextLine();
		System.out.print("주소 : ");
		String addr = scan.nextLine();
		
		param.add(id);
		param.add(name);
		param.add(tel);
		param.add(addr);
		
		String sql = "INSERT INTO mymember (mem_id, mem_name, mem_tel, mem_addr) values (?,?,?,?)";
		
		int result = jdbcUpdate(sql, param);
		
		System.out.println(result + "건 등록 성공하였습니다.");
		
		return;
	}

	private int jdbcUpdate(String sql, List<String> param) {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		int result =0;
		try {
			ps = con.prepareStatement(sql);
		
		
		
		for(int i =0 ; i < param.size(); i++){
			ps.setObject(i+1, param.get(i));
		}
		
		result = ps.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ps!=null)try {ps.close();} catch (Exception e2) {}
			if(con!=null)try {con.close();} catch (Exception e2) {}
		}
		return result;
	}

	private int idCheck(String id) {
		
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			String sql = "SELECT count(*) FROM mymember WHERE mem_id = ?";
			ps = con.prepareStatement(sql);
		
		
		
		
			ps.setObject(1, id);
		
			rs = ps.executeQuery();
		while(rs.next()){
			result = Integer.valueOf(String.valueOf(rs.getObject(1)));
		}
		
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null)try {rs.close();} catch (Exception e2) {}
			if(ps!=null)try {ps.close();} catch (Exception e2) {}
			if(con!=null)try {con.close();} catch (Exception e2) {}
		}
		return result;
	}
	
	private List<Map<String, Object>> selectAll() {
		
//		Connection con = DBUtil.getConnection();
		Connection con = DBUtil2.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM mymember";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			
			int columnCount = md.getColumnCount();
			
			while(rs.next()){
				HashMap<String, Object> row = new HashMap<String, Object>();
				for (int i = 1 ; i<= columnCount; i++){
					String key = md.getColumnLabel(i);
					Object value = rs.getObject(i);
					row.put(key, value);
					
				}
			
				list.add(row);
			}
		
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null)try {rs.close();} catch (Exception e2) {}
			if(ps!=null)try {ps.close();} catch (Exception e2) {}
			if(con!=null)try {con.close();} catch (Exception e2) {}
		}
		return list;
		
		
	}
}
