package kr.co.sppartners.board.webJquery;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sppartners.board.service.BoardService;
import kr.co.sppartners.board.vo.BoardVO;

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
	public String list(@ModelAttribute BoardVO boardVO, Model model) throws Exception {
		boardVO.setPerPage(5);
		boardVO.setPagingCnt(3);
		int totalCnt = boardService.findAllBbsCnt(boardVO);
		boardVO.setTotalCnt(totalCnt);
		
		model.addAttribute("list", boardService.findAllBbs(boardVO));
		model.addAttribute("boardVO", boardVO);
		
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
	
	/**
	 * Jquery 게시판 등록 처리
	 * @throws Exception
	 */
	@RequestMapping("/writeAction.do")
	public String writeAction(@ModelAttribute BoardVO boardVO, Model model) throws Exception {
		boardService.saveBbs(boardVO);
		return "redirect:/jqueryBoard/list.do?nowPage=1";
	}
	
	/**
	 * Jquery 게시판 상세 조회
	 * @throws Exception
	 */
	@RequestMapping("/read.do")
	public String read(@ModelAttribute BoardVO boardVO, Model model) throws Exception {
		model.addAttribute("info", boardService.findBbs(boardVO));
		return "board_jquery/read.tiles";
	}
}
