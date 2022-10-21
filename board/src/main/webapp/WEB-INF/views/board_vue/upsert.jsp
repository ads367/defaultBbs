<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="bodyDv write" id="vueCtrl" v-cloak>
	<h1>Vue Upsert</h1>
	<table>
		<tr>
			<td class="sub">
				<span>제목</span>
				<input type="text" class="con_title" name="title" id="title" placeholder="제목을 입력해주세요." v-model="info.title">
			</td>
		</tr>
		<tr>
			<td class="sub">
				<span>작성자</span>
				<input type="text" class="con_title" name="updtNm" id="updtNm" placeholder="작성자를 입력해주세요." v-model="info.updtNm">
			</td>
		</tr>
		<tr>
			<td class="sub">
				<span>내용</span>
				<textarea class="con_content" name="content" id="content" placeholder="내용을 입력해주세요." v-model="info.content"></textarea>
			</td>
		</tr>
	</table>
	<div class="btn_col">
		<button type="button" class="btnBk" @click="upsert()">{{ info.bbsId == 0 ? '등록' : '수정' }}</button>
		<button type="button" class="btnGrayLine" @click="cancel()">취소</button>
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
			info: ${info},		// 객체
			search: ${search},	// 검색 및 페이징 정보
		},
		methods: {
			// 유효성 검사
			formChck: function() {
				if(this.info.title == null || this.info.title == '') {
					alert('제목을 입력해주세요.');
					$("#title").focus();
					return false;
				} else if(this.info.updtNm == null || this.info.updtNm == '') {
					alert('작성자를 입력해주세요.');
					$("#updtNm").focus();
					return false;
				} else if(this.info.content == null || this.info.content == '') {
					alert('내용을 입력해주세요.');
					$("#content").focus();
					return false;
				}
				return true;
			},
			
			// 등록 및 수정
			upsert: function() {
				var vm = this;
				if(!this.formChck()) return;
				$.ajax({
					url : '/vue/json/upsert.ajax',
					contentType : "application/json; charset=UTF-8",
					method : 'post',
					data : JSON.stringify(vm.info),
					dataType : 'json',
					beforeSend: function() {
						
					},
					success : function(data) {
						vm.info = JSON.parse(data);
						movePage('/vue/read.do', vm.search, vm.info.bbsId);
					},
					error : function(e) {
						console.log(e);
						alert('에러 발생\n관리자에게 문의하세요.');
					},
					complete: function() {
						
					}
				});
			},
			
			// 취소
			cancel: function() {
				var msg = this.info.bbsId == 0 ? '등록' : '수정';
				if(!confirm(msg + '을 취소하시겠습니까?')) return false;
				if(msg === '등록') {
					movePage('/vue/list.do', this.search);
				} else {
					movePage('/vue/read.do', this.search, this.info.bbsId);
				}
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