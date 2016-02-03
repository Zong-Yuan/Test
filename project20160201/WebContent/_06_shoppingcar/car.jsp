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
<!-- 	<tr> -->
<%-- 	<td>${shopcar.car.value.id}</td> --%>
<%-- 	<td>${shopcar.car.value.product}</td> --%>
<%-- 	<td>${shopcar.car.value.price}</td> --%>
<%-- 	<td>${shopcar.car.value.count}</td> --%>

	<c:forEach var="cars" items="${shopcar.car}" >
	
	<tr>
	<td>${cars.value.prod_Name}</td>
	<td>${cars.value.price}</td>
	<td>${cars.value.count}</td>
	<td>${cars.value.subtotal}</td>
	
	<td>
		<form action="<c:url value='/_06_shoppingcar/controller/caredit/UpdateCarServlet.do'/>" method="get">
			<input type="text" name="count" value="${cars.value.count}">
			<input type="hidden" name="id" value="${cars.value.prod_Id}">
			<input type="submit" name="status" value="-">
			<input type="submit" name="status" value="+">
			<input type="submit" name="status" value="刪除"> 
		</form>
	</td>
	
	
	<td>${cars.value.price*cars.value.count}</td>
	</tr>
	</c:forEach>
		
	
</table>
<a href="<c:url value="/index.jsp" />">回首頁</a>
<a href="<c:url value="/_07_checkout/checkDetail.jsp" />">結帳</a>

</body>
</html>