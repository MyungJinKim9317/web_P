<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<form action="estimateupdate" method="post">
<c:forEach var="list" items="${list}">
<input type="hidden" name="no" value="${list.no}">
<input type="hidden" name="tag" value="${list.tag}">
<input type="hidden" name="sub_tag" value="${list.sub_tag}">
제목 : ${list.title}  <br>
카테고리  : ${list.name} > ${list.sub_name}  <br>
설명 : ${list.content}<br>
파일 : <a href="fileDown?proposal='${list.proposal}'">${list.proposal}</a>
<br>
</c:forEach>
		<input type="submit" value="수정">
</form>
총 의뢰한 견적수 :  ${count}
<form action='checkQuote'>
<input type="hidden" name="post_no" value="${no}">
<input type='submit' value='견적의뢰하기'/>
</form>

</body>
</html>