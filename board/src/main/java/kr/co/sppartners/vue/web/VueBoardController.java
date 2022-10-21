package kr.co.sppartners.vue.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.sppartners.vue.service.VueBoardService;
import kr.co.sppartners.vue.vo.VueBoard;

@Controller
@RequestMapping("/vue")
public class VueBoardController {
	
	private Logger logger = LoggerFactory.getLogger(VueBoardController.class);
	
	@Resource(name="vueBoardService")
	private VueBoardService vueBoardService;
	
	/**
	 * Vue 게시판 목록 조회
	 * @throws Exception
	 */
	@RequestMapping("/list.do")
	public String list(@ModelAttribute VueBoard vueBoard, Model model) throws Exception {
		logger.info("################## Vue list ##################");
		ObjectMapper mapper = new ObjectMapper();
		vueBoard.setPerPage(5);
		vueBoard.setPagingCnt(3);
		int totalCnt = vueBoardService.findAllBbsCnt(vueBoard);
		vueBoard.setTotalCnt(totalCnt);
		
		model.addAttribute("list", mapper.writeValueAsString(vueBoardService.findAllBbs(vueBoard)));
		model.addAttribute("search", mapper.writeValueAsString(vueBoard));
		
		return "board_vue/list.tiles";
	}
	
	/**
	 * Vue 게시판 상세 조회
	 * @throws Exception
	 */
	@RequestMapping("/read.do")
	public String read(@ModelAttribute VueBoard vueBoard, Model model) throws Exception {
		logger.info("################## Vue read ##################");
		ObjectMapper mapper = new ObjectMapper();
		
		model.addAttribute("info", mapper.writeValueAsString(vueBoardService.findBbs(vueBoard)));
		model.addAttribute("search", mapper.writeValueAsString(vueBoard));
		return "board_vue/read.tiles";
	}
	
	/**
	 * Vue 게시판 등록 및 수정
	 * @throws Exception
	 */
	@RequestMapping("/upsert.do")
	public String upsert(@ModelAttribute VueBoard vueBoard, Model model) throws Exception {
		logger.info("################## Vue read ##################");
		ObjectMapper mapper = new ObjectMapper();
		
		model.addAttribute("info", mapper.writeValueAsString(vueBoardService.upsert(vueBoard)));
		model.addAttribute("search", mapper.writeValueAsString(vueBoard));
		
		return "board_vue/upsert.tiles";
	}

}
