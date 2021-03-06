package kr.or.ddit.mvc.service;

import kr.or.ddit.mvc.dao.BoardDaoImpl;
import kr.or.ddit.mvc.dao.IBoardDao;
import kr.or.ddit.mvc.vo.BoardVO;

import java.util.List;

public class BoardServiceImpl implements IBoardService {
	private IBoardDao dao; // dao 객체 변수 생성

	public BoardServiceImpl() {
		dao = new BoardDaoImpl();
	}


	@Override
	public int insertBoard(BoardVO boardVO) {
		return dao.insertBoard(boardVO);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return dao.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return dao.updateBoard(boardVO);
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return dao.getAllBoard();
	}

	@Override
	public BoardVO getBoardPost(int BoardNo) {
		return dao.getBoardPost(BoardNo);
	}


	@Override
	public List<BoardVO> getSelectBoard(String query) {
		return dao.getSelectBoard(query);
	}
}
