<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
	table {
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
</style>

<div class="bodyDv">
	<h1>Jquery List</h1>
	<div class="searchDv">
		<select name="searchType" id="searchType">
			<option value="">전체</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text" placeholder="검색어를 입력하세요." name="searchKeyword" id="searchKeyword">
		<button type="button" onclick="goSearch()">검색</button>
	</div>
	<table>
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
			<c:forEach items="${ list }" var="item" varStatus="status">
				<tr>
					<td>${ item.bbsId }</td>
					<td>${ item.title }</td>
					<td>${ item.updtNm }</td>
					<td>${ item.updtDt }</td>
					<td>${ item.readCnt }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="wrtieBtn">
		<button type="button" onclick="goWrite()">글쓰기</button>
	</div>
</div>

<script>
	// 검색
	function goSearch() {
		
	}
	
	// 등록
	function goWrite() {
		location.href = "/jqueryBoard/write.do";
	}
</script>