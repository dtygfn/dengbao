<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>等保测评项目管理系统_用户登录</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	
		function login(){
			var username=$('#username').val();
			var password=$('#password').val();
			var usermes=$('#usermes');
			var pwdmes=$('#pwdmes');
			if(username=='' || username==null){
				usermes.text('用户名不能为空！');
			}else{
				usermes.text('');
			}
			
			if(password=='' || password==null){
				pwdmes.text('密码不能为空！');
			}else{
				pwdmes.text('');
			}
			
			if(username!='' && password!=''){
				//var url="<%=path%>/servlet/LoginServlet?methodName=login";
				window.location.href="<%=path%>/servlet/LoginServlet?methodName=login&username="+username+"&password="+password;
			}
		}
	

</script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color:#1B5BA3 ;
	overflow:hidden;
	
}
.STYLE1 {
	color: #000000;
	font-size: 12px;
}
span{
	color: red;
	font-size: 12px;
}
-->
</style></head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="10">
  <tr>
    <td><table width="957" border="0"  align="center" cellpadding="0" cellspacing="">
      <tr>
        <td height="235" background="images/logintop.png">&nbsp;</td>
      </tr>
      <tr>
        <td height="53"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="394" height="53" background="images/loginleft.png">&nbsp;</td>
            <td width="213" background="images/logincente.png"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="16%" height="25"><div align="right"><span class="STYLE1">用户:</span></div></td>
                <td width="57%" height="25"><div align="center">
                  <input type="text" name="username" id="username" style="width:105px; height:17px; background-color:; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                  <span id="usermes"></span>
                </div></td>
                <td width="27%" height="25">&nbsp;</td>
              </tr>
              <tr>
                <td height="25"><div align="right"><span class="STYLE1">密码:</span></div></td>
                <td height="25"><div align="center">
                  <input type="password" name="password" id="password" style="width:105px; height:17px; background-color:; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
               		<span id="pwdmes"></span>
                </div></td>
                <td height=""><div align="left"><img src="images/dl.gif" width="49" height="18" border="0" onclick="login();"></div></td>
              </tr>
            </table></td>
            <td width="362" background="images/loginright1.png">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="213" background="images/loginmoddon.png">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
