<%@page import="com.bean.User"%>
<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Date date = Calendar.getInstance().getTime();
	SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 E");
	String currentDate = df.format(date);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: balack;
}
.STYLE2 {font-size: 9px}
.STYLE3 {
	color: black;
	font-size: 13px;
}
a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
}

a:active {
	text-decoration: none;
}
-->
</style></head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="70" background="images/main_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" height="24" background="images/main_03.gif">&nbsp;</td>
            <td width="505" background="images/main_04.gif">&nbsp;</td>
            <td>&nbsp;</td>
            <td width="21"><img src="images/main_07.gif" width="21" height="24"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="38"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" height="38" background="images/main_09.gif">&nbsp;</td>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="77%" height="25" valign="bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
					 	<td width="240" align="right" style="color: black;font-size: 12px">
					 	当前用户为：
					 	
					 	<c:if test="${empty user}">
					 		<script type="text/javascript">
					 			window.location='/Team/ControllerServlet?action=Login&method=exit';
					 		</script>
					 	</c:if>
					 	<c:if test="${!empty user}">
					 		<%=(((User)request.getSession().getAttribute("user")).getName())%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
						</c:if>
					</tr>
					 	
					</tr>
                </table></td>
                <td width="220" valign="bottom"  nowrap="nowrap"><div align="right"><span class="STYLE1"><span class="STYLE2">☆</span> 今天是：<%=currentDate %></span></div></td>
              </tr>
            </table></td>
            <td width="21"><img src="images/main_11.gif" width="21" height="38"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="8" style=" line-height:8px;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" background="images/main_29.gif" style=" line-height:8px;">&nbsp;</td>
            <td width="505" background="images/main_30.gif" style=" line-height:8px;">&nbsp;</td>
            <td style=" line-height:8px;">&nbsp;</td>
            <td width="21" style=" line-height:8px;"><img src="images/main_31.gif" width="21" height="8"></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="28" background="images/main_36.gif"><table width="100%" border="0" cellspacing="0" cellpadding="">
      <tr>
        <td width="177" height="28" background="images/main_32.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="20%"  height="22">&nbsp;</td>
            <td width="59%" valign="bottom"><div align="center" class="STYLE1">*菜单导航*</div></td>
            <td width="21%">&nbsp;</td>
          </tr>
         </table></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
             
             <td width="65">
	             <table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
		              <tr>
                          &nbsp;
		              </tr>
	            </table>
            </td>
                    <td width="65">
	             <table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
		              <tr>
		              	  &nbsp;
		              </tr>
	            </table>
            </td>
           
            
            <td width="65">
	             <table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
		              <tr>
		            		&nbsp;
		              </tr>
	            </table>
            </td>
            
             <td width="65"><table width="90" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              	   
              </tr>
            </table></td>
            <td width="65"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              &nbsp;
              </tr>
            </table></td>
            <td width="65"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              &nbsp;
              </tr>
            </table></td>
            <td width="65"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              &nbsp;
              </tr>
            </table></td>
               <td width="65"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              &nbsp;
              </tr>
            </table></td>
               <td width="65"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              &nbsp;
              </tr>
            </table></td>
               <td width="65"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              &nbsp;
              </tr>
            </table></td>
            <td width="65"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              &nbsp;
              </tr>
            </table></td>
            <td width="65"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              &nbsp;
              </tr>
            </table></td>
            <td width="65"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              &nbsp;
              </tr>
            </table></td>
            <td width="65"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              &nbsp;
              </tr>
            </table></td>
            <td width="65"><table width="58" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              <!-- <td height="20" style="cursor:hand" onMouseOver="this.style.backgroundImage='url(images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7';" onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><a href="autoGenerateJavaCodeMenu.jsp" target="I1"><div align="center" style="font-size: 12px;color:blue" class="STYLE3" onmouseover="this.style.color='red';" onmouseout="this.style.color='blue'">代码生成</div></a></td> -->
              </tr>
            </table></td>
             <td width="100"><img src="images/main_34.gif" width="3" height="28"></td>
            <td width="65"><table width="58" border="0"  align="center" cellpadding="0" cellspacing="0">
              <tr>
				<td height="20" style="cursor:hand;" onMouseOver="this.style.backgroundImage='url(images/bg.gif)';this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#a6d0e7'; " onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><a href="<%=path%>/servlet/LoginServlet?methodName=loginOut" target="_parent"><div align="center" style="font-size: 12px;color:#1A2152" onmouseover="this.style.color='red';" onmouseout="this.style.color='#BD2F1E'">退出系统</div></a></td>
              </tr>
            </table></td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        <td width="21"><img src="images/main_37.gif" width="21" height="28"></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>