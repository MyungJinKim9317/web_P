<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
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

</script>

</head>
<body>
<form action="insertRandomPost" name="fr" method="post" enctype="Multipart/form-data">
랜덤 이미지를 넣을 태그를 선택해 주세요°˖✧◝(⁰▿⁰)◜✧˖°
<select id="tag" name="tag_no">
<option value="">대메뉴명 선텍</option>
</select><br>
<br>
태그에 넣을 사진을 골라주세요ლ( ╹ ◡ ╹ ლ)
<input type="file" name="report" id="file">
<input type="submit" value="저장">
</form>

</body>
</html>