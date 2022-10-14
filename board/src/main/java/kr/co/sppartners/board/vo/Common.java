package kr.co.sppartners.board.vo;

public class Common {
	
	// 현재페이지, 시작페이지, 끝페이지, 게시글 총 갯수, 페이지당 글 갯수, 마지막페이지, SQL쿼리에 쓸 start, end
			private int nowPage = 1;
			private int startPage, endPage, total, cntPerPage, lastPage, start, end;
			private int cntPage = 10;
			private String keyword;
			
			
			public int getNowPage() {
				return nowPage;
			}
			public void setNowPage(int nowPage) {
				this.nowPage = nowPage;
			}
			public int getStartPage() {
				startPage = getEndPage() - cntPage + 1;
				return startPage;
			}
			public void setStartPage(int startPage) {
				this.startPage = startPage;
			}
			public int getEndPage() {
				endPage = ((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage;
				return endPage;
			}
			public void setEndPage(int endPage) {
				this.endPage = endPage;
			}
			public int getTotal() {
				return total;
			}
			public void setTotal(int total) {
				this.total = total;
			}
			public int getCntPerPage() {
				return cntPerPage;
			}
			public void setCntPerPage(int cntPerPage) {
				this.cntPerPage = cntPerPage;
			}
			public int getLastPage() {
				lastPage = (int) Math.ceil((double) total / (double) cntPerPage);
				return lastPage;
			}
			public void setLastPage(int lastPage) {
				this.lastPage = lastPage;
			}
			public int getStart() {
				start = getEnd() - cntPerPage;
				return start;
			}
			public void setStart(int start) {
				this.start = start;
			}
			public int getEnd() {
				end = nowPage * cntPerPage;
				return end;
			}
			public void setEnd(int end) {
				this.end = end;
			}	
			public int setCntPage() {
				return cntPage;
			}
			public void getCntPage(int cntPage) {
				this.cntPage = cntPage;
			}
			public String getKeyword() {
				return keyword;
			}
			public void setKeyword(String keyword) {
				this.keyword = keyword;
			}
	
}
