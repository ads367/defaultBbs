<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.bodyDv {
		width: 80%;
		margin: auto;
	}
	table {
		width: 100%;
		border-collapse: collapse;
	}
	.sub {
		text-align: left;
		font-weight: bold;
		padding-bottom: 10px;
	}
	.con_title {
		width: 100%;
		height: 25px;
		font-size: 15px;
	}
	.con_content {
		width: 100%;
		height: 350px;
		font-size: 15px;
	}
	.btn_col {
		margin-top: 10px;
		text-align: right;
	}
</style>
<div class="bodyDv">
	<h1>Jquery Update</h1>
	<form name="frm" id="frm" action="/jquery/updateAction.do" method="post">
		<input type="hidden" id="bbsId" name="bbsId" value="<c:out value="${ info.bbsId }" />">
		<input type="hidden" id="readCnt" name="readCnt" value="<c:out value="${ info.readCnt }" />">
		<input type="hidden" name="nowPage" id="nowPage" value="${ search.nowPage }">
		<input type="hidden" name="searchType" id="searchType" value="${ search.searchType }">
		<input type="hidden" name="searchKeyword" id="searchKeyword" value="${ search.searchKeyword }">
		<table>
			<tr>
				<td class="sub">
					<span>제목</span>
					<input type="text" class="con_title" name="title" id="title" placeholder="제목을 입력해주세요." value="<c:out value="${ info.title }" />">
				</td>
			</tr>
			<tr>
				<td class="sub">
					<span>수정자</span>
					<input type="text" class="con_title" name="updtNm" id="updtNm" placeholder="작성자를 입력해주세요." value="<c:out value="${ info.updtNm }" />">
				</td>
			</tr>
			<tr>
				<td class="sub">
					<span>내용</span>
					<textarea class="con_content" name="content" id="content" placeholder="내용을 입력해주세요."><c:out value="${ info.content }" /></textarea>
				</td>
			</tr>
		</table>
	</form>
	<div class="btn_col">
		<button type="button" onclick="update()">수정</button>
		<button type="button" onclick="cancel()">취소</button>
	</div>
</div>

<script>
	// 수정
	function update() {
		if($('#title').val() == '') {
			alert('제목을 입력해주세요.');
			$('#title').focus();
			return;
		} else if($('#registNm').val() == '') {
			alert('작성자를 입력해주세요.');
			$('#registNm').focus();
			return;
		} else if($('#content').val() == '') {
			alert('내용을 입력해주세요.');
			$('#content').focus();
			return;
		}
		$("#frm").submit();
	}
	
	// 취소
	function cancel() {
		if(!confirm('수정을 취소하시겠습니까?')) return;
		var url = '/jquery/read.do?bbsId='+ $("#bbsId").val();
			url += '&nowPage='+ $("#nowPage").val();
			url += '&searchType='+ $("#searchType").val();
			url += '&searchKeyword='+ $("#searchKeyword").val();
		location.href = url;
	}
</script>