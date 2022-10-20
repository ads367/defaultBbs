package kr.co.sppartners.vue.vo;

public class VueBoard  extends VueCommon {
	private int bbsId;					// 게시판 아이디
	
	private String title;				// 제목
	
	private String content;				// 내용
	
	private int readCnt;				// 조회수
	
	private int likeCnt;				// 좋아요수
	
	private String registNm;			// 작성자명
	
	private String registDt;			// 작성일
	
	private String updtNm;				// 수정자명
	
	private String updtDt;				// 수정일
	
	private String useAt;				// 사용여부
	
	private Boolean readChck = true;	// 조회수 증가 확인

	public int getBbsId() {
		return bbsId;
	}

	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	public String getRegistNm() {
		return registNm;
	}

	public void setRegistNm(String registNm) {
		this.registNm = registNm;
	}

	public String getRegistDt() {
		return registDt;
	}

	public void setRegistDt(String registDt) {
		this.registDt = registDt;
	}

	public String getUpdtNm() {
		return updtNm;
	}

	public void setUpdtNm(String updtNm) {
		this.updtNm = updtNm;
	}

	public String getUpdtDt() {
		return updtDt;
	}

	public void setUpdtDt(String updtDt) {
		this.updtDt = updtDt;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public Boolean getReadChck() {
		return readChck;
	}

	public void setReadChck(Boolean readChck) {
		this.readChck = readChck;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
}
