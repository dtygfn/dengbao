<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isErrorPage="true"%>
<%@ page language="java" import="com.bean.User"%>
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
<title>菜单管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function showsubmenu(sid) {
		var othersid = [ 1, 2, 3, 4, 5, 6 ,7];
		whichEl = eval("submenu" + sid);
		for (i = 0; i < othersid.length; i++) {
			imgmenu = eval("imgmenu" + othersid[i]);
			if (sid == othersid[i]) {
				if (whichEl.style.display == "none") {
					eval("submenu" + sid + ".style.display=\"\";");
					imgmenu.background = "images/main_47.gif";
				} else {
					eval("submenu" + sid + ".style.display=\"none\";");
					imgmenu.background = "images/main_48.gif";
				}
			} else {
				eval("submenu" + othersid[i] + ".style.display=\"none\";");
				imgmenu.background = "images/main_48.gif";
			}
		}

	}
</script>
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
	color: black;
}

.STYLE3 {
	font-size: 12px;
	color: #033d61;
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
</style>
<style type="text/css">
.menu_title SPAN {
	FONT-WEIGHT: bold;
	LEFT: 3px;
	COLOR: #ffffff;
	POSITION: relative;
	TOP: 2px
}

.menu_title2 SPAN {
	FONT-WEIGHT: bold;
	LEFT: 3px;
	COLOR: #FFCC00;
	POSITION: relative;
	TOP: 2px
}
</style>
</head>
<body>
	<s:form namespace="/" action="loginAction!login.action" method="post">
		<table width="165" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="28" background="images/main_40.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="19%">&nbsp;</td>
							<td width="81%" height="20" style="padding-left: 30px"><span
								class="STYLE1"></span>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="151" border="0" align="center" cellpadding="0"
						cellspacing="0">



						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="23" background="images/main_48.gif" id="imgmenu1"
											class="menu_title" onMouseOver="this.className='menu_title';"
											onClick="showsubmenu(1)"
											onMouseOut="this.className='menu_title';"
											style="cursor: hand">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="18%">&nbsp;</td>
													<td valign="top"><br></td><td width="82%" class="STYLE1">
														项目信息管理
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td background="images/main_51.gif" id="submenu1"
											style="DISPLAY: none">
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="images/left.gif" width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="75%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<a href="<%=path%>/servlet/ProjectServlet?methodName=getProjectEdits" target="sI2">
																						<span class="STYLE3" onmouseover="this.style.color='red';"
																							onmouseout="this.style.color='#033d61';">
																							项目基本信息
																						</span>
																					</a>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													
																					
													<tr>
														<td height="5"><img src="images/main_52.gif"
															width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>

								</table>
							</td>
						</tr>
						
						
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="23" background="images/main_48.gif" id="imgmenu2"
											class="menu_title" onMouseOver="this.className='menu_title';"
											onClick="showsubmenu(2)"
											onMouseOut="this.className='menu_title';"
											style="cursor: hand">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="18%">&nbsp;</td>
													<td valign="top"><br></td><td width="82%" class="STYLE1">
														员工信息管理
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td background="images/main_51.gif" id="submenu2"
											style="DISPLAY: none">
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="images/left.gif" width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="75%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<a href="<%=path%>/servlet/PersonServlet?methodName=getPersonEdits" target="sI2">
																						<span class="STYLE3" onmouseover="this.style.color='red';"
																							onmouseout="this.style.color='#033d61';">
																					                  员工基本信息
																						</span>
																					</a>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													
													
													
													
																				
													<tr>
														<td height="5"><img src="images/main_52.gif"
															width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>

								</table>
							</td>
						</tr>
						
						
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="23" background="images/main_48.gif" id="imgmenu3"
											class="menu_title" onMouseOver="this.className='menu_title';"
											onClick="showsubmenu(3)"
											onMouseOut="this.className='menu_title';"
											style="cursor: hand">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="18%">&nbsp;</td>
													<td valign="top"><br></td><td width="82%" class="STYLE1">
												                  任务进度管理
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td background="images/main_51.gif" id="submenu3"
											style="DISPLAY: none">
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="images/left.gif" width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="75%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<a href="<%=path%>/servlet/TaskServlet?methodName=getTaskEdits" target="sI2">
																						<span class="STYLE3" onmouseover="this.style.color='red';"
																							onmouseout="this.style.color='#033d61';">
																						任务分配
																						</span>
																					</a>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
														<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="images/left.gif" width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="75%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																			      <a href="<%=path%>/servlet/ProgressServlet?methodName=getProgressEdits" target="sI2">
																						<span class="STYLE3" onmouseover="this.style.color='red';"
																							onmouseout="this.style.color='#033d61';">
																					     进度管理
																						</span>
																					</a>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>

														<td height="5"><img src="images/main_52.gif"
															width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>

								</table>
							</td>
						</tr>
						
						
						
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="23" background="images/main_48.gif" id="imgmenu4"
											class="menu_title" onMouseOver="this.className='menu_title';"
											onClick="showsubmenu(4)"
											onMouseOut="this.className='menu_title';"
											style="cursor: hand">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="18%">&nbsp;</td>
													<td valign="top"><br></td><td width="82%" class="STYLE1">
														回款信息管理
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td background="images/main_51.gif" id="submenu4"
											style="DISPLAY: none">
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="images/left.gif" width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="75%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<a href="<%=path%>/servlet/PaybackServlet?methodName=getPaybackEdits" target="sI2">
																						<span class="STYLE3" onmouseover="this.style.color='red';"
																							onmouseout="this.style.color='#033d61';">
																						回款基本信息
																						</span>
																					</a>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													
													<tr>
														<td height="5"><img src="images/main_52.gif"
															width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>

								</table>
							</td>
						</tr>
						
						
							<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="23" background="images/main_48.gif" id="imgmenu5"
											class="menu_title" onMouseOver="this.className='menu_title';"
											onClick="showsubmenu(5)"
											onMouseOut="this.className='menu_title';"
											style="cursor: hand">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="18%">&nbsp;</td>
													<td valign="top"><br></td><td width="82%" class="STYLE1">
													个人信息管理
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td background="images/main_51.gif" id="submenu5"
											style="DISPLAY: none">
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	
																</tr>
															</table>
														</td>
													</tr>
													
													<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="images/left.gif" width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="75%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<a href="<%=path%>/servlet/PersonServlet?methodName=toUpdateUser" target="sI2">
																						<span class="STYLE3" onmouseover="this.style.color='red';"
																							onmouseout="this.style.color='#033d61';">
																					          修改个人信息
																						</span>
																					</a>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="images/left.gif" width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="75%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<a href="<%=path%>/servlet/UserServlet?methodName=toUpdatePassword" target="sI2">
																						<span class="STYLE3" onmouseover="this.style.color='red';"
																							onmouseout="this.style.color='#033d61';">
																					          修改密码
																						</span>
																					</a>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													

													<tr>
														<td height="5"><img src="images/main_52.gif"
															width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>

								</table>
							</td>
						</tr>
						
						
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="23" background="images/main_48.gif" id="imgmenu6"
											class="menu_title" onMouseOver="this.className='menu_title';"
											onClick="showsubmenu(6)"
											onMouseOut="this.className='menu_title';"
											style="cursor: hand">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="18%">&nbsp;</td>
													<td valign="top"><br></td><td width="82%" class="STYLE1">
														用户信息管理
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td background="images/main_51.gif" id="submenu6"
											style="DISPLAY: none">
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="images/left.gif" width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="75%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<a href="<%=path%>/servlet/UserServlet?methodName=getUserEdits" target="sI2">
																						<span class="STYLE3" onmouseover="this.style.color='red';"
																							onmouseout="this.style.color='#033d61';">
																						用户权限管理
																						</span>
																					</a>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													
													<tr>
														<td height="5"><img src="images/main_52.gif"
															width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>

								</table>
							</td>
						</tr>
							
						
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="23" background="images/main_48.gif" id="imgmenu7"
											class="menu_title" onMouseOver="this.className='menu_title';"
											onClick="showsubmenu(7)"
											onMouseOut="this.className='menu_title';"
											style="cursor: hand">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="18%">&nbsp;</td>
													<td valign="top"><br></td><td width="82%" class="STYLE1">
														查看统计信息
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td background="images/main_51.gif" id="submenu7"
											style="DISPLAY: none">
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="images/left.gif" width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="75%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<a href="<%=path%>/servlet/ChartServlet?methodName=getProChart" target="sI2">
																						<span class="STYLE3" onmouseover="this.style.color='red';"
																							onmouseout="this.style.color='#033d61';">
																							项目等级统计图
																						</span>
																					</a>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													
													
													

													<tr>
														<td height="5"><img src="images/main_52.gif"
															width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<table width="90%" border="0" align="center"
																cellpadding="0" cellspacing="0">
																<tr>
																	<td width="16%" height="25">
																		<div align="center">
																			<img src="images/left.gif" width="10" height="10" />
																		</div>
																	</td>
																	<td width="84%" height="23">
																		<table width="75%" border="0" cellspacing="0"
																			cellpadding="0">
																			<tr>
																				<td height="20" style="cursor: hand"
																					onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
																					onmouseout="this.style.borderStyle='none'">
																					<a href="<%=path%>/servlet/ChartServlet?methodName=getPerChart" target="sI2">
																						<span class="STYLE3" onmouseover="this.style.color='red';"
																							onmouseout="this.style.color='#033d61';">
																							员工职称统计图
																						</span>
																					</a>
																				</td>
																			</tr>
																		</table>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													
													
													

													<tr>
														<td height="5"><img src="images/main_52.gif"
															width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
											
										</td>
									</tr>

								</table>
							</td>
						</tr>
						
					</table>
				</td>
			</tr>

			<tr>
				<td height="20" background="images/main_58.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="20" valign="bottom">
								<div align="center" class="STYLE3">
									<font color="#f0f66" style="font-weight: blod;">【等保测评</font>
									<font color="#f0f66" style="font-weight: blod;">项目管理系统】</font>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>