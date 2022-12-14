<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="bodyDv" id="vueCtrl" v-cloak>
	<h1>Vue List</h1>
	<div class="searchDv flexEnd">
		<select name="searchType" id="searchType" v-model="search.searchType">
			<option value="">전체</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text" placeholder="검색어를 입력하세요." name="searchKeyword" id="searchKeyword" v-model="search.searchKeyword" @keyup.enter="goSearch(1)">
		<button type="button" class="btnSearch" @click="goSearch(1)">검색</button>
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
			<tr v-if="list.length > 0" v-for="(info, idx) in list">
				<td>{{ info.bbsId }}</td>
				<td><a class="read_a" href="#" @click="goRead(info.bbsId)">{{ info.title }}</a></td>
				<td>{{ info.updtNm }}</td>
				<td>{{ info.updtDt }}</td>
				<td>{{ info.readCnt }}</td>
			</tr>
			<tr v-else>
				<td colspan="5">데이터가 없습니다.</td>
			</tr>
		</tbody>
	</table>
	<pagination :data-search="search" @pagingfn="goSearch"></pagination>
	<div class="wrtieBtn">
		<button type="button" class="btnBk" @click="goWrite()">글쓰기</button>
	</div>
</div>

<!-- 컴포넌트 -->
<jsp:include page="/WEB-INF/views/board_vue/component/pagination.jsp" />
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
			list: ${list},		// 게시물 목록
			search: ${search}	// 검색 조건 및 페이징 처리
		},
		methods: {
			// 검색
			goSearch: function(nowPage) {
				var vm = this;
				this.search.nowPage = nowPage;
				$.ajax({
					url : '/vue/json/list.ajax',
					contentType : "application/json; charset=UTF-8",
					method : 'post',
					data : JSON.stringify(vm.search),
					dataType : 'json',
// 					async: false,
					beforeSend: function() {
						
					},
					success : function(data) {
						vm.list = JSON.parse(data.list);
						vm.search = JSON.parse(data.search);
						var url = '/vue/list.do';
						var queryStr = [];
							queryStr.push({key: 'nowPage', val: vm.search.nowPage});
							queryStr.push({key: 'searchType', val: vm.search.searchType});
							queryStr.push({key: 'searchKeyword', val: vm.search.searchKeyword});
						changeURL(url, queryStr);
					},
					error : function(e) {
						console.log(e);
						alert('에러 발생\n관리자에게 문의하세요.');
					},
					complete: function() {
						
					}
				});
			},
			
			// 상세조회
			goRead: function(id) {
				movePage('/vue/read.do', this.search, id);
			},
			
			// 등록
			goWrite: function() {
				movePage('/vue/upsert.do', this.search);
			}
			
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