package kr.or.ddit.mvc.dao;

import kr.or.ddit.mvc.vo.BoardVO;

import java.util.List;


/**
 * 실제 db와 연결해서 sql문을 수행하여 결과를 작성해서 
 * Service에 전달하는  Dao와 interface
 * 
 * @author PC-25
 *
 */

public interface IBoardDao {

	public int insertBoard(BoardVO boardVO);
	
	

	public int deleteBoard(int boardNo);
	

	public int updateBoard(BoardVO boardVO);
	

	public List<BoardVO> getAllBoard();

	public List<BoardVO> getSelectBoard(String query);
	
	
	public BoardVO getBoardPost(int BoardNo);
	

	
}
