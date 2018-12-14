<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>新增员工信息</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		 <style type="text/CSS">
      <!--
        body{
         font-family: Arial,Helvetica,宋体;
         font-size:12px;
         color:#666666;
         background:#fff;
         text-align:center;
      }
    
      *{
       margin:0;
       padding:0;
      }
     
      a {
        color:#1E7ACE;
        text-decoration:none;
      }
     
      a:hover {
        color:#000;
        text-decoration:none;     
      }
     
      h3 {
        font-size:14px;     
        font-decoration:underline;
      }
     
      pre,p {
        color:#1E7ACE;
        margin:4px;
      }
  
      input, select,textarea{
        padding:1px;
        margin:2px;
        font-size:11px;
      }
     
      .button{
        padding:1px 10px;
        font-size:12px;
        border:1px #1E7ACE solid;
        background:#D0F0FF;
      }    
      #formwrapper {
        width:450px;
        margin:15px auto;
        padding:20px;
        text-align:left;
        border:1px #1E7ACE solid;
      }
       
      fieldset {      
        padding:10px;
        margin-top:5px;
        border:1px solid #1E7ACE;
        background:#fff;
      }
      fieldset label {
        float:left;
        width:120px;
        text-align:right;
        padding:4px;
        margin:1px;  
      } 
 
      fieldset div {
        clear:left;
        margin-bottom:2px;
      }
      .enter{ text-align:center;}
      -->
     </style>
	</head>
	<body>
		<div style="text-align: center;">
			 <div id="formwrapper">
      <h3>新增员工信息</h3>
      <form action="./servlet/PersonServlet?methodName=addPerson" method="post" name="" id="">
        <fieldset>
         <div>
            <label for="workerid">工号</label>
            <input type="text" name="workerid" id="workerid" size="20" maxlength="40" />
            <br />
          </div>
          <div>
            <label for="workername">姓名</label>
            <input type="text" name="workername" id="workername" size="20" maxlength="40" />
            <br />
          </div>
          <div>
            <label for="age">年龄</label>
            <input type="text" name="age" id="age" size="20" maxlength="40" />
            <br />
          </div>
         <div>
            <label for="sex">性别</label>
             <select name="sex">
            	<option value="男">男</option>
            	<option value="女">女</option>
            </select>
            <br />
          </div>
          <div>
            <label for="title">职称</label>
            <input type="text" name="title" id="title" size="20" maxlength="40" />
            <br />
          </div>
          <div>
            <label for="teleno">联系电话</label>
            <input type="text"   name="teleno"   id="teleno"   size="20"   maxlength="40"/>
            <br />
          </div>
           <div>
            <label for="email">邮箱</label>
            <input   type="text"   name="email"   id="email"   size="20"   maxlength="40"/>
            <br />
          </div>
         
          <div style="float: right;margin-right: 150px ">
            <input  name="login" type="submit" class="button" value="提交">
          </div>
        </fieldset>      
      </from>
      <br />
     
    </div>
		</div>
	</body>
</html>
	