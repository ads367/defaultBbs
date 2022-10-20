package kr.co.sppartners.jquery.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.sppartners.jquery.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAO {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sql;
	
	/**
	 * 게시판 목록 조회
	 * @param BoardVO
	 * @throws Exception
	 */
	public List<BoardVO> findAllBbs(BoardVO boardVO) throws Exception {
		return sql.selectList("boardDAO.findAllBbs", boardVO);
	}
	
	/**
	 * 게시판 목록 갯수 조회
	 * @param BoardVO
	 * @throws Exception
	 */
	public int findAllBbsCnt(BoardVO boardVO) throws Exception {
		return sql.selectOne("boardDAO.findAllBbsCnt", boardVO);
	}
	
	/**
	 * 게시판 아이디 가장 큰 값 호출
	 * @param 
	 * @throws Exception
	 */
	public int findBbsMaxId() throws Exception {
		return sql.selectOne("boardDAO.findBbsMaxId");
	}
	
	/**
	 * 게시판 등록
	 * @param BoardVO
	 * @throws Exception
	 */
	public int saveBbs(BoardVO boardVO) throws Exception {
		return sql.insert("boardDAO.saveBbs", boardVO);
	}
	
	/**
	 * 게시판 조회수 증가
	 * @param BoardVO
	 * @throws Exception
	 */
	public int updateBbsReadCnt(BoardVO boardVO) throws Exception {
		return sql.update("boardDAO.updateBbsReadCnt", boardVO);
	}
	
	/**
	 * 게시판 상세조회
	 * @param BoardVO
	 * @throws Exception
	 */
	public BoardVO findBbs(BoardVO boardVO) throws Exception {
		return sql.selectOne("boardDAO.findBbs", boardVO);
	}
	
	/**
	 * 게시판 삭제
	 * @param BoardVO
	 * @throws Exception
	 */
	public int delBbs(BoardVO boardVO) throws Exception {
		return sql.update("boardDAO.delBbs", boardVO);
	}
	
	/**
	 * 게시판 수정
	 * @param BoardVO
	 * @throws Exception
	 */
	public int updateBbs(BoardVO boardVO) throws Exception {
		return sql.update("boardDAO.updateBbs", boardVO);
	}
}
