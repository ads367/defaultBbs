package kr.co.sppartners.vue.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.sppartners.jquery.vo.BoardVO;
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
	
}
