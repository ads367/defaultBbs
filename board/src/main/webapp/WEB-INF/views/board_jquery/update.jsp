<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="bodyDv update">
	<h1>Jquery Update</h1>
	<form name="frm" id="frm" action="/jquery/updateAction.do" method="post">
		<input type="hidden" id="bbsId" name="bbsId" value="<c:out value="${ info.bbsId }" />">
		<input type="hidden" id="readCnt" name="readCnt" value="<c:out value="${ info.readCnt }" />">
		<input type="hidden" name="nowPage" id="nowPage" value="${ search.nowPage }">
		<input type="hidden" name="searchType" id="searchType" value="${ search.searchType }">
		<input type="hidden" name="searchKeyword" id="searchKeyword" value="${ search.searchKeyword }">
		<table class="updateTable">
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
		<button type="button" class="btnGrayLine" onclick="update()">수정</button>
		<button type="button" class="btnGrayLine" onclick="cancel()">취소</button>
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