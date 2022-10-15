package kr.co.sppartners.board.vo;

public class Test {

	/**
	 * Required Fields
	 * - 이 필드들은 페이징 계산을 위해 반드시 입력되어야 하는 필드 값들이다.  
	 * 
	 * nowPage : 현재 페이지 번호
	 * perPage : 한 페이지당 게시되는 게시물 건 수
	 * pagingCnt : 페이지 리스트에 게시되는 페이지 건수,
	 * totalCnt : 전체 게시물 건 수. 
	 */

	private int nowPage;
	private int perPage;
	private int pagingCnt;
	private int totalCnt;

	public int getperPage() {
		return perPage;
	}

	public void setperPage(int perPage) {
		this.perPage = perPage;
	}

	public int getpagingCnt() {
		return pagingCnt;
	}

	public void setpagingCnt(int pagingCnt) {
		this.pagingCnt = pagingCnt;
	}

	public int getnowPage() {
		return nowPage;
	}

	public void setnowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public void settotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int gettotalCnt() {
		return totalCnt;
	}

	/**
	 * Not Required Fields
	 * - 이 필드들은 Required Fields 값을 바탕으로 계산해서 정해지는 필드 값이다.
	 * 
	 * totalPagingCnt: 페이지 개수
	 * firstPage : 페이지 리스트의 첫 페이지 번호
	 * lastPage : 페이지 리스트의 마지막 페이지 번호
	 * startPage : 페이징 SQL의 조건절에 사용되는 시작 rownum. 
	 * endPage : 페이징 SQL의 조건절에 사용되는 마지막 rownum.
	 */

	private int totalPagingCnt;
	private int firstPage;
	private int lastPage;
	private int startPage;
	private int endPage;

	public int gettotalPagingCnt() {
		totalPagingCnt = ((gettotalCnt() - 1) / getperPage()) + 1;
		return totalPagingCnt;
	}

	public int getFirstPageNo() {
		return 1;
	}

	public int getLastPageNo() {
		return gettotalPagingCnt();
	}

	public int getfirstPage() {
		firstPage = ((getnowPage() - 1) / getpagingCnt()) * getpagingCnt() + 1;
		return firstPage;
	}

	public int getlastPage() {
		lastPage = getfirstPage() + getpagingCnt() - 1;
		if (lastPage > gettotalPagingCnt()) {
			lastPage = gettotalPagingCnt();
		}
		return lastPage;
	}

	public int getstartPage() {
		startPage = (getnowPage() - 1) * getperPage();
		return startPage;
	}

	public int getendPage() {
		endPage = getnowPage() * getperPage();
		return endPage;
	}
}
