package kr.or.ddit.mvc.service;

import kr.or.ddit.mvc.vo.BoardVO;

import java.util.List;




public interface IBoardService {

	public int insertBoard(BoardVO boardVO);



	public int deleteBoard(int boardNo);


	public int updateBoard(BoardVO boardVO);


	public List<BoardVO> getAllBoard();

	public List<BoardVO> getSelectBoard(String query);
	
	public BoardVO getBoardPost(int BoardNo);

}
