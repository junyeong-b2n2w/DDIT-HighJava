package kr.or.ddit.mvc.dao;

import kr.or.ddit.mvc.vo.BoardVO;
import kr.or.ddit.util.DBUtil3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements IBoardDao{





	@Override
	public int insertBoard(BoardVO boardVO) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		int cnt =0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "INSERT INTO jdbc_board (board_no , board_title, board_writer, board_date, " +
					" board_cnt, board_content) values (board_seq.nextval , ?, ? ,sysdate , 0, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getBoard_title());
			pstmt.setString(2, boardVO.getBoard_writer());
			pstmt.setString(3, boardVO.getBoard_content());


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
	public int deleteBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int cnt =0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "DELETE jdbc_board where board_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

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
	public int updateBoard(BoardVO boardVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int cnt =0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "UPDATE jdbc_board SET board_title = ?, board_content = ? where board_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getBoard_title());
			pstmt.setString(2, boardVO.getBoard_content());
			pstmt.setInt(3, boardVO.getBoard_no());



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
	public List<BoardVO> getAllBoard() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BoardVO> list = new ArrayList<>();
		try {
			conn = DBUtil3.getConnection();
			String sql =  "SELECT * FROM jdbc_board";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			//?
			while(rs.next()){
				BoardVO out = new BoardVO();
				out.setBoard_no(rs.getInt("board_no"));
				out.setBoard_title(rs.getString("board_title"));
				out.setBoard_writer(rs.getString("board_writer"));
				out.setBoard_content(rs.getString("board_content"));
				out.setBoard_cnt(rs.getInt("board_cnt"));
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
	public BoardVO getBoardPost(int BoardNo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO out = null;
		try {
			conn = DBUtil3.getConnection();
			String sql =  "SELECT * FROM jdbc_board WHERE board_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,BoardNo);

			rs = pstmt.executeQuery();


			while(rs.next()){
				out = new BoardVO();
				out.setBoard_no(rs.getInt("board_no"));
				out.setBoard_title(rs.getString("board_title"));
				out.setBoard_writer(rs.getString("board_writer"));
				out.setBoard_content(rs.getString("board_content"));
				out.setBoard_cnt(rs.getInt("board_cnt"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)try {rs.close();} catch (Exception e2) {}
			if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
			if(conn!=null)try {conn.close();} catch (Exception e2) {}
		}


		return out;

	}

	@Override
	public List<BoardVO> getSelectBoard(String query) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BoardVO> list = new ArrayList<>();
		try {
			conn = DBUtil3.getConnection();
			String sql =  "SELECT * FROM jdbc_board WHERE board_title Like '%'||?||'%'";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, query);
			
			
			rs = pstmt.executeQuery();

			//?
			while(rs.next()){
				BoardVO out = new BoardVO();
				out.setBoard_no(rs.getInt("board_no"));
				out.setBoard_title(rs.getString("board_title"));
				out.setBoard_writer(rs.getString("board_writer"));
				out.setBoard_content(rs.getString("board_content"));
				out.setBoard_cnt(rs.getInt("board_cnt"));
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
}
