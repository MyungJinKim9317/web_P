<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
.tagdata{display:inline-block; vertical-align:top;}
#all_tag{overflow: hidden;}
.subTag{display:inline-block; vertical-align:top;}
</style>
</head>
<body>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>
var category_first;
var category_second;

$(function(data){

	$.ajax({
		type:"post"		
		,url: "allPost"	
		,data:"tag="+data
		,dataType:"json" })
		.done(function(args){
			$('.submenu').empty();
		 for(var i=0; i < args.length; i++) {
			 $(".submenu").append("<a href='postList?no="+args[i].no+"'>"
					 +args[i].user_id + " \t" + args[i].title +"\t"+"<img src='"+args[i].thumbnail+"' width='90' height='90' >"+"</a><br>");
			 }
			})
})
function subTag(data){
	category_first = data;
	console.log("sub");
	tagPost(data); 
	
	$.ajax({
		type:"post"		
		,url: "subAjax1"
		,data:"subTag="+data
		,dataType:"json" })
		.done(function(args){
			$('.subTag').empty();
			/* console.log("args 길이 : " + args.length); */
		 for(var i=0; i < args.length; i++) {
			 $(".subTag").append("<li><a href='"+args[i].no+"' onclick='return subMenu("+args[i].no+")'>"+args[i].sub_name+"</a></li>");
			 }
			})
			
	    .fail(function(e) {
	    	alert(e.responseText);
	    })
	    return false;
	}

function tagPost(data){	
	console.log("tag");
	$.ajax({
		type:"post"		
		,url: "tagPost"	
		,data:"category_first="+data
		,dataType:"json" })
		.done(function(args){
			$('.submenu').empty();
			console.log("empty");
			console.log(args.length);
		 for(var i=0; i < args.length; i++) {
			 
			 $(".submenu").append("<a href='postList?no="+args[i].no+"'>"
					 +args[i].user_id + " \t" + args[i].title +"\t"+"<img src='"+args[i].thumbnail+"' width='90' height='90' >"+"</a><br>");
			 }

		 console.log("submenu");
			})
	    .fail(function(e) {
	    	alert(e.responseText);
	    })
	    return false;
	}


function subMenu(data){
	/* console.log("category_first="+category_first+"&category_second="+data); */
	
	$.ajax({
		type:"post"		
		,url: "subMenu1"	
		,data:"category_first="+category_first+"&category_second="+data
		,dataType:"json" })
		.done(function(args){
			$('.submenu').empty();
		 for(var i=0; i < args.length; i++) {
			 $(".submenu").append("<a href='postList?no="+args[i].no+"'>"
					 +args[i].user_id + " \t" + args[i].title +"\t"+"<img src='"+args[i].thumbnail+"' width='90' height='90' >"+"</a><br>");
			 }
			})
	    .fail(function(e) {
	    	alert(e.responseText);
	    })
	    return false;
	}
//,${subMenu.tag_no}

</script>


<div id="all_tag">
<span class="tagdata">
<c:forEach var="Tag" items="${list}" >
<li><a href="${Tag.no}" id="tag" onclick="return subTag(${Tag.no});">${Tag.name}</a></li>
</c:forEach>
</span>

<span class="subTag">

 
 </span>
</div>

<div>
<span class="submenu">

</span>
</div>
 
</body>
</html>