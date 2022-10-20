package kr.co.sppartners.like.vo;

import kr.co.sppartners.jquery.vo.Common;

public class LikeVO extends Common {
	
	private int no;				// 좋아요 아이디
	
	private String ip;			// 사용자 IP
	
	private int bbsId;			// 게시판 아이디
	
	private String registDt;	// 작성일

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getBbsId() {
		return bbsId;
	}

	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}

	public String getRegistDt() {
		return registDt;
	}

	public void setRegistDt(String registDt) {
		this.registDt = registDt;
	}
}
