<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
	/* table {
		width: 100%;
		border-collapse: collapse;
	}
	th {
		border-bottom: 1px solid;
		padding-bottom: 10px;
	}
	td {
		text-align: center; 
		padding: 5px;
	}
	.searchDv {
		margin-bottom: 15px;
		text-align: right;
	}
	.bodyDv {
		width: 80%;
		margin: auto;
	}
	input {
		width: 200px;
		height: 25px;
		font-size: 15px;
		border: 0;
		border-radius: 10px;
		outline: none;
		padding-left: 10px;
		background-color: rgb(243, 243, 243);
	}
	.wrtieBtn {
		margin-top: 25px;
		text-align: right;
	}
	a.read_a:link {
		text-decoration: none;
	}
	a.read_a:visited {
		text-decoration: none;
	}
	a.read_a:hover {
		text-decoration: underline;
	}
	a.read_a:active {
		text-decoration: none;
	}
	.read_a {
		color: black;
	} */
</style>

<div class="bodyDv">
	<h1>Jquery List</h1>
	<div class="searchDv flexEnd">
		<select name="searchType" id="searchType">
			<option value="" ${ boardVO.searchType eq '' ? 'selected' : '' }>전체</option>
			<option value="title" ${ boardVO.searchType eq 'title' ? 'selected' : '' }>제목</option>
			<option value="content" ${ boardVO.searchType eq 'content' ? 'selected' : '' }>내용</option>
		</select>
		<input type="text" placeholder="검색어를 입력하세요." name="searchKeyword" id="searchKeyword" value="<c:out value="${ boardVO.searchKeyword }" />">
		<button type="button" class="btnSearch" onclick="goSearch(1)">검색</button>
	</div>
	<table class="listTable">
		<colgroup>
			<col style="width: 5%;" />
			<col style="width: 45%;" />
			<col style="width: 20%;" />
			<col style="width: 20%;" />
			<col style="width: 10;" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${ fn:length(list) > 0 }">
				<c:forEach items="${ list }" var="item" varStatus="status">
					<tr>
						<td>${ item.bbsId }</td>
						<td><a class="read_a" href="#" onclick="goRead('${item.bbsId}')">${ item.title }</a></td>
						<td>${ item.updtNm }</td>
						<td>${ item.updtDt }</td>
						<td>${ item.readCnt }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${ fn:length(list) == 0 }">
				<tr>
					<td colspan="5">데이터가 없습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<c:if test="${ fn:length(list) > 0 }">
		<div class="pagination">
			<c:if test="${ boardVO.nowPage != 1 }">
				<a href="#" class="first" onclick="goSearch(1)">&lt;&lt;</a> 
				<a href="#" class="prev" onclick="goSearch('<c:out value="${ boardVO.nowPage - 1 }" />')">&lt;</a>
			</c:if>
			<c:forEach begin="${ boardVO.firstPage}" end="${ boardVO.lastPage }" var="item">
				<c:choose>
					<c:when test="${ item == boardVO.nowPage }">
						<a href="#" class="current"><b>${ item }</b></a>
					</c:when>
					<c:otherwise>
						<a href="#" onclick="goSearch('<c:out value="${ item }" />')">${ item }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${ boardVO.nowPage < boardVO.endPage }">
				<a href="#" class="next" onclick="goSearch('<c:out value="${ boardVO.nowPage + 1 }" />')">&gt;</a>
				<a href="#" class="last" onclick="goSearch('<c:out value="${ boardVO.endPage }" />')">&gt;&gt;</a>
			</c:if>
		</div>
	</c:if>
	<div class="wrtieBtn">
		<button type="button" class="btnBk" onclick="goWrite()">글쓰기</button>
	</div>
</div>

<script>
	$(document).ready(function() {
		// 검색어 입력란에서 Enter 이벤트 발생
		$(document).on('keydown', '#searchKeyword', function(key) {
			if(key.keyCode == 13) {
				goSearch(1);
			}
		});
	});
	
	// 검색
	function goSearch(idx) {
		var nowPage = idx;
		var searchType = $("#searchType").val();
		var searchKeyword = $("#searchKeyword").val();
		var url = '/jquery/list.do?nowPage='+ nowPage;
			url += '&searchType='+ searchType;
			url += '&searchKeyword='+ searchKeyword;
		location.href = url;
	}
	// 등록
	function goWrite() {
		location.href = "/jquery/write.do";
	}
	// 상세 정보 조회
	function goRead(id) {
		var searchType = '<c:out value="${boardVO.searchType}" />';
		var searchKeyword = '<c:out value="${boardVO.searchKeyword}" />';
		var nowPage = '<c:out value="${boardVO.nowPage}" />';
		var url = '/jquery/read.do?bbsId='+ id;
			url += '&nowPage='+ nowPage;
			url += '&searchType='+ searchType;
			url += '&searchKeyword='+ searchKeyword;
		location.href = url;
	}
</script>