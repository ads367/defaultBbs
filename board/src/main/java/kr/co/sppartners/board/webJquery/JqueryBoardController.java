package kr.co.sppartners.board.webJquery;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sppartners.board.service.BoardService;

@Controller
@RequestMapping("/jqueryBoard")
public class JqueryBoardController {
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	/**
	 * Jquery 게시판 목록으로 이동
	 * @throws Exception
	 */
	@RequestMapping("/list.do")
	public String list(Model model) throws Exception {
		
		model.addAttribute("list", boardService.findAllBbs());
		
		return "board_jquery/list.tiles";
	}
	
	/**
	 * Jquery 게시판 등록 페이지로 이동
	 * @throws Exception
	 */
	@RequestMapping("/write.do")
	public String write() throws Exception {
		return "board_jquery/write.tiles";
	}
	
}
