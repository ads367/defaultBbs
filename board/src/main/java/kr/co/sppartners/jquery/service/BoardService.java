package kr.co.sppartners.jquery.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import kr.co.sppartners.jquery.dao.BoardDAO;
import kr.co.sppartners.jquery.vo.BoardVO;

@Service("boardService")
public class BoardService {
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	/**
	 * 게시판 목록 조회
	 * @param 
	 * @throws Exception
	 * @return List<BoardVO>
	 */
	public List<BoardVO> findAllBbs(BoardVO boardVO) throws Exception {
		return boardDAO.findAllBbs(boardVO);
	}
	
	/**
	 * 게시판 목록 갯수 조회
	 * @param BoardVO
	 * @throws Exception
	 * @return int
	 */
	public int findAllBbsCnt(BoardVO boardVO) throws Exception {
		return boardDAO.findAllBbsCnt(boardVO);
	}
	
	/**
	 * 게시판 등록
	 * @param BoardVO
	 * @throws Exception
	 * @return int
	 */
	public int saveBbs(BoardVO boardVO) throws Exception {
		// 아이디 가장 큰 값에 + 1
		int bbsId = boardDAO.findBbsMaxId() + 1;
		boardVO.setBbsId(bbsId);
		
		// 등록
		int result = boardDAO.saveBbs(boardVO);
		
		return result;
	}
	
	/**
	 * 게시판 조회수 증가
	 * @param BoardVO
	 * @throws Exception
	 * @return int
	 */
	public int updateBbsReadCnt(BoardVO boardVO) throws Exception {
		return boardDAO.updateBbsReadCnt(boardVO);
	}
	
	/**
	 * 게시판 상세조회
	 * @param BoardVO
	 * @throws Exception
	 * @return BoardVO
	 */
	public BoardVO findBbs(BoardVO boardVO, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		/* 조회수 중복 방지 */
		Cookie cookie = null;					// 비교를 위해 쿠키 생성
		Cookie[] cookies = req.getCookies();	// 쿠키 호출
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("viewBbs")) cookie = c;
			}
		}
		// 쿠키가 존재할 경우
		if(cookie != null) {
			if(!cookie.getValue().contains("[" + boardVO.getBbsId() + "]")) {		// 쿠키는 존재하나 해당 값이 없을 경우
				updateBbsReadCnt(boardVO);	// 조회수 증가
				cookie.setValue(cookie.getValue() + "_[" + boardVO.getBbsId() + "]");	// 쿠키 값 추가
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24);		// 쿠키 시간
				res.addCookie(cookie);	// 쿠키 추가
			}
		// 쿠키가 존재하지 않을 경우
		} else {
			updateBbsReadCnt(boardVO);	// 조회수 증가
			Cookie newCookie = new Cookie("viewBbs", "[" + boardVO.getBbsId() + "]");	// 신규 쿠키 생성(쿠키명, 값)
				   newCookie.setPath("/");
				   newCookie.setMaxAge(60 * 60 * 24);	// 쿠키 시간
			res.addCookie(newCookie);	// 쿠키 추가
		}
		/* 조회수 중복 방지 */
		
		return boardDAO.findBbs(boardVO);
	}
	
	/**
	 * 게시판 삭제
	 * @param BoardVO
	 * @throws Exception
	 * @return int
	 */
	public int delBbs(BoardVO boardVO) throws Exception {
		return boardDAO.delBbs(boardVO);
	}
	
	/**
	 * 게시판 수정
	 * @param BoardVO
	 * @throws Exception
	 * @return int
	 */
	public int updateBbs(BoardVO boardVO) throws Exception {
		return boardDAO.updateBbs(boardVO);
	}
	
}
