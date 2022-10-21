package kr.co.sppartners.vue.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.sppartners.vue.service.VueBoardService;
import kr.co.sppartners.vue.vo.VueBoard;

@RestController
@RequestMapping("/vue/json")
public class VueBoardRestController {
	
	private Logger logger = LoggerFactory.getLogger(VueBoardRestController.class);
	
	@Resource(name="vueBoardService")
	private VueBoardService vueBoardService;
	
	/**
	 * Vue 게시판 목록 검색
	 * @throws Exception
	 */
	@RequestMapping("/list.ajax")
	public ModelAndView list(@RequestBody VueBoard vueBoard) throws Exception {
		logger.info("################## Vue list(Ajax) ##################");
		ModelAndView mav = new ModelAndView("jsonView");
		ObjectMapper mapper = new ObjectMapper();
		
		// 목록 갯수 조회
		int totalCnt = vueBoardService.findAllBbsCnt(vueBoard);
		vueBoard.setTotalCnt(totalCnt);
		
		// 목록 조회
		mav.addObject("list", mapper.writeValueAsString(vueBoardService.findAllBbs(vueBoard)));
		mav.addObject("search", mapper.writeValueAsString(vueBoard));
		return mav;
	}
	
}
