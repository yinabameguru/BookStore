<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'CreateOrderSuccess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="./js/jiao.js"></script>
  </head>
  
  <body onload="startSecond()">
    <span>订单创建成功！</span>
    <a href="${pageContext.request.contextPath }/OrderInfoServlet">进入订单</a>
    <a href="${pageContext.request.contextPath }/MainServlet">继续购物</a>
    <span><a href="${pageContext.request.contextPath }/MainServlet" id="second">3</a>秒后将自动为您跳转到首页。</span>
  </body>
</html>
