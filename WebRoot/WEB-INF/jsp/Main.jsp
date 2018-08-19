<%@page import="com.jza_lbz.domain.PageBook"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="./js/jiao.js"></script>
	<link rel="stylesheet" href="./css/jiao.css" type="text/css">

  </head>
  <body onload="f(${pageBook.pageNow },${pageBook.pageTotal })" >
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
  <c:choose>
  <c:when test="${pageBook.bookCount==0 }">
  <span>未查询到结果</span>
  </c:when>
  <c:when test="${pageBook.bookCount!=0 }">
  <table>
    <c:forEach items="${pageBook.books }" var="book" varStatus="status">
    <tr>
    <td><a href="${pageContext.request.contextPath }/ToBookShowServlet?id=${book.id }">${book.name }</a></td>
    <td>${book.author }</td>
    <td>${book.price }</td>
    <td>${book.imageName } <img alt="" src="${book.imageName }"> </td>
    <td>${book.description }</td>   
    </tr>
    </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath }/MainServlet?pageNow=1&category_id=${pageBook.category_id }" id="first">首页 </a>
    <a href="${pageContext.request.contextPath }/MainServlet?pageNow=${pageBook.pageNow-1 }&category_id=${pageBook.category_id }" id="prev">上一页</a>
    <span>第${pageBook.pageNow }页/共${pageBook.pageTotal }页</span>
    <a href="${pageContext.request.contextPath }/MainServlet?pageNow=${pageBook.pageNow+1 }&category_id=${pageBook.category_id }" id="next">下一页</a>
    <a href="${pageContext.request.contextPath }/MainServlet?pageNow=${pageBook.pageTotal }&category_id=${pageBook.category_id }" id="end">尾页</a>
  </c:when>
  </c:choose>
  
  </body>
</html>
