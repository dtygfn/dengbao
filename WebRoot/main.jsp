<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

%>

<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<title>等保测评项目管理系统</title>
</head>
<frameset rows="98,*,8" frameborder="no" border="0" framespacing="0">
	<frame src="<%=path%>/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
	<frame src="<%=path%>/center.jsp" scrolling="no" name="mainFrame" id="mainFrame" />
	<frame src="<%=path%>/down.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes></noframes>
<body>
	<s:form namespace="/" action="loginAction!login.action" method="post"></s:form>
</body>
	
</html>