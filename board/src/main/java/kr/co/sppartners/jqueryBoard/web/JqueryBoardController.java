package kr.co.sppartners.jqueryBoard.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sppartners.jqueryBoard.service.JqueryBoardService;

@Controller
@RequestMapping("/jqueryBoard")
public class JqueryBoardController {
	
	@Resource(name="jqueryBoardService")
	private JqueryBoardService jqueryBoardService;
	
	@RequestMapping("/list.do")
	public String list() throws Exception {
		return "board_jquery/list.tiles";
	}
}
