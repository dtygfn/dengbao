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

		<title>编辑项目信息</title>
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
      <h3>编辑任务分配</h3>
      <form action="./servlet/TaskServlet?methodName=updateTask" method="post" name="" id="">
        <fieldset>
          <legend>项目信息</legend>

          <div>
            <label for="projectid">项目编号</label>
            <input type="text" name="projectid"  size="24" maxlength="40" value="${task.projectid}" readonly="readonly"/>
            <br />
          </div>
          <div>
            <label for="name">项目名称</label>
            <input type="text" name="name" id="name" size="24" maxlength="40" value="${task.name}"/>
            <br />
          </div>
         <div>
            <label for="early">前期阶段</label>
            <input type="text" name="early" id="early" size="24" maxlength="40" value="${task.early}" readonly="readonly"/>
            <br />
          </div>
          <div>
            <label for="earperson">前期人员</label>
            <input type="text" name="earperson" id="earperson" size="24" maxlength="40" value="${task.earperson}"/>
            <br />
          </div>
           <div>
            <label for="middle">中期阶段</label>
            <input type="text" name="middle" id="middle" size="24" maxlength="40" value="${task.middle}" readonly="readonly"/>
            <br />
          </div>
          <div>
            <label for="midperson">中期人员</label>
            <input type="text" name="midperson" id="midperson" size="24" maxlength="40" value="${task.midperson}"/>
            <br/>
          </div>
          <div>
            <label for="late">后期阶段</label>
            <input type="text" name="late" id="late" size="24" maxlength="40" value="${task.late}" readonly="readonly"/>
            <br />
          </div>
          <div>
            <label for="lateperson">中期人员</label>
            <input type="text" name="lateperson" id="lateperson" size="24" maxlength="40" value="${task.lateperson}"/>
            <br/>
          </div>
          <div>
            <label for="leader">项目负责人</label>
            <input type="text" name="leader" id="leader" size="24" maxlength="40" value="${task.leader}"/>
            <br/>
          </div>
          <div style="float: right; margin-right: 150px;">
            <input  name="login" type="submit" class="button" value="修改">
          </div>
        </fieldset>      
      </from>
      <br />
     
    </div>
		</div>
	</body>
</html>
