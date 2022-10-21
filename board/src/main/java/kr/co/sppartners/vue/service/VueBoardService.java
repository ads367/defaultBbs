package kr.co.sppartners.vue.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import kr.co.sppartners.vue.dao.VueBoardDAO;
import kr.co.sppartners.vue.vo.VueBoard;

@Service("vueBoardService")
public class VueBoardService {
	
	@Resource(name="vueBoardDAO")
	private VueBoardDAO vueBoardDAO;
	
	/**
	 * 게시판 목록 조회
	 * @param 
	 * @throws Exception
	 * @return List<VueBoard>
	 */
	public List<VueBoard> findAllBbs(VueBoard vueBoard) throws Exception {
		return vueBoardDAO.findAllBbs(vueBoard);
	}
	
	/**
	 * 게시판 목록 갯수 조회
	 * @param VueBoard
	 * @throws Exception
	 * @return int
	 */
	public int findAllBbsCnt(VueBoard vueBoard) throws Exception {
		return vueBoardDAO.findAllBbsCnt(vueBoard);
	}
	
	/**
	 * 게시판 조회수 증가
	 * @param VueBoard
	 * @throws Exception
	 * @return int
	 */
	public int updateBbsReadCnt(VueBoard vueBoard) throws Exception {
		return vueBoardDAO.updateBbsReadCnt(vueBoard);
	}
	
	/**
	 * 게시판 상세 조회
	 * @param VueBoard
	 * @throws Exception
	 * @return VueBoard
	 */
	public VueBoard findBbs(VueBoard vueBoard, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
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
			if(!cookie.getValue().contains("[" + vueBoard.getBbsId() + "]")) {		// 쿠키는 존재하나 해당 값이 없을 경우
				updateBbsReadCnt(vueBoard);	// 조회수 증가
				cookie.setValue(cookie.getValue() + "_[" + vueBoard.getBbsId() + "]");	// 쿠키 값 추가
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24);		// 쿠키 시간
				res.addCookie(cookie);	// 쿠키 추가
			}
		// 쿠키가 존재하지 않을 경우
		} else {
			updateBbsReadCnt(vueBoard);	// 조회수 증가
			Cookie newCookie = new Cookie("viewBbs", "[" + vueBoard.getBbsId() + "]");	// 신규 쿠키 생성(쿠키명, 값)
				   newCookie.setPath("/");
				   newCookie.setMaxAge(60 * 60 * 24);	// 쿠키 시간
			res.addCookie(newCookie);	// 쿠키 추가
		}
		/* 조회수 중복 방지 */
		
		return vueBoardDAO.findBbs(vueBoard);
	}
	
	/**
	 * 게시판 삭제
	 * @param VueBoard
	 * @throws Exception
	 * @return int
	 */
	public int delBbs(VueBoard vueBoard) throws Exception {
		return vueBoardDAO.delBbs(vueBoard);
	}
	
	/**
	 * 게시판 등록 및 수정 페이지 이동
	 * @param VueBoard
	 * @throws Exception
	 * @return VueBoard
	 */
	public VueBoard upsert(VueBoard vueBoard) throws Exception {
		VueBoard result = new VueBoard();
		if(vueBoard.getBbsId() != 0) {
			result = vueBoardDAO.findBbs(vueBoard);
		}
		return result;
	}
	
	/**
	 * 게시판 등록 및 수정 처리
	 * @param VueBoard
	 * @throws Exception
	 * @return VueBoard
	 */
	public VueBoard upsertAction(VueBoard vueBoard) throws Exception {
		if(vueBoard.getBbsId() == 0) {
			vueBoard.setBbsId(vueBoardDAO.findBbsMaxId() + 1);
		}
		vueBoardDAO.upsert(vueBoard);
		return vueBoard;
	}
}
