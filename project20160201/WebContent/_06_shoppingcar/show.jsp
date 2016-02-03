<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>商品頁</h3>
<table>
	<tr>
		
		<th>product</th>
		<th>price</th>
		<th>count</th>
		<th>subtotal</th>
	</tr>
	<c:forEach var="result" items="${result}">
	<tr>
		
		<td>${result.productName}</td>
		<td>${result.brand}</td>
		<td>${result.price}</td>		
		<td>${result.note}</td>
	<td>
	<form action='<c:url value="/_06_shoppingcar/controller/BuyProServlet.con"/>' method="post">
		<input type="hidden" name="id" value="${result.prodId}">
		<input type="hidden" name="product" value="${result.productName}">
		<input type="hidden" name="brand" value="${result.brand}">
		<input type="hidden" name="price" value="${result.price}">
		<input type="hidden" name="count" value="1">
		<input type="submit" name="car" value="加入購物車">
		${error.exist}
		
	</form>
	</td>
	</tr>
	</c:forEach>
	
</table>
<a href="<c:url value="/_06_shoppingcar/car.jsp" />">購物車</a><br>
<a href="<c:url value="/index.jsp" />">回首頁</a>
</body>
</html>