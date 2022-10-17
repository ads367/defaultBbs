package kr.co.sppartners.like.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.sppartners.like.vo.LikeVO;

@Repository("likeDAO")
public class LikeDAO {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sql;
	
	/**
	 * 좋아요 중복 확인
	 * @param LikeVO
	 * @throws Exception
	 */
	public int findOverlapLike(LikeVO likeVO) throws Exception {
		return sql.selectOne("findOverlapLike", likeVO);
	}
	
	/**
	 * 좋아요 등록
	 * @param LikeVO
	 * @throws Exception
	 */
	public int saveLike(LikeVO likeVO) throws Exception {
		return sql.insert("saveLike", likeVO);
	}
	
}
