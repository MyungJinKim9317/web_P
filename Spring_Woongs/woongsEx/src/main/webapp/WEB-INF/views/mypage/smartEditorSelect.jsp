<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script>

</script>
</head>
<body>


<c:forEach var="list" items="${list}">
<form action="delete" method="post">
<a href="smartEditorPost?no=${list.no}">
<input type="hidden" name="no" value="${list.no}">

<%-- 이미지부분 보류<img src="${list.thumbnail}"  width='90' height='90'>   --%> <br>
디데이 d-${list.d_day}    &nbsp; 

 <%-- <c:if test="${list.no==post_no}">
 count : ${count}
</c:if><br>  --%>
<%-- count : <span class="count"></span><br>
  $(function(){
	if(${list.getNo}==${list_q.getPost_no}){
		$(".count").append(${list_q.getCount});
		}
})  
 --%>
번호 : ${list.no}    &nbsp;

제목 : ${list.title}  <br>
카테고리  : ${list.name} &gt; ${list.sub_name}<br>
간단설명 : ${list.description} <br>
금액  : ${list.budget}
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="submit" value="삭제">
<br>
</a> <br>
</form>
</c:forEach>


</body>
</html>