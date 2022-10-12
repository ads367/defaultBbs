package kr.co.sppartners.jqueryBoard.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("jqueryBoardDAO")
public class JqueryBoardDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sql;
	
	
	
}
