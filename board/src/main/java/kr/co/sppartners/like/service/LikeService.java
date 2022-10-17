package kr.co.sppartners.like.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import kr.co.sppartners.like.dao.LikeDAO;
import kr.co.sppartners.like.vo.LikeVO;

@Service("likeService")
public class LikeService {
	
	@Resource(name="likeDAO")
	private LikeDAO likeDAO;
	
	/**
	 * 좋아요 등록
	 * @param LikeVO
	 * @throws Exception
	 * @return int
	 */
	public int saveLike(LikeVO likeVO, HttpServletRequest req) throws Exception {
		// IP 호출
		String ip = getRequestIp(req);
		likeVO.setIp(ip);
		
		// 중복 확인
		int overlap = likeDAO.findOverlapLike(likeVO);
		
		// 중복이 아닐 경우에만 등록
		if(overlap == 0) likeDAO.saveLike(likeVO);
		
		return overlap;
	}
	
	/**
	 * IP 확인
	 * @param HttpServletRequest
	 * @return String
	 */
	public static String getRequestIp(HttpServletRequest req) {
		String ip = req.getHeader("HTTP_X_FORWARDED_FOR");
		
		if(ip == null || ip.length() == 0 || ip.toLowerCase().equals("unknown")) {
			ip = req.getHeader("X-Forwarded-For");
		}

		if(ip == null || ip.length() == 0 || ip.toLowerCase().equals("unknown")) {
			ip = req.getHeader("REMOTE_ADDR");
		}

		if(ip == null || ip.length() == 0 || ip.toLowerCase().equals("unknown")) {
			ip = req.getRemoteAddr();
		}
		
		return ip != null ? ip : "";
	}
}
