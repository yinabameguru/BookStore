<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Register.jsp' starting page</title>
    
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
    <form action="${pageContext.request.contextPath }/RegisterServlet">
    <span>用户名*：</span><input type="text" name="username" value="${userForm.getUsername() }" /><br />
    <span>密码*：</span><input type="password" name="password" value="${userForm.getPassword() }" /><br />
    <span>确认密码*：</span><input type="password" name="repassword" /><br />
    <span>电话：</span><input type="text" name="cellphone" value="${userForm.getCellphone() }" /><br />
    <span>手机：</span><input type="text" name="mobilephone" value="${userForm.getMobilephone() }" /><br />
    <span>住址：</span><input type="text" name="address" value="${userForm.getAddress() }" /><br />
    <span>油箱*：</span><input type="text" name="email" value="${userForm.getEmail() }" /><br />
    ${register_msg }<br />
    <input type="submit" />
    </form>
  </body>
</html>
