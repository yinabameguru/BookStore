<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Oiderinfo.jsp' starting page</title>
    
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
	  <table>
	  <tr>
	  <td>订单创建时间</td>
	  <td>商品总数</td>
	  <td>商品总价</td>
	  <td>订单状态</td>
	  <td>订单详情</td>
	  </tr>
	  <c:forEach items="${orderinfos }" var="orderinfo">
	  <tr>
	  <td>${orderinfo.orderId }</td>
	  <td>${orderinfo.num }</td>
	  <td>${orderinfo.price }</td>
	  <c:choose>
	  <c:when test="${orderinfo.status==1 }">
	  <td>未付款<a href="javascript:void(0)">付款</a></td>
	  </c:when>
	  <c:when test="${orderinfo.status==2 }">
	  <td>已付款</td>
	  </c:when>
	  </c:choose>
	  <td><a href="${pageContext.request.contextPath }/OrderitemServlet?orderinfo_id=${orderinfo.id }">查看订单详情</a></td>
	  </tr>
	  </c:forEach>
	  </table>
  </body>
</html>
