<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="bodyDv read">
	<form id="frm" name="frm" action="/like/saveLike.do">
		<input type="hidden" name="bbsId" id="bbsId" value="${ info.bbsId }">
		<input type="hidden" name="nowPage" id="nowPage" value="${ search.nowPage }">
		<input type="hidden" name="searchType" id="searchType" value="${ search.searchType }">
		<input type="hidden" name="searchKeyword" id="searchKeyword" value="${ search.searchKeyword }">
		<h1 class="viewTitle">${ info.title }</h1>
		<div class="viewInfo">
			<p><b>작성자</b>  ${ info.updtNm }</p> 
			<p><b>작성일</b>  ${ info.updtDt }</p> 
			<p><b>조회수</b>  ${ info.readCnt }</p>
			<div>
				<button type="submit" class="btnLike">&#10084;</button>  ${ info.likeCnt }
			</div>
		</div>
		<div class="viewContent">
			<pre><c:out value="${ info.content }" /></pre>
		</div>
	</form>
	<div class="btnCol">
		<button type="button" class="btnGrayLine" onclick="del()">삭제</button>
		<button type="button" class="btnGrayLine" onclick="goUpdate()">수정</button>
		<button type="button" class="btnBk" onclick="goList()">목록</button>
	</div>
</div>

<script>
	// 삭제
	function del() {
		if(!confirm('삭제하시겠습니까?')) return false;
		var url = '/jquery/del.do?bbsId='+ $("#bbsId").val();
			url += '&nowPage='+ $("#nowPage").val();
			url += '&searchType='+ $("#searchType").val();
			url += '&searchKeyword='+ $("#searchKeyword").val();
		location.href = url;
	}
	
	// 수정
	function goUpdate() {
		var url = '/jquery/update.do?bbsId='+ $("#bbsId").val();
			url += '&nowPage='+ $("#nowPage").val();
			url += '&searchType='+ $("#searchType").val();
			url += '&searchKeyword='+ $("#searchKeyword").val();
		location.href = url;
	}
	
	// 목록
	function goList() {
		var url = '/jquery/list.do?nowPage='+ $("#nowPage").val();
			url += '&searchType='+ $("#searchType").val();
			url += '&searchKeyword='+ $("#searchKeyword").val();
		location.href =url;
	}
</script>
