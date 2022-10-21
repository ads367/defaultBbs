<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<template id="pagination">
	<div class="pagination" v-if="dataSearch.totalCnt > 0">
		<a href="#" v-if="dataSearch.nowPage != 1" @click="pagingfn(1)">&Lt;</a>
		<a href="#" v-if="dataSearch.nowPage != 1" @click="pagingfn(dataSearch.nowPage - 1)">&lt;</a>
		<a href="#" :class="{'current': dataSearch.nowPage == i }" v-for="i in pageNum" @click="pagingfn(i)"> {{i}} </a>
		<a href="#" v-if="dataSearch.nowPage < dataSearch.endPage" @click="pagingfn(dataSearch.nowPage + 1)">&gt;</a>
		<a href="#" v-if="dataSearch.nowPage < dataSearch.endPage" @click="pagingfn(dataSearch.endPage)">&Gt;</a>
	</div>
</template>

<script>
	Vue.component('pagination', {
		template : '#pagination',
		props : ['dataSearch'],
		methods : {
			pagingfn: function(i) {
				this.dataSearch.nowPage = i;
				this.$emit('pagingfn', i); 
			}
		},
		computed : {
			// 하단부에 뿌려질 페이징 번호
			pageNum: function() {
				var range = [];
				for(var i = this.dataSearch.firstPage; i <= this.dataSearch.lastPage; i++) {
					range.push(i);
				}
				return range;
			}
		},
		watch : {
			
		},
		mounted : function() {
			var vm = this;
			
		},
	})
</script>