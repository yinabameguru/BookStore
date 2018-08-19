<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'BookShow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <a href="${pageContext.request.contextPath }/OrderInfoServlet">我的订单</a>
  <a href="${pageContext.request.contextPath }/CartServlet">购物车</a>
  <a href="${pageContext.request.contextPath }/Register">注册</a>
  <span>欢迎光临，
  <c:choose>
  <c:when test="${user!=null }"><span>${user.username }!</span><a href="${pageContext.request.contextPath }/CancellationServlet">注销</a></c:when>
  <c:when test="${user==null }"><span>请先<a href="${pageContext.request.contextPath }/Login">登录！</a> </span> </c:when>
  </c:choose>
  </span>
  <span>分类</span>
  <ul>
  <li><a href="${pageContext.request.contextPath }/MainServlet?pageNow=1?category_id=${pageBook.category_id }">所有分类</a></li>
  <c:forEach items="${categorys }" var="categorys" varStatus="status">
  <li><a href="${pageContext.request.contextPath }/CategorBookServlet?category_id=${categorys.id }">${categorys.name }</a></li>
  </c:forEach>
  </ul>
  ${book.name }<br />
  ${book.author }<br />
  ${book.price }<br />
  <img alt="" src="${pageContext.request.contextPath }/${book.imageName }"><br />
  ${book.description }<br />
  <a href="${pageContext.request.contextPath }/AddCartServlet?book_id=${book.id }"><button>加入购物车</button></a>
  </body>
</html>
