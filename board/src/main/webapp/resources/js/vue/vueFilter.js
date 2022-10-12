/*전화번호*/
Vue.filter('changeHtml', function (text) {
	console.log(text)
	
    return $(this).html();
});


/*전화번호*/
Vue.filter('phone', function (phone) {
    return phone.replace(/[^0-9]/g, '')
                .replace(/(\d{3})(\d{3})(\d{4})/, '($1) $2-$3');
});

/* 반올림  */
Vue.filter('math', function (param) {
	if(param == 0){
		return "-";
	}
	return Math.round(param);
});

/* 반올림  */
Vue.filter('math2', function (param) {
	return (Math.round(param*100)/100.0); 
});

/* nullchange  */
Vue.filter('nullchange', function (param) {
	if(param == null){
		return "-";
	} else {
		return moment(param).format('YYYY-MM-DD');
	}
	
});

/* nullchange2  */
Vue.filter('nullchange2', function (param) {
	if(param == null){
		return "-";
	} else {
		return param;
	}
	
});

/* 특수문자 변형 */
Vue.filter('specialCharacter', function(arr) {
	arr = arr.replace(/&lt;/g, '<');
	arr = arr.replace(/&gt;/g, '>');
	arr = arr.replace(/&quot;/g, '"');
	arr = arr.replace(/&amp;/g, '&');
	arr = arr.replace(/&#10;/g, '\n');
	arr = arr.replace(/&#9;/g, '\t');
	return arr;
})

/* 숫자만 입력 */
Vue.directive('numericOnly', {
    inserted: function (el) {
        el.addEventListener('input', function (e) {
        	var code = e.keyCode;
        	console.log(e)
            if ((code > 47 && code < 58) || (code > 95 && code < 106)) {
                return;
            }
            if (code === 9 || code === 8 || code === 46) {
                return;
            }
            e.preventDefault();
        })
    }
});
/* 숫자 콤마 입력 */
Vue.directive('ncommaOnly', {
    inserted: function (el, bind, vnode) {   	
        el.addEventListener('input', function (e) {
            var data = e.target.value;
            var inputVal =  e.target.value;    
            regexp = /[^-\.0-9]/g;
            repexp = '';
            inputVal = inputVal.replace(regexp, repexp);
            regexp = '';            
            var bExists = inputVal.indexOf(".", 0);
            var strArr = inputVal.split('.');     
            strArr[0] = strArr[0] * 1;
            strArr[0] = ""+strArr[0];
            regexp = /^(-?)([0-9]*)(\.?)([^0-9]*)([0-9]*)([^0-9]*)/;
            repexp = '$2$3$5';
            inputVal.replace(regexp, repexp)  
            if (bExists > -1) {         
            	if(strArr[1].length > 8){ strArr[1] = strArr[1].substring( 0, 8 );}
            	inputVal = strArr[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",") + "." + strArr[1];
	        } else { //정수만 있을경우 //소수점 문자열 존재하면 양수 반환 
	        	inputVal = strArr[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	        }            
            e.target.value = inputVal;
            
            if (e.target.value != data)
            {
                vnode.elm.dispatchEvent(new CustomEvent('input'));
            }
           
        })
    }
});

/* 특수문자 제한 */
Vue.directive('textOnly', {
    inserted: function (el, bind, vnode) {
        el.addEventListener('input', function (e) {
            var data = e.target.value;
            var inputVal = $(this).val();
            var RegExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@@\#$%&\'\"\\\(\=]/gi;//정규식 구문

            if (RegExp.test(inputVal)) {
                //특수문자를 지우는 구문
                var ttest = inputVal.substring(0, inputVal.length - 1);
              
                e.target.value = ttest;
            }          
            if (e.target.value != data) {
                vnode.elm.dispatchEvent(new CustomEvent('input'));
            }
        })
    }
});

/* 특수문자 및 한글 제한 */
Vue.directive('textNumberOnly', {
    inserted: function (el, bind, vnode) {
        el.addEventListener('input', function (e) {
            var data = e.target.value;
            var inputVal = $(this).val();
            var RegExp = /^[A-Za-z0-9+]*$/;//정규식 구문
            if (!RegExp.test(inputVal)) {
                e.target.value = inputVal.substring(0, inputVal.length - 1);
            }          
            if (e.target.value != data) {
                vnode.elm.dispatchEvent(new CustomEvent('input'));
            }
        })
    }
});

/*  */
Vue.directive('nextBlank', {
    inserted: function (el, bind, vnode) {
        el.addEventListener('input', function (e) {
           console.log(e)
        var charLimit = $(this).attr("maxlength");
           console.log(this.value.length)
        if (this.value.length >= charLimit) {
        	console.log($(this).next('.blanks'))
            $(this).next('.blanks').focus();
            //return false;
        }
        })
    }
});

/* 특수문자 및 한글 제한 */
Vue.directive('echange', {
    inserted: function (el, bind, vnode) {
        el.addEventListener('input', function (e) {
             var inputVal = $(this).val();
            if(e.data == 'e'){
            	 e.target.value = inputVal.substring(0, inputVal.length - 1);
            }
        })
    }
});