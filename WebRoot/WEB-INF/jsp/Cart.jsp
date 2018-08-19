<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <title>My JSP 'Cart.jsp' starting page</title>
    
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
  <td>商品名称</td>
  <td>单价</td>
  <td>数量</td>
  <td>小计</td>
  <td>取消</td>
  </tr>
  <c:forEach items="${orderitems }" var="orderitem">
  <tr>
  <td>${orderitem.book.name }</td>
  <td>${orderitem.book.price }</td>
  <td><a href="javascript:void(0);"><button>-</button></a><input type="number" value="${orderitem.num }"><a href="javascript:void(0);"><button>+</button></a></td>
  <td>${orderitem.book.price*orderitem.num }</td>
  <td><a href="javascript:void(0);">×</a></td>
  </tr>
  </c:forEach>
  </table>
  <a href="javascript:void(0);">继续购物</a><br />
  <a href="${pageContext.request.contextPath }/OrderSubmitServlet">提交订单</a>
  </body>
</html>
