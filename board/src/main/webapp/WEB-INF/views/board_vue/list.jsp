<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	}
</style>

<div class="bodyDv" id="vueCtrl" v-cloak>
	<h1>Vue List</h1>
	<div class="searchDv">
		<select name="searchType" id="searchType">
			<option value="">전체</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text" placeholder="검색어를 입력하세요." name="searchKeyword" id="searchKeyword">
		<button type="button" onclick="goSearch(1)">검색</button>
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
					<tr>
						<td>${ item.bbsId }</td>
						<td><a class="read_a" href="#" onclick="goRead('${item.bbsId}')">${ item.title }</a></td>
						<td>${ item.updtNm }</td>
						<td>${ item.updtDt }</td>
						<td>${ item.readCnt }</td>
					</tr>
		</tbody>
	</table>
	<div class="wrtieBtn">
		<button type="button" onclick="goWrite()">글쓰기</button>
	</div>
</div>

<script>
	/* vue 객체 
	 * el : 선택 html요소 내부에 있는 html요소들을 vue가 컨트롤 해줌.
	 * data : vue 객체 내부에서 컨트롤 할 수 있는 변수
	 * methods : vue 객체 내부에서 컨트롤 할 수 있는 메소드
	 * filters : 데이터 값을 로직을 통해 걸러 데이터를 화면에 반환해줌, 실 데이터는 바뀌지 않음
	 * computed : vue data 객체 내부에 있는 변수들의 값이 바뀔때 감지를 해주고 function을 통해 로직 처리가 가능
	 * watch : vue data 객체 내부에 있는 변수들의 값이 바뀔때 감지를 해주고 function을 통해 로직 처리가 가능
	    - computed와 watch가 하는 기능은 비슷하지만 다름.
	 * mounted : vue 객체가 메모리에 올라가고, 화면에 로드될 때 function을 통해 로직이 실행됨. 
	 */
	var vm = new Vue({
		el: "#vueCtrl",
		data: {
			
		},
		methods: {
			
		},
		filters: {
			
		},
		computed: {
			
		},
		watch: {
			
		},
		mounted: function () {
			var vm = this;
		}
	});
</script>