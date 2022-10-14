package kr.co.sppartners.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.sppartners.board.dao.BoardDAO;
import kr.co.sppartners.board.vo.BoardVO;

@Service("boardService")
public class BoardService {
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	/**
	 * 게시판 목록 조회
	 * @param 
	 * @throws Exception
	 */
	public List<BoardVO> findAllBbs() throws Exception {
		return boardDAO.findAllBbs();
	}
	
	/**
	 * 게시판 등록
	 * @param BoardVO
	 * @throws Exception
	 */
	public int saveBbs(BoardVO boardVO) throws Exception {
		// 아이디 가장 큰 값에 + 1
		int bbsId = boardDAO.findBbsMaxId() + 1;
		boardVO.setBbsId(bbsId);
		
		// 등록
		int result = boardDAO.saveBbs(boardVO);
		
		return result;
	}
	
}
