<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'AddCartSuccess.jsp' starting page</title>
    
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
    <span>添加购物车成功！</span>
    <a href="${pageContext.request.contextPath }/CartServlet">进入购物车</a>
    <a href="${pageContext.request.contextPath }/MainServlet">继续购物</a>
    <span><a href="${pageContext.request.contextPath }/MainServlet" id="second">3</a>秒后将自动为您跳转到首页。</span>
  </body>
</html>
