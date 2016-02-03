<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Check Detail</title>
</head>
<body>
<table>
	<tr>
		
		<th>product</th>
		<th>price</th>
		<th>count</th>
		<th>subtotal</th>
	</tr>
	<c:forEach var="cars" items="${shopcar.car}" >
	
	<tr>
	<td>${cars.value.prod_Name}</td>
	<td>${cars.value.price}</td>
	<td>${cars.value.count}</td>
	<td>${cars.value.subtotal}</td>
	</tr>
	</c:forEach>
</table>
	<form name="my_form" method=POST>
	收件人:<input type="text" name="orderBean.addressee">${errors.addressee}<br>
	地址:<input type="text" name="orderBean.address">${errors.address}<br>
	電話:<input type="text" name="orderBean.phone">${errors.phone}<br>
	
	寄件人:<input type="text" name="orderBean.sender">${errors.sender}<br>
	地址:<input type="text" name="orderBean.sender_address">${errors.sender_address}<br>
	電話:<input type="text" name="orderBean.sender_phone">${errors.sender_phone}<br>
	
	付款方式:
	<input type="radio" name="radio1">1.貨到付款
	<input type="radio" name="radio2">2.信用卡付款
	<input type="radio" name="radio3">3.ATM轉帳 
	
	 <INPUT TYPE="button" VALUE="確認" onClick="choice(this.form)">
	</form>
 <SCRIPT LANGUAGE="JavaScript">

     function choice(my_form){
      var str=""
      if(my_form.radio1.checked)str +="貨到付款\n"
      if(my_form.radio2.checked)str +="信用卡付款\n"
      if(my_form.radio3.checked)str +="ATM轉帳\n"
		document.forms[0].action="<c:url value='/checkDetail.action?radio="+ str +"'/>" ;
		//document.forms[0].action="<c:url value='/checkDetail.action'/>";
		document.forms[0].method="POST";		
		document.forms[0].submit();
     }

 </SCRIPT>  
	
</body>
</html>