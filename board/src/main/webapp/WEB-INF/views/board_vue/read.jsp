<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="bodyDv read" id="vueCtrl" v-cloak>
	<h1 class="viewTitle" style="width: 100%;">{{info.title}}</h1>
	<div class="viewInfo">
		<p><b>작성자</b>  {{info.updtNm}}</p> 
		<p><b>작성일</b>  {{info.updtDt}}</p>
		<p><b>조회수</b>  {{info.readCnt}}</p>
		<div>
			<button type="submit" class="btnLike" @click="likeUp">&#10084;</button>  {{info.likeCnt}}
		</div>
	</div>
	<div class="viewContent">
		<pre>{{info.content}}</pre>
	</div>
	<div class="btnCol">
		<button type="button" class="btnGrayLine" @click="del">삭제</button>
		<button type="button" class="btnGrayLine" @click="goUpdate">수정</button>
		<button type="button" class="btnBk" @click="goList">목록</button>
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
			info: ${info},		// 게시물 조회
			search: ${search}	// 검색 조건
		},
		methods: {
			// 좋아요
			likeUp: function() {
				var vm = this;
				$.ajax({
					url : '/like/json/like.ajax',
					contentType : "application/json; charset=UTF-8",
					method : 'post',
					data : JSON.stringify(vm.info),
					dataType : 'json',
					beforeSend: function() {
						
					},
					success : function(data) {
						if(data.status == '등록') {
							alert('좋아요 등록 완료!');
							vm.info = JSON.parse(data.info);
						} else {
							alert('이미 누르셨습니다.');
						}
					},
					error : function(e) {
						console.log(e);
						alert('에러 발생\n관리자에게 문의하세요.');
					},
					complete: function() {
						
					}
				});
			},
			
			// 삭제
			del: function() {
				var vm = this;
				if(!confirm('삭제하시겠습니까?')) return false;
				$.ajax({
					url : '/vue/json/del.ajax',
					contentType : "application/json; charset=UTF-8",
					method : 'post',
					data : JSON.stringify(vm.info),
					dataType : 'json',
					beforeSend: function() {
						
					},
					success : function(data) {
						alert('삭제 완료');
						vm.goList();
					},
					error : function(e) {
						console.log(e);
						alert('에러 발생\n관리자에게 문의하세요.');
					},
					complete: function() {
						
					}
				});
			},
			
			// 수정
			goUpdate: function() {
				movePage('/vue/upsert.do', this.search, this.info.bbsId);
			},
			
			// 목록
			goList: function() {
				movePage('/vue/list.do', this.search);
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
