package kr.or.ddit.board.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.mvc.dao.MemberDaoImpl;

public class BoardDaoImpl implements IBoardDao{

	private static BoardDaoImpl dao;
	private SqlMapClient smc;

	private BoardDaoImpl() {
		try {
			
			
			//1. iBatis설정 파일을 읽어와서 실행한다. (sqlMapConfig.xml파일)
			// 1-1. 문자인코딩 케릭터 셋 설정
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			// 1-2. 환경 설정파일 읽어오기
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 환경설정을 완성한 후 
			// 		SQL문을 호출해서 실행할 수 있는 객체를 생성한다.
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close(); // 스트림 닫기
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public static BoardDaoImpl getInstance(){
		if(dao == null){
			dao = new BoardDaoImpl();
		}
		
		return dao;
	}
	
	@Override
	public int insertBoard(BoardVO boardVO) {


		int cnt =0;
		try {
			Object obj = smc.insert("myboard.insertBoard",boardVO);
			if(obj==null) cnt=1;
			


		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
		
	}

	@Override
	public int deleteBoard(int boardNo) {

		int cnt =0;
		try {
			cnt = smc.delete("myboard.deleteBoard", boardNo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;

	
	}
	@Override
	public int updateBoard(BoardVO boardVO) {

		int cnt =0;
		try {
			cnt = smc.update("myboard.updateBoard", boardVO);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;

		
	}

	@Override
	public List<BoardVO> getAllBoard() {


		List<BoardVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("myboard.getAllBoard");



		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	
	}
	@Override
	public BoardVO getBoardPost(int boardNo) {
		 BoardVO out = null;
		try {
			out = (BoardVO)smc.queryForObject("myboard.getOneBoard",boardNo);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return out;

	
	}
	@Override
	public List<BoardVO> getSelectBoard(String query) {
		

		List<BoardVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("myboard.getSearchBoard",query);


		} catch (Exception e) {
			e.printStackTrace();
	}
		return list;
	}
}