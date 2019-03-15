<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	float priceCount = (float)session.getAttribute("pcount");
	String customerName = (String)session.getAttribute("customerName");
%>
<body>
	<h1>用户：<%=customerName %>支付成功！</h1>
	<h2>金额：￥<%=priceCount %></h2>	
</body>
</html>