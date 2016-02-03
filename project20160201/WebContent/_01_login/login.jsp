<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post" name="loginForm">
	信箱:<input type="text" name="mail" value="${param.mail}">${loginerror.errormail}<br>
	密碼:<input type="text" name="pwd" value="${param.pwd}">${loginerror.errorpwd}<br>
	${loginerror.error}
	<br>
	<input type="submit" value="送出">
	<a href="<c:url value='/index.jsp' />">回首頁</a>
	</form>
</body>
</html>