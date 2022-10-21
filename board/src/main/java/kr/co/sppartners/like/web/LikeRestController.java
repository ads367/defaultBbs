package kr.co.sppartners.like.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.sppartners.like.service.LikeService;
import kr.co.sppartners.like.vo.LikeVO;
import kr.co.sppartners.vue.service.VueBoardService;
import kr.co.sppartners.vue.vo.VueBoard;

@RestController
@RequestMapping("/like/json")
public class LikeRestController {
	
	private Logger logger = LoggerFactory.getLogger(LikeRestController.class);
	
	@Resource(name="likeService")
	private LikeService likeService;
	
	@Resource(name="vueBoardService")
	private VueBoardService vueBoardService;
	
	/**
	 * 좋아요 등록
	 * @throws Exception
	 */
	@RequestMapping("/like.ajax")
	public ModelAndView like(@RequestBody LikeVO likeVO, HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("################## Vue like(Ajax) ##################");
		ModelAndView mav = new ModelAndView("jsonView");
		ObjectMapper mapper = new ObjectMapper();
		
		// 반환되는 값은 중복 여부(0: 등록 완료, 1: 중복)
		int chck = likeService.saveLike(likeVO, req);
		
		VueBoard vueBoard = new VueBoard();
		vueBoard.setBbsId(likeVO.getBbsId());
		mav.addObject("info", mapper.writeValueAsString(vueBoardService.findBbs(vueBoard, req, res)));
		mav.addObject("status", chck == 0 ? "등록" : "중복");
		
		return mav;
	}
	
}
