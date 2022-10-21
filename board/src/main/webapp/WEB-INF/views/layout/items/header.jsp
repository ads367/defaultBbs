<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<header>
	<div class="topBtn">
		<button type="button" onclick="move('jquery')">Jquery</button>
		<button type="button" onclick="move('vue')">Vue + Jsp</button>
	</div>
</header>

<script>
	function move(type) {
		if(type == 'jquery') {
			location.href="/jquery/list.do?nowPage=1";
		} else {
			location.href="/vue/list.do";
		}
	}
	
	//버튼 클래스
	if(location.pathname.indexOf('jquery') != -1) {
		$('.topBtn > button').removeClass('active');
		$('.topBtn > button').eq(0).addClass('active');
	} else {
		$('.topBtn > button').removeClass('active');
		$('.topBtn > button').eq(1).addClass('active');
	}
</script> 