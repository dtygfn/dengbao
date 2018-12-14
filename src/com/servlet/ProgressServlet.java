package com.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Progress;
import com.bean.Task;
import com.dao.PersonDao;
import com.dao.ProgressDao;
import com.dao.TaskDao;
import com.dao.impl.PersonDaoImpl;
import com.dao.impl.ProgressDaoImpl;
import com.dao.impl.TaskDaoImpl;

public class ProgressServlet extends HttpServlet{

	private static final long serialVersionUID = -964909855397703734L;
	ProgressDao  progressDao = new ProgressDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("methodName");
		if(methodName!=null&&!methodName.equals("")&&methodName.equals("getProgress")){
			getProgress(request, response);
		}else if(methodName.equals("deleteProgress")){
			deleteProgress(request,response);
		}else if(methodName.equals("toUpdateProgress")){
			toUpdateProgress(request,response);
		}else if(methodName.equals("updateProgress")){
			updateProgress(request,response);
		}else if (methodName.equals("toUpdatePro")) {
			toUpdatePro(request, response);
		}else if (methodName.equals("updatePro")) {
			updatePro(request,response);
		}else if(methodName.equals("addProgress")){
			addProgress(request,response);
		}else if(methodName.equals("getProgressEdits")){
			getProgressEdits(request,response);
		}else if(methodName.equals("selectProgress")){
			selectProgress(request,response);
		}else if(methodName.equals("excelExport")){
			excelExport(request,response);
		}
	}
	
	/**
	 * 查询页面获取任务分配信息列表
	 */
	public void getProgress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		List<Progress> progressList = null;
        int count = 0;
		PersonDao personDao = new PersonDaoImpl();
		TaskDao taskDao = new TaskDaoImpl();
		if (personDao.queryByWorkerid(LoginServlet.username).getTitle().equals("售前工程师")) {
			progressList = progressDao.getEarProgressList(intOffSet,LoginServlet.username);
			count = taskDao.getEarCount(LoginServlet.username);
		}else if (personDao.queryByWorkerid(LoginServlet.username).getTitle().equals("初级测评师")){
			progressList = progressDao.getMidProgressList(intOffSet,LoginServlet.username);
			count = taskDao.getMidCount(LoginServlet.username);
		}else if (personDao.queryByWorkerid(LoginServlet.username).getTitle().equals("中级测评师")){
			progressList= progressDao.getLateProgressList(intOffSet,LoginServlet.username);
            count = taskDao.getLateCount(LoginServlet.username);
		}
		request.setAttribute("progressList", progressList);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/pages/progress/progressSelect.jsp").forward(request, response);
	}
	/**
	 * 编辑界面获取任务信息列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getProgressEdits(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		
		List<Progress> progressList = progressDao.getProgressList(intOffSet);
		request.setAttribute("progressList", progressList);
		request.setAttribute("count", progressDao.getCount());
		request.getRequestDispatcher("/pages/progress/progressEdits.jsp").forward(request, response);
	}
	/**
	 * 删除任务信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteProgress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		String projectid = request.getParameter("projectid");
		progressDao.deleteProgress(projectid);
		List<Progress> progressList = progressDao.getProgressList(intOffSet);
		request.setAttribute("progressList", progressList);
		request.getRequestDispatcher("/pages/progress/progressEdits.jsp").forward(request, response);
	}
	/**
	 * 根据Id查询信息后跳转到更新信息界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdatePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String projectid = request.getParameter("projectid");
		PersonDao personDao = new PersonDaoImpl();
		Progress progress = null;
		if (personDao.queryByWorkerid(LoginServlet.username).getTitle().equals("售前工程师")) {
			 progress = progressDao.earqueryByProjectid(projectid);
		}else if (personDao.queryByWorkerid(LoginServlet.username).getTitle().equals("初级测评师")){
			 progress = progressDao.midqueryByProjectid(projectid);
		}else if (personDao.queryByWorkerid(LoginServlet.username).getTitle().equals("中级测评师")){
			 progress = progressDao.latequeryByProjectid(projectid);
		}
		request.setAttribute("progress", progress);
		request.getRequestDispatcher("/pages/progress/progUpdate.jsp").forward(request, response);
		
	}
	/**
	 * 执行修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatePro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		Progress progress = new Progress();
		
		progress.setProjectid(request.getParameter("projectid"));
		progress.setName(request.getParameter("name"));
		progress.setEartime(request.getParameter("time"));
		progress.setEarprogress(request.getParameter("progress"));
		progress.setMidtime(request.getParameter("midtime"));
		
		PersonDao personDao = new PersonDaoImpl();
		TaskDao taskDao = new TaskDaoImpl();
		List<Progress> progressList = null;
        int count =0;	
        if (personDao.queryByWorkerid(LoginServlet.username).getTitle().equals("售前工程师")) {
			progressDao.updateEarProgress(progress,progress.getProjectid());
			progressList = progressDao.getEarProgressList(intOffSet,LoginServlet.username);
			count = taskDao.getEarCount(LoginServlet.username);
		}else if (personDao.queryByWorkerid(LoginServlet.username).getTitle().equals("初级测评师")){
			progressDao.updateMidProgress(progress,progress.getProjectid());
			progressList = progressDao.getMidProgressList(intOffSet,LoginServlet.username);
			count = taskDao.getMidCount(LoginServlet.username);
		}else if (personDao.queryByWorkerid(LoginServlet.username).getTitle().equals("中级测评师")){
			progressDao.updateLateProgress(progress,progress.getProjectid());
			progressList = progressDao.getLateProgressList(intOffSet,LoginServlet.username);
			count = taskDao.getLateCount(LoginServlet.username);
		}
		
		request.setAttribute("progressList", progressList);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/pages/progress/progressSelect.jsp").forward(request, response);
	}
	
	/**
	 * 根据Id查询信息后跳转到更新信息界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdateProgress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String projectid = request.getParameter("projectid");
		Progress progress = progressDao.queryByProjectid(projectid);
		request.setAttribute("progress", progress);
		request.getRequestDispatcher("/pages/progress/progressUpdate.jsp").forward(request, response);
		
	}
	/**
	 * 执行修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateProgress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		Progress progress = new Progress();
		
		progress.setProjectid(request.getParameter("projectid"));
		progress.setName(request.getParameter("name"));
		progress.setEartime(request.getParameter("eartime"));
		progress.setEarprogress(request.getParameter("earprogress"));
		progress.setMidtime(request.getParameter("midtime"));
		progress.setMidprogress(request.getParameter("midprogress"));
		progress.setLatetime(request.getParameter("latetime"));
		progress.setLateprogress(request.getParameter("lateprogress"));
		progress.setProgress(request.getParameter("progress"));
		progress.setEndtime(request.getParameter("endtime"));
		progress.setResult(request.getParameter("result"));
		
		progressDao.updateProgress(progress,progress.getProjectid());
		
		List<Progress> progressList = progressDao.getProgressList(intOffSet);
		request.setAttribute("progressList", progressList);
		request.getRequestDispatcher("/pages/progress/progressEdits.jsp").forward(request, response);
	}
	/**
	 * 添加用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addProgress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		Progress progress = new Progress();
		
		progress.setProjectid(request.getParameter("projectid"));
		progress.setName(request.getParameter("name"));
		progress.setEartime(request.getParameter("eartime"));
		progress.setEarprogress(request.getParameter("earprogress"));
		progress.setMidtime(request.getParameter("midtime"));
		progress.setMidprogress(request.getParameter("midprogress"));
		progress.setLatetime(request.getParameter("latetime"));
		progress.setLateprogress(request.getParameter("lateprogress"));
		progress.setProgress(request.getParameter("progress"));
		progress.setEndtime(request.getParameter("endtime"));
		progress.setResult(request.getParameter("result"));
		
		progressDao.addProgress(progress);
		List<Progress> progressList = progressDao.getProgressList(intOffSet);
		request.setAttribute("progressList", progressList);
		request.setAttribute("count", progressDao.getCount());
		request.getRequestDispatcher("/pages/progress/progressEdits.jsp").forward(request, response);
	}
	/**
	 * 根据条件查询获取员工信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectProgress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String select = request.getParameter("select");
		String neirong = request.getParameter("neirong");
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		List<Progress> progressList = progressDao.selectProgress(intOffSet, select, neirong);
		request.setAttribute("progressList", progressList);
		request.setAttribute("count", progressDao.getSelectCount(select, neirong));
		request.getRequestDispatcher("/pages/progress/progressEdits.jsp").forward(request, response);
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
			ExportExcel<Progress> ex = new ExportExcel<Progress>();
			String[] headers = {"项目编号", "项目名称", "前期开始时间", "前期进程","中期开始时间","中期进程","后期开始时间","后期进程","项目最新进程","项目完成时间","测评结果"};
			List<Progress> progressset = new ArrayList<Progress>();
			progressset = progressDao.getProgressList(0);
			
			ex.exportExcel(headers, progressset,out);
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
