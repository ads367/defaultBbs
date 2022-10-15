<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<header>
	<button type="button" onclick="move('jquery')">Jquery</button>
	<button type="button" onclick="move('vue')">Vue + Jsp</button>
</header>

<script>
	function move(type) {
		if(type == 'jquery') {
			console.log('???')
			location.href="/jqueryBoard/list.do?nowPage=1";
		} else {
			
		}
	}
</script>