package kr.co.sppartners.jqueryBoard.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.sppartners.jqueryBoard.dao.JqueryBoardDAO;

@Service("jqueryBoardService")
public class JqueryBoardService {
	
	@Resource(name="jqueryBoardDAO")
	private JqueryBoardDAO jqueryBoardDAO;
	
	

}
