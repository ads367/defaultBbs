/**
 * url 변경
 * @param url : 기본 url
 * @param queryStrList : parameter 정보
 * @returns
 */
function changeURL(url, queryStrList) {
	var newUrl = url;
	
	for(var i = 0; i < queryStrList.length; i++) {
		if(i == 0) {
			newUrl += '?';
			newUrl += queryStrList[i].key;
			newUrl += '=';
			newUrl += queryStrList[i].val;
		} else {
			newUrl += '&';
			newUrl += queryStrList[i].key;
			newUrl += '=';
			newUrl += queryStrList[i].val;
		}
	}
	if (typeof (history.pushState) != "undefined") { 
		history.pushState(null, null, newUrl);
	} else {
		//브라우저가 지원하지 않는 경우 처리
	}
}

/**
 * 페이지 목록 이동
 * @param url : 이동할 url
 * @param obj : search정보
 * @param id : 게시판 아이디
 * @returns
 */
function movePage(url, obj, id) {
	switch(arguments.length) {
		case 2:
			var newUrl = url;
				newUrl += '?nowPage='+ obj.nowPage;
				newUrl += '&searchType='+ obj.searchType;
				newUrl += '&searchKeyword='+ obj.searchKeyword;
			location.href = newUrl;
			break;
		case 3:
			var newUrl = url;
				newUrl += '?bbsId='+ id;
				newUrl += '&nowPage='+ obj.nowPage;
				newUrl += '&searchType='+ obj.searchType;
				newUrl += '&searchKeyword='+ obj.searchKeyword;
			location.href = newUrl;
			break;
		default:
			alert('매개변수를 확인하세요.');
			break;
	}
}