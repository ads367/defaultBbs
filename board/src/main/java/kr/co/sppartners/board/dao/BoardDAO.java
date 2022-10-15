package kr.co.sppartners.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.sppartners.board.vo.BoardVO;

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
		return sql.selectList("findAllBbs", boardVO);
	}
	
	/**
	 * 게시판 목록 갯수 조회
	 * @param BoardVO
	 * @throws Exception
	 */
	public int findAllBbsCnt(BoardVO boardVO) throws Exception {
		return sql.selectOne("findAllBbsCnt", boardVO);
	}
	
	/**
	 * 게시판 아이디 가장 큰 값 호출
	 * @param 
	 * @throws Exception
	 */
	public int findBbsMaxId() throws Exception {
		return sql.selectOne("findBbsMaxId");
	}
	
	/**
	 * 게시판 등록
	 * @param BoardVO
	 * @throws Exception
	 */
	public int saveBbs(BoardVO boardVO) throws Exception {
		return sql.insert("saveBbs", boardVO);
	}
	
	/**
	 * 게시판 상세조회
	 * @param BoardVO
	 * @throws Exception
	 */
	public BoardVO findBbs(BoardVO boardVO) throws Exception {
		return sql.selectOne("findBbs", boardVO);
	}
	
}
