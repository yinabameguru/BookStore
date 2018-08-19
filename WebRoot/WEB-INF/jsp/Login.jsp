<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	
	<script type="text/javascript">
	function ChangeCode() {
		var img= document.getElementsByTagName("img")[0];
		var time=new Date().getTime();
		img.src= "${pageContext.request.contextPath }/CodeServlet?time="+time;
	}
	</script>

  </head>
  
  <body>
  <span>请登录</span>
  <form action="${pageContext.request.contextPath }/LoginServlet">
    <span>用户名：</span><input type="text" name="username" value="${username }" /><br />
    <span>密码：</span><input type="password" name="password" /><br />
    <span>验证码：</span><input type="text" name="codeForm" /><img alt="" src="${pageContext.request.contextPath }/CodeServlet" onclick="ChangeCode();"/><a href="javascript:ChangeCode();">换一张</a><br />
    ${login_msg }<br />
    <input type="submit" /><a href="${pageContext.request.contextPath }/Register">注册</a>
    </form>
  </body>
</html>
