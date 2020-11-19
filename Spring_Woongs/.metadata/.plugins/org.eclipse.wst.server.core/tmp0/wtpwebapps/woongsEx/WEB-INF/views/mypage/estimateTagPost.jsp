<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="Tag" items="${list}">
		<li><a href="estimatePost?no=${Tag.no}"> ${Tag.name}</a></li>
	</c:forEach>
</body>
</html>