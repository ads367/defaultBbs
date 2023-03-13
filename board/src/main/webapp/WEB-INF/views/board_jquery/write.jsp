<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="bodyDv write">
	<h1>Jquery Write</h1>
	<form name="frm" id="frm" action="/jquery/writeAction.do" method="post">
		<table class="writeTable">
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
			<tr>
				<td class="sub">
					<span>파일 업로드</span>
					<div class="fileUploadBox">
						<input type="file" id="fileUpload" class="fileUpload">
						<label for="fileUpload"></label>
						<div class="fileBtnBox">
							<button class="btnPlus" type="button">&plus;</button>
							<button class="btnMinus" type="button">&minus;</button>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<div class="btn_col">
		<button type="button" class="btnBk" onclick="insert()">등록</button>
		<button type="button" class="btnGrayLine" onclick="cancel()">취소</button>
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
		location.href = '/jquery/list.do';
	}
</script>