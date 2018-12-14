<%@ page language="java" import="com.bean.User"%>
<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">

	function iframesrc(flag){
		$("#concents").attr("src",flag);
	}

</script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<style>
.navPoint {
	COLOR: white;
	CURSOR: hand;
	FONT-FAMILY: Webdings;
	FONT-SIZE: 9pt
}
</style>
<script>
	function switchSysBar() {
		var locate = location.href.replace('middel.jsp', '');
		var ssrc = document.all("img1").src.replace(locate, '');
		if (ssrc == "images/main_55.gif") {
			document.all("img1").src = "images/main_55_1.gif";
			document.all("frmTitle").style.display = "none"
		} else {
			document.all("img1").src = "images/main_55.gif";
			document.all("frmTitle").style.display = ""
		}
	}
</script>

</head>

<body style="overflow:hidden">

	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0" style="table-layout:fixed;">
	
	<c:if test="${user.jurisdiction==0 }">
		<tr>
			<td width="171" id=frmTitle noWrap name="fmTitle" align="center"
				valign="top"><table width="171" height="100%" border="0"
					cellpadding="0" cellspacing="0" style="table-layout:fixed;">
					<tr>
						<td bgcolor="#1873aa" style="width:6px;">&nbsp;</td>
						<td width="165"><iframe name="I1" height="100%" width="165"
								src="pages/menu/admin.jsp" border="0" frameborder="0" scrolling="no">
								浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
						</td>
					</tr>
				</table></td>
			<td width="6" style="width:6px;" valign="middle" bgcolor="1873aa"
				onclick=switchSysBar()><SPAN class=navPoint id=switchPoint
				title=关闭/打开左栏><img src="images/main_55.gif" name="img1"
					width=6 height=40 id=img1>
			</SPAN>
			</td>
			<td width="100%" align="center" valign="top">
			<iframe id="concents" name="sI2"
					height="100%" width="100%" border="0" frameborder="0"
					src="right.jsp"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
			</td>
		</tr>
	</c:if>

	<c:if test="${user.jurisdiction==1 }">
		<tr>
			<td width="171" id=frmTitle noWrap name="fmTitle" align="center"
				valign="top"><table width="171" height="100%" border="0"
					cellpadding="0" cellspacing="0" style="table-layout:fixed;">
					<tr>
						<td bgcolor="#1873aa" style="width:6px;">&nbsp;</td>
						<td width="165"><iframe name="I1" height="100%" width="165"
								src="pages/menu/user.jsp" border="0" frameborder="0" scrolling="no">
								浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
						</td>
					</tr>
				</table></td>
			<td width="6" style="width:6px;" valign="middle" bgcolor="1873aa"
				onclick=switchSysBar()><SPAN class=navPoint id=switchPoint
				title=关闭/打开左栏><img src="images/main_55.gif" name="img1"
					width=6 height=40 id=img1>
			</SPAN>
			</td>
			<td width="100%" align="center" valign="top">
			<iframe id="concents" name="sI2"
					height="100%" width="100%" border="0" frameborder="0"
					src="right.jsp"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
			</td>
			
		</tr>
		</c:if>
	</table>
	
</body>
</html>

