package kr.co.sppartners.board.webJquery;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.sppartners.board.service.BoardService;
import kr.co.sppartners.board.vo.BoardVO;

@RestController
@RequestMapping("/jqueryBoard/ajax")
public class JqueryBoardRestController {
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	/**
	 * 등록
	 * @throws Exception
	 */
	@RequestMapping("/write.ajax")
	public Map<String, Object> write(@RequestBody BoardVO boardVO) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", boardService.saveBbs(boardVO));
		return result;
	}

}
