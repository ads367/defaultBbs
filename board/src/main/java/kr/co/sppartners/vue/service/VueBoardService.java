package kr.co.sppartners.vue.service;

import java.util.List;

import javax.annotation.Resource;

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
	 * 게시판 상세 조회
	 * @param VueBoard
	 * @throws Exception
	 * @return VueBoard
	 */
	public VueBoard findBbs(VueBoard vueBoard) throws Exception {
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
