<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$('#check').click(function(){
			var check=$('#check').find('input[type="checkbox"]');
			if (check.is(":checked")) {
				$(":checkbox").prop("checked", false);
			}else{
				$(":checkbox").prop("checked", true);
			}
		});
	});
	function add(page){
		window.parent.iframesrc('pages/'+page+'Add.jsp');
	}
	
	function deleteTask(userProjectid){
		if(confirm("您真的要删除这条数据吗？")){
			window.location.href="<%=path%>/servlet/TaskServlet?methodName=deleteTask&projectid="+userProjectid;
		}
	}
	function edits(projectid){
		window.location="./TaskServlet?methodName=toUpdateTask&projectid="+projectid;
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

.STYLE1 {
	font-size: 12px;
	cursor: pointer;
}

.STYLE3 {
	font-size: 12px;
	font-weight: bold;
}

.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>

<script>
var  highlightcolor='#ADCEAD';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>

</head>

<body>
	<a onclick="add()"></a>
	<pg:pager url="./TaskServlet" maxIndexPages="3" maxPageItems="8"
		items="${count}" isOffset="true"
		export="offset,currentPageNumber=pageNumber">
		<pg:param name="methodName" value="getTaskEdits" />
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30" background="<%=path%>/images/tab_05.gif"><table
						width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="30"><img
								src="<%=path%>/images/tab_03.gif" width="12" height="30" /></td>
							<td><table width="100%" border="0" cellspacing="0"
									cellpadding="0">


									<tr>
										<td width="46%" valign="middle"><table width="100%"
												border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="5%"><div align="center">
															<img src="<%=path%>/images/tb.gif" width="16" height="16" />
														</div></td>
													<td width="95%" class="STYLE1"><span class="STYLE3">*任务分配管理</span></td>
												</tr>
											</table></td>
										<td width="54%"><table border="0" align="right"
												cellpadding="0" cellspacing="0">
												<tr>
													<td width="60"><table width="87%" border="0"
															cellpadding="0" cellspacing="0">
															<tr id="check">
																<td class="STYLE1"><div align="center">
																		<input type="checkbox" name="checkbox62"
																			value="checkbox" />
																	</div></td>
																<td class="STYLE1"><div align="center">全选</div></td>
															</tr>
														</table></td>
													<td width="60"><table width="90%" border="0"
															cellpadding="0" cellspacing="0">
															<tr>
																<td class="STYLE1"><div align="center">
																		<img src="<%=path%>/images/22.gif" width="14"
																			height="14" />
																	</div></td>
																<td class="STYLE1"><div align="center">
																		<a href="<%=path%>/pages/task/taskAdd.jsp">新增 </a>
																		
																	</div></td>
															</tr>
														</table></td>
													<td width="60"><table width="90%" border="0"
														cellpadding="0" cellspacing="0">
															<tr>
																<td class="STYLE1"><div align="center">
																		<img src="<%=path%>/images/22.gif" width="14" height="14" />
																	</div></td>
																<td class="STYLE1"><div align="center">
																		<a href="<%=path%>/pages/task/taskSelectAdd.jsp"> 查询 </a>
																	</div></td>
															</tr>
														
													</table>
												</td>
												<td class="STYLE1">
												    <div align="center">
													     <a href="<%=path%>/servlet/TaskServlet?methodName=excelExport"> 导出数据 </a>
									                </div>
									            </td>

												</tr>
											</table></td>
									</tr>
								</table></td>
							<td width="16"><img src="<%=path%>/images/tab_07.gif"
								width="16" height="30" /></td>
						</tr>
					</table></td>
			</tr>
			
			<tr>
				<td><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="8" background="<%=path%>/images/tab_12.gif">&nbsp;</td>
							<td><table width="100%" border="0" cellpadding="0"
									cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"
									onmouseout="changeback()">
									<tr>
										<td width="3%" height="22"
											background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"><div
												align="center">
												<input type="checkbox" name="checkbox" value="checkbox" />
											</div></td>
											<td width="3%" height="22"
											background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"><div
												align="center">
												<span class="STYLE1">序号</span>
											</div></td>
											<td width="6%" height="18"
											background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"><div
												align="center">
												<span class="STYLE1">项目编号</span>
											</div></td>
										<td width="13%" height="18"
											background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"><div
												align="center">
												<span class="STYLE1">项目名称</span>
											</div></td>
										<td width="12%" height="18"
											background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"><div
												align="center">
												<span class="STYLE1">前期阶段</span>
											</div></td>
										<td width="6%" background="<%=path%>/images/bg.gif""
											bgcolor="#FFFFFF"><div align="center">
												<span class="STYLE1">前期人员</span>
											</div></td>
										<td width="10%" height="22"
											background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"><div
												align="center">
												<span class="STYLE1">中期阶段</span>
											</div></td>
										<td width="6%" height="22"
											background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"><div
												align="center">
												<span class="STYLE1">中期人员</span>
											</div></td>
										<td width="10%" height="22"
											background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"><div
												align="center">
												<span class="STYLE1">后期阶段</span>
											</div></td>
											<td width="6%" height="22"
											background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"><div
												align="center">
												<span class="STYLE1">后期人员</span>
											</div></td>
										<td width="8%" height="22"
											background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"><div
												align="center">
												<span class="STYLE1">项目负责人</span>
											</div></td>
										<td width="12%" height="15"
											background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"
											class="STYLE1"><div align="center">
												<span class="STYLE1">基本操作</span>
											</div></td>
									</tr>

									<c:forEach items="${taskList}" var="task" varStatus="s">
										<pg:item>
											<tr id="content">
												<td height="20" bgcolor="#FFFFFF"><div align="center">
														<input type="checkbox" name="checkbox2" value="checkbox" />
													</div></td>
													<td height="20" bgcolor="#FFFFFF"><div align="center"
														class="STYLE1">
														<div align="center">${s.count+offset}</div>
													</div></td>
													<td height="20" bgcolor="#FFFFFF"><div align="center">
														<span class="STYLE1">${task.projectid}</span>
													</div></td>
												<td height="20" bgcolor="#FFFFFF"><div align="center">
														<span class="STYLE1">${task.name}</span>
													</div></td>
												<td height="20" bgcolor="#FFFFFF"><div align="center">
														<span class="STYLE1">${task.early}</span>
													</div></td>
												<td bgcolor="#FFFFFF"><div align="center">
														<span class="STYLE1">${task.earperson}</span>
													</div></td>
												<td height="20" bgcolor="#FFFFFF"><div align="center">
														<span class="STYLE1">${task.middle}</span>
													</div></td>
												<td height="20" bgcolor="#FFFFFF"><div align="center">
														<span class="STYLE1">${task.midperson}</span>
													</div></td>
												<td height="20" bgcolor="#FFFFFF"><div align="center">
														<span class="STYLE1">${task.late}</span>
													</div></td>
												<td height="20" bgcolor="#FFFFFF"><div align="center">
														<span class="STYLE1">${task.lateperson}</span>
													</div></td>
												<td height="20" bgcolor="#FFFFFF"><div align="center">
														<span class="STYLE1">${task.leader}</span>
													</div></td>
											<td height="20" bgcolor="#FFFFFF"><div align="center">
														<span class="STYLE4"> <a
															onclick="edits('${task.projectid}')" style="border: 0"><img
																src="<%=path%>/images/edt.gif" width="16" height="16" />编辑</a>&nbsp;
															&nbsp; <a onclick="deleteTask('${task.projectid}')"><img
																src="<%=path%>/images/del.gif" width="16" height="16" />删除</a>
														</span>
													</div></td>
											</tr>
										</pg:item>
									</c:forEach>
								</table></td>
							<td width="8" background="<%=path%>/images/tab_15.gif">&nbsp;</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="35" background="<%=path%>/images/tab_19.gif"><table
						width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="12" height="35"><img src="images/tab_18.gif"
								width="12" height="35" /></td>
							<td class="STYLE4" align="center"><pg:index>
									<pg:first>
										<a href="<%=pageUrl%>">首页</a>
									</pg:first>
									<pg:prev>
										<a href="<%=pageUrl%>">上一页</a>
									</pg:prev>
									<pg:pages>
										<a href="<%=pageUrl%>"><%=pageNumber%></a>
									</pg:pages>
									<pg:next>
										<a href="<%=pageUrl%>">下一页</a>
									</pg:next>
									<pg:last>
										<a href="<%=pageUrl%>">末页</a>
									</pg:last>
								</pg:index> <span style="margin-left: 60%"> <font
									style="font-size: 12">当前页：<span style="color: #930000"><%=currentPageNumber%></span>/<pg:last><%=pageNumber%></pg:last>
								</font>&nbsp;&nbsp; <font style="font-size: 12">共<span
										style="color: blue">${count}</span> 条记录</font> </span></td>
							<td width="16"><img src="<%=path%>/images/tab_20.gif" width="16"
								height="35" /></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</pg:pager>
</body>
</html>
