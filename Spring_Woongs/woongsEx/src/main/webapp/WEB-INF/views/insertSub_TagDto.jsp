<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>서브메뉴 추가</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
$(function(){
	var url="ajax";
	$.ajax({
		type:"post"		
		,url:url		
		,dataType:"json" })
		.done(function(args){	
			 for(var i=0; i < args.length; i++) {
				 $("#sub").append("<option value='"+args[i].no+"'>"+args[i].name+"</option>");
			 }
 			})
	    .fail(function(e) {
	    	alert(e.responseText);
	    })
});

</script>



<form action="SF">
<select id="sub" onchange="sub()" name="no">
  <option value="">대메뉴명 선택</option>
</select>
<input type="text" placeholder="서브메뉴명 입력 " name="sub_name">
<input type="submit" value="추가">
</form>

</body>
</html>