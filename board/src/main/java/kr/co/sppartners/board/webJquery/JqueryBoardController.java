package kr.co.sppartners.board.webJquery;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
		String url = "/jqueryBoard/list.do?nowPage=1";
		return "redirect:" + url;
	}
	
	/**
	 * Jquery 게시판 상세 조회
	 * @throws Exception
	 */
	@RequestMapping("/read.do")
	public String read(@ModelAttribute BoardVO boardVO, Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		model.addAttribute("info", boardService.findBbs(boardVO, req, res));
		model.addAttribute("search", boardVO);
		return "board_jquery/read.tiles";
	}
	
	/**
	 * Jquery 게시판 삭제
	 * @throws Exception
	 */
	@RequestMapping("/del.do")
	public String del(@ModelAttribute BoardVO boardVO, Model model) throws Exception {
		boardService.delBbs(boardVO);
		String url = "/jqueryBoard/list.do?nowPage="+ boardVO.getNowPage();
			   url += "&searchType="+ boardVO.getSearchType();
			   url += "&searchKeyword="+ boardVO.getSearchKeyword();
		return "redirect:" + url;
	}
	
	/**
	 * Jquery 게시판 수정 페이지로 이동
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public String update(@ModelAttribute BoardVO boardVO, Model model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		model.addAttribute("info", boardService.findBbs(boardVO, req, res));
		model.addAttribute("search", boardVO);
		return "board_jquery/update.tiles";
	}
	
	/**
	 * Jquery 게시판 수정 처리
	 * @throws Exception
	 */
	@RequestMapping("/updateAction.do")
	public String updateAction(@ModelAttribute BoardVO boardVO) throws Exception {
		boardService.updateBbs(boardVO);
		String url = "/jqueryBoard/read.do?bbsId="+ boardVO.getBbsId();
			   url += "&nowPage="+ boardVO.getNowPage();
			   url += "&searchType="+ boardVO.getSearchType();
			   url += "&searchKeyword="+ boardVO.getSearchKeyword();
		return "redirect:" + url;
	}
}
