<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
	<h1>Jquery Write</h1>
	<form name="frm" id="frm" action="/jqueryBoard/writeAction.do" method="post">
		<table>
			<tr>
				<td class="sub">
					<span>제목</span>
					<input type="text" class="con_title" name="title" id="title" placeholder="제목을 입력해주세요.">
				</td>
			</tr>
			<tr>
				<td class="sub">
					<span>작성자</span>
					<input type="text" class="con_title" name="registNm" id="registNm" placeholder="작성자를 입력해주세요.">
				</td>
			</tr>
			<tr>
				<td class="sub">
					<span>내용</span>
					<textarea class="con_content" name="content" id="content" placeholder="내용을 입력해주세요."></textarea>
				</td>
			</tr>
		</table>
	</form>
	<div class="btn_col">
		<button type="button" onclick="insert()">등록</button>
		<button type="button" onclick="cancel()">취소</button>
	</div>
</div>

<script>
	// 등록
	function insert() {
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
		if(!confirm('등록을 취소하시겠습니까?')) return;
		location.href = '/jqueryBoard/list.do';
	}
</script>