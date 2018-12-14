package com.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.flow.builder.ReturnBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Task;
import com.dao.PersonDao;
import com.dao.TaskDao;
import com.dao.impl.PersonDaoImpl;
import com.dao.impl.TaskDaoImpl;

public class TaskServlet extends HttpServlet{
	/**
	 *任务分配的Servlet
	 */
	private static final long serialVersionUID = -4704909855397703734L;
	TaskDao  taskDao = new TaskDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("methodName");
		if(methodName!=null&&!methodName.equals("")&&methodName.equals("getTask")){
			getTask(request, response);
		}else if(methodName.equals("deleteTask")){
			deleteTask(request,response);
		}else if(methodName.equals("toUpdateTask")){
			toUpdateTask(request,response);
		}else if(methodName.equals("updateTask")){
			updateTask(request,response);
		}else if(methodName.equals("addTask")){
			addTask(request,response);
		}else if(methodName.equals("getTaskEdits")){
			getTaskEdits(request,response);
		}else if(methodName.equals("selectTask")){
			selectTask(request,response);
		}else if(methodName.equals("excelExport")){
			excelExport(request,response);
		}
	}
	/**
	 * 查询页面获取任务分配信息列表
	 */
	public void getTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		List<Task> taskList = null;
        int count = 0;
		PersonDao personDao = new PersonDaoImpl();
		if (personDao.queryByWorkerid(LoginServlet.username).getTitle().equals("售前工程师")) {
			taskList = taskDao.getEarTaskList(intOffSet,LoginServlet.username);
			count = taskDao.getEarCount(LoginServlet.username);
		}else if (personDao.queryByWorkerid(LoginServlet.username).getTitle().equals("初级测评师")){
			taskList = taskDao.getMidTaskList(intOffSet,LoginServlet.username);
			count = taskDao.getMidCount(LoginServlet.username);
		}else if (personDao.queryByWorkerid(LoginServlet.username).getTitle().equals("中级测评师")){
			taskList = taskDao.getLateTaskList(intOffSet,LoginServlet.username);
            count = taskDao.getLateCount(LoginServlet.username);
		}
		request.setAttribute("taskList", taskList);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/pages/task/taskSelect.jsp").forward(request, response);
	}
	/**
	 * 编辑界面获取任务信息列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getTaskEdits(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		
		List<Task> taskList = taskDao.getTaskList(intOffSet);
		request.setAttribute("taskList", taskList);
		request.setAttribute("count", taskDao.getCount());
		request.getRequestDispatcher("/pages/task/taskEdits.jsp").forward(request, response);
	}
	/**
	 * 删除任务信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		String projectid = request.getParameter("projectid");
		taskDao.deleteTask(projectid);
		List<Task> taskList = taskDao.getTaskList(intOffSet);
		request.setAttribute("taskList", taskList);
		request.getRequestDispatcher("/pages/task/taskEdits.jsp").forward(request, response);
	}
	/**
	 * 根据Id查询信息后跳转到更新信息界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdateTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String projectid = request.getParameter("projectid");
		Task task = taskDao.queryByProjectid(projectid);
		request.setAttribute("task", task);
		request.getRequestDispatcher("/pages/task/taskUpdate.jsp").forward(request, response);
		
	}
	/**
	 * 执行修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		//String id = request.getParameter("id");
		Task task = new Task();
		//pson.setId(Integer.parseInt("id"));
		
		task.setProjectid(request.getParameter("projectid"));
		System.out.println(task.getProjectid());

		task.setName(request.getParameter("name"));
		task.setEarly(request.getParameter("early"));
		task.setEarperson(request.getParameter("earperson"));
		task.setMiddle(request.getParameter("middle"));
		task.setMidperson(request.getParameter("midperson"));
		task.setLate(request.getParameter("late"));
		task.setLateperson(request.getParameter("lateperson"));
		task.setLeader(request.getParameter("leader"));
		
		taskDao.updateTask(task,task.getProjectid());
		
		List<Task> taskList = taskDao.getTaskList(intOffSet);
		request.setAttribute("taskList", taskList);
		request.getRequestDispatcher("/pages/task/taskEdits.jsp").forward(request, response);
	}
	/**
	 * 添加用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		Task task = new Task();
		
		task.setProjectid(request.getParameter("projectid"));
		task.setName(request.getParameter("name"));
		task.setEarly(request.getParameter("early"));
		task.setEarperson(request.getParameter("earperson"));
		task.setMiddle(request.getParameter("middle"));
		task.setMidperson(request.getParameter("midperson"));
		task.setLate(request.getParameter("late"));
		task.setLateperson(request.getParameter("lateperson"));
		task.setLeader(request.getParameter("leader"));
		
		taskDao.addTask(task);
		List<Task> taskList = taskDao.getTaskList(intOffSet);
		request.setAttribute("taskList", taskList);
		request.setAttribute("count", taskDao.getCount());
		request.getRequestDispatcher("/pages/task/taskEdits.jsp").forward(request, response);
	}
	/**
	 * 根据条件查询获取员工信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String select = request.getParameter("select");
		String neirong = request.getParameter("neirong");
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		List<Task> taskList = taskDao.selectTask(intOffSet, select, neirong);
		request.setAttribute("taskList", taskList);
		request.setAttribute("count", taskDao.getSelectCount(select, neirong));
		request.getRequestDispatcher("/pages/task/taskEdits.jsp").forward(request, response);
	}
	
	/***
	 * 导出excel
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void excelExport(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("octets/stream");
        response.addHeader("Content-Disposition","attachment;filename=task.xls");
        OutputStream out = null;
		try {
			out = response.getOutputStream();
			ExportExcel<Task> ex = new ExportExcel<Task>();
			String[] headers = {"项目编号", "项目名称", "前期阶段", "前期人员","中期阶段","中期人员","后期阶段","后期人员","项目负责人"};
			List<Task> taskset = new ArrayList<Task>();
			taskset = taskDao.getTaskList(0);
			
			ex.exportExcel(headers, taskset,out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
