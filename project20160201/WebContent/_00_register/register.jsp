<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	
	<form action="register.do" method="post" name="loginForm">
	信箱:<input type="text" name="mail" value="${param.mail}">${insertmember.errormail}<br>
	密碼:<input type="text" name="pwd" value="${param.pwd}">${insertmember.errorpwd}<br>
	姓名:<input type="text" name="mem_name" value="${param.mem_name}">${insertmember.errorname}<br>
	身分證字號:<input type="text" name="identification" value="${param.identification}">${insertmember.errorid}<br>
	性別:<input type="radio" name="gender" value="1"> 男
		 <input type="radio" name="gender" value="2"> 女 ${insertmember.errorgender}<br>
	生日:<input type="text" name="bdate" value="${param.bdate}">${insertmember.errorbdate}<br>
	<input type="submit" value="送出">
	<a href="<c:url value='/index.jsp' />">回首頁</a>
	</form>
	
	
</body>
</html>