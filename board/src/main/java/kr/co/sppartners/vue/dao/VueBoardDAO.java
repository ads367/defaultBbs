package kr.co.sppartners.vue.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.sppartners.vue.vo.VueBoard;

@Repository("vueBoardDAO")
public class VueBoardDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sql;
	
	/**
	 * 게시판 목록 조회
	 * @param VueBoard
	 * @throws Exception
	 */
	public List<VueBoard> findAllBbs(VueBoard vueBoard) throws Exception {
		return sql.selectList("vueBoardDAO.findAllBbs", vueBoard);
	}
	
	/**
	 * 게시판 목록 갯수 조회
	 * @param VueBoard
	 * @throws Exception
	 */
	public int findAllBbsCnt(VueBoard vueBoard) throws Exception {
		return sql.selectOne("vueBoardDAO.findAllBbsCnt", vueBoard);
	}
	
	/**
	 * 게시판 아이디 가장 큰 값 호출
	 * @param 
	 * @throws Exception
	 */
	public int findBbsMaxId() throws Exception {
		return sql.selectOne("vueBoardDAO.findBbsMaxId");
	}
	
	/**
	 * 게시판 등록
	 * @param VueBoard
	 * @throws Exception
	 */
	public int saveBbs(VueBoard vueBoard) throws Exception {
		return sql.insert("vueBoardDAO.saveBbs", vueBoard);
	}
	
	/**
	 * 게시판 조회수 증가
	 * @param VueBoard
	 * @throws Exception
	 */
	public int updateBbsReadCnt(VueBoard vueBoard) throws Exception {
		return sql.update("vueBoardDAO.updateBbsReadCnt", vueBoard);
	}
	
	/**
	 * 게시판 상세조회
	 * @param VueBoard
	 * @throws Exception
	 */
	public VueBoard findBbs(VueBoard vueBoard) throws Exception {
		return sql.selectOne("vueBoardDAO.findBbs", vueBoard);
	}
	
	/**
	 * 게시판 삭제
	 * @param VueBoard
	 * @throws Exception
	 */
	public int delBbs(VueBoard vueBoard) throws Exception {
		return sql.update("vueBoardDAO.delBbs", vueBoard);
	}
	
	/**
	 * 게시판 수정
	 * @param VueBoard
	 * @throws Exception
	 */
	public int updateBbs(VueBoard vueBoard) throws Exception {
		return sql.update("vueBoardDAO.updateBbs", vueBoard);
	}
	
}
