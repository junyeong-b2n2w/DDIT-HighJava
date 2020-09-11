package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao{

	@Override
	public int insertMember(MemberVO memVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt =0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "INSERT INTO mymember (mem_id, mem_name, mem_tel, mem_addr) values (?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			
			cnt = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
			if(conn!=null)try {conn.close();} catch (Exception e2) {}
		}
		return cnt;
		
			
		
	}

	@Override
	public int deleteMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt =0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "DELETE mymember where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			cnt = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
			if(conn!=null)try {conn.close();} catch (Exception e2) {}
		}
		return cnt;
		
	}

	@Override
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int cnt =0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "UPDATE mymember SET mem_id = ?, mem_name = ? , mem_tel = ? , mem_addr = ? where mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			pstmt.setString(5, memVo.getMem_id());
			
			cnt = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
			if(conn!=null)try {conn.close();} catch (Exception e2) {}
		}
		return cnt;
		
			
		
		
	}

	@Override
	public List<MemberVO> getAllMember() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<MemberVO> list = new ArrayList<>();
		try {
			conn = DBUtil3.getConnection();
			String sql =  "SELECT * FROM mymember";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//?
			while(rs.next()){
				MemberVO out = new MemberVO();
				out.setMem_id(rs.getString("mem_id"));
				out.setMem_name(rs.getString("mem_name"));
				out.setMem_tel(rs.getString("mem_tel"));
				out.setMem_addr(rs.getString("mem_addr"));
				list.add(out);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)try {rs.close();} catch (Exception e2) {}
			if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
			if(conn!=null)try {conn.close();} catch (Exception e2) {}
		}
		
		return list;
		
		
		
		
		
		
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt =0;
		try {
			conn = DBUtil3.getConnection();
			String sql =  "SELECT count(*) FROM mymember WHERE mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,memId);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
				cnt = Integer.valueOf(String.valueOf(rs.getObject(1)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)try {rs.close();} catch (Exception e2) {}
			if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
			if(conn!=null)try {conn.close();} catch (Exception e2) {}
		}
		
		return cnt;
		
			

		
	}

	
}
