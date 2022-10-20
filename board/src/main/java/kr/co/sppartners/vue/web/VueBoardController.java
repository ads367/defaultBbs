package kr.co.sppartners.vue.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sppartners.vue.service.VueBoardService;
import kr.co.sppartners.vue.vo.VueBoard;

@Controller
@RequestMapping("/vue")
public class VueBoardController {
	
	private Logger logger = LoggerFactory.getLogger(VueBoardController.class);
	
	@Resource(name="vueBoardService")
	private VueBoardService vueBoardService;
	
	/**
	 * Vue 게시판 목록페이지로 이동
	 * @throws Exception
	 */
	@RequestMapping("/list.do")
	public String list(@ModelAttribute VueBoard vueBoard, Model model) throws Exception {
		logger.info("################## Jquery list ##################");
		return "board_vue/list.tiles";
	}

}
