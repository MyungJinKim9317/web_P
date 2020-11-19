<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>메뉴 삭제</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
$(function(){

	$.ajax({
		type:"post"		
		,url:"ajax"		
		,dataType:"json" })
		.done(function(args){	
			 for(var i=0; i < args.length; i++) {
				 $("#tag").append("<option value='"+args[i].no+"'>"+args[i].name+"</option>");
			 }
 			})
	    .fail(function(e) {
	    	alert(e.responseText);
	    })
});



function subTagDelete(tag){

var data = $("#tag").val(); 
	
$.ajax({
	type:"post"		
	,url: "subAjax"	
	,data:"subTag="+data
	,dataType:"json" })
	.done(function(args){	
		 for(var i=0; i < args.length; i++) {
			 $("#subTag").append("<option value='"+args[i].no+"'>"+args[i].sub_name+"</option>");
		 }
			})
    .fail(function(e) {
    	alert(e.responseText);
    })
}
</script>


<form action="De">
<select id="tag" onchange="subTagDelete()" name="no">
  <option value="0">대메뉴명 선택</option>
</select>
<select id="subTag" name="subno">
<option value="0">서브메뉴선택</option>
</select>
<input type="submit" value="삭제">
</form>


</body>
</html>