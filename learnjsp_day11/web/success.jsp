<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	欢迎你：<%
		String userName = (String)session.getAttribute("name");
		out.print(userName);
	 %>
	 
	 <a href="/home.jsp">跳到主页</a>

	欢迎你：${param.userName } <!-- ${param.userName }==request.getParamemter("userName"); -->

	${paramValues.hobby[0] }

	<%-- ${header["User-agent"] } --%>

	${cookie.JSESSIONID.value }
</body>
</html>