package kr.co.sppartners.like.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sppartners.like.service.LikeService;
import kr.co.sppartners.like.vo.LikeVO;

@Controller
@RequestMapping("/like")
public class LikeController {
	
	private Logger logger = LoggerFactory.getLogger(LikeController.class);
	
	@Resource(name="likeService")
	private LikeService likeService;
	
	/**
	 * 좋아요 등록
	 * @throws Exception
	 */
	@RequestMapping("/saveLike.do")
	public String saveLike(@ModelAttribute LikeVO likeVO, Model model, HttpServletRequest req) throws Exception {
		logger.info("################## Vue saveLike ##################");
		// 반환되는 값은 중복 여부
		int chck = likeService.saveLike(likeVO, req);
		// 중복이 아닌 경우
		if(chck == 0) {
			model.addAttribute("msg", "좋아요 등록 완료!");
		// 중복인 경우
		} else {
			model.addAttribute("msg", "이미 누르셨습니다.");
		}
		
		String url = "/jquery/read.do?bbsId="+ likeVO.getBbsId();
		   url += "&nowPage="+ likeVO.getNowPage();
		   url += "&searchType="+ likeVO.getSearchType();
		   url += "&searchKeyword="+ likeVO.getSearchKeyword();
		model.addAttribute("url", url);
		
		return "common/alert.tiles";
	}
	
}
