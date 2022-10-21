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
		
		int totalCnt = vueBoardService.findAllBbsCnt(vueBoard);
		vueBoard.setTotalCnt(totalCnt);
		
		mav.addObject("list", mapper.writeValueAsString(vueBoardService.findAllBbs(vueBoard)));
		mav.addObject("search", mapper.writeValueAsString(vueBoard));
		return mav;
	}
	
	/**
	 * Vue 게시판 삭제
	 * @throws Exception
	 */
	@RequestMapping("/del.ajax")
	public ModelAndView del(@RequestBody VueBoard vueBoard) throws Exception {
		logger.info("################## Vue del(Ajax) ##################");
		ModelAndView mav = new ModelAndView("jsonView");
		vueBoardService.delBbs(vueBoard);
		return mav;
	}
	
	/**
	 * 게시판 등록 및 수정
	 * @throws Exception
	 */
	@RequestMapping("/upsert.ajax")
	public ModelAndView upsert(@RequestBody VueBoard vueBoard) throws Exception {
		logger.info("################## Vue upsert(Ajax) ##################");
		ModelAndView mav = new ModelAndView("jsonView");
		ObjectMapper mapper = new ObjectMapper();
		
		mav.addObject("info", mapper.writeValueAsString(vueBoardService.upsertAction(vueBoard)));
		return mav;
	}
	
}
