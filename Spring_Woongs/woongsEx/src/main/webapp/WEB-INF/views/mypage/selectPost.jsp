<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

<script>
var category_first;

$(function(args){
	 /* var ca = $("#check1").val() */
	 	console.log("test "+ ${no});

	 	$('input[name="tag"]').each(function(){
			 /* for(var i=0; i < args.length; i++) {
				 console.log("this " + this.value);
			 } */

	 		if(${no}==this.value){
				$(this).attr("checked","checked");
			}}) /* console.log("this " + this.value); */
			   subTag(${no});
			
})



function getVal() {
	   checkboxArr = [];
	   
	   $('input[name="tag"]:checked').each(function() {
	      checkboxArr.push(this.value)
	         console.log(checkboxArr);

	      /* $.ajax({
	          method      : 'POST',
	             url         : 'test.do',
	             traditional : true,
	             data        : {
	                 'checkboxArr' : checkboxArr
	             }})
	         .done(function(args){   //응답이 성공 상태 코드를 반환하면 호출되는 함수
	            // 결과값 가져오기    
	         })
	          .fail(function(e) {
	             alert(e.responseText);
	          }) */
	      });

	   subTag(${no});
	}


function subTag(data){
	category_first = data;
	array = [];


	var size = $("#size").val();

	console.log("size : "  + size);
	$('input[name="tag"]:checked').each(function() {
		      array.push(this.value)
	         console.log("test " + array);
	      });   


	   $.ajax({
		type:"post"		
		,url: "subAjax_p"
		,data:"subTag="+array
		,dataType:"json" })
		.done(function(args){
			// args 가 0  일 경우에는 지워지지 않는다.. 다른걸 잡아야하는데 
			for(var i=0; i < size; i++) {
			$('.subTag'+(i+1)).empty();
			}
		 for(var i=0; i < args.length; i++) {
			 $(".subTag"+args[i].tag_no).append("<div><input type='checkbox' name='subTag' checked onclick='return subMenu("+args[i].no+")'>"+args[i].sub_name+"<br></div>");
			 }
			})
	    .fail(function(e) {
	    	alert(e.responseText);
	    })
	    return false;
	} 


$(function() {
	$(".tag_c").on("click",function(){
        //클릭되었으면
        if($(this).prop("checked")){
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
            $("input[name=subTag]").prop("checked",true)
            
            //클릭이 안되있으면
        }else{
            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
            $("input[name=subTag]").prop("checked",false);
        }
    })
})
function subMenu(){
}
</script>
</head>
<body>

<span>
	<c:forEach var="tag" items="${list}">
		<div>
			<input type="checkbox" name="tag" class="tag_c"  value="${tag.no}" onclick="getVal();" >${tag.name}
		</div>
	</c:forEach>
</span>	

<c:forEach var="tag" items="${list}" varStatus="status">
		<c:if test ="${status.last }"> 
		<input type="hidden" id="size" value="${status.count}">
		</c:if>
		${tag.name}
		<span class="subTag${tag.no}">
		</span>
</c:forEach>


</body>
</html>

