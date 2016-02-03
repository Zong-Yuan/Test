<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>大家好，Hello World!</h2>	
	<a href="<c:url value='/_00_register/register.jsp' />">會員註冊</a><br>
	<a href="<c:url value='/_01_login/login.jsp' />">會員登入</a><br>
	<a href="<c:url value='/_01_login/logout.jsp' />">會員登出</a><br>
	<a href="<c:url value='/_02_memodify/member.jsp' />">會員中心</a><br>
	<a href="<c:url value="/_06_shoppingcar/controller/shoppingcar.con" />">商品頁</a>
	
	
	
<%-- <a href="<c:url value='ch01/queryLottery.jsp' />">問單一明牌</a><P/> --%>
</body>
</html>

