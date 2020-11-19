<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<c:forEach var="post" items="${list}">
<img src="${post.thumbnail}" width='90' height='90'>
<br>
제목 : ${post.title}<br>
아이디 : ${post.user_id}<br>
가격 : ${post.price}

</c:forEach>

</body>
</html>