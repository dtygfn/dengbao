package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Project;
import com.dao.ProjectDao;
import com.dao.impl.ProjectDaoImpl;;

public class ProjectServlet extends HttpServlet {
	/**
	 *项目管理的Servlet
	 */
	private static final long serialVersionUID = -4704901185397703734L;
	ProjectDao 	proDao = new ProjectDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("methodName");
		if(methodName!=null&&!methodName.equals("")&&methodName.equals("getProject")){
			getProject(request, response);
		}else if(methodName.equals("deleteProject")){
			deleteProject(request,response);
		}else if(methodName.equals("toUpdateProject")){
			toUpdatePro(request,response);
		}else if(methodName.equals("updateProject")){
			updateProject(request,response);
		}else if(methodName.equals("addProject")){
			addProject(request,response);
		}else if(methodName.equals("getProjectEdits")){
			getProjectEdits(request,response);
		}else if(methodName.equals("selectProject")){
			selectProject(request,response);
		}
	}
	/**
	 * 查询页面获取项目信息列表
	 */
	public void getProject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		List<Project> proList = proDao.getProjectList(intOffSet);
		request.setAttribute("proList", proList);
	
		request.setAttribute("count", proDao.getCount());
		request.getRequestDispatcher("/pages/project/projectSelect.jsp").forward(request, response);
	}
	/**
	 * 编辑界面获取项目信息列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getProjectEdits(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		List<Project> proList = proDao.getProjectList(intOffSet);
		request.setAttribute("proList", proList);
		request.setAttribute("count", proDao.getCount());
		request.getRequestDispatcher("/pages/project/projectEdits.jsp").forward(request, response);
	}
	/**
	 * 删除项目信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteProject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		String projectid = request.getParameter("projectid");
		proDao.deleteProject(projectid);
		List<Project> proList = proDao.getProjectList(intOffSet);
		request.setAttribute("proList", proList);
		request.getRequestDispatcher("/pages/project/projectEdits.jsp").forward(request, response);
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
		Project pro = proDao.queryByProjectid(projectid);
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("/pages/project/projectUpdate.jsp").forward(request, response);
		
	}
	/**
	 * 执行修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateProject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		//String id = request.getParameter("id");
		Project pro = new Project();
		//pson.setId(Integer.parseInt("id"));
		
		pro.setProjectid(request.getParameter("projectid"));
		System.out.println(pro.getProjectid());

		pro.setName(request.getParameter("name"));
		pro.setInstitution(request.getParameter("institution"));
		pro.setLevel(request.getParameter("level"));
		pro.setFunds(request.getParameter("funds"));
		pro.setManager(request.getParameter("manager"));
		pro.setPhonenum(request.getParameter("phonenum"));
		
		proDao.updateProject(pro,pro.getProjectid());
		
		List<Project> proList = proDao.getProjectList(intOffSet);
		request.setAttribute("proList", proList);
		request.getRequestDispatcher("/pages/project/projectEdits.jsp").forward(request, response);
	}
	/**
	 * 添加用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addProject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		Project pro = new Project();
		
		pro.setProjectid(request.getParameter("projectid"));
		pro.setName(request.getParameter("name"));
		pro.setInstitution(request.getParameter("institution"));
		pro.setLevel(request.getParameter("level"));
		pro.setFunds(request.getParameter("funds"));
		pro.setManager(request.getParameter("manager"));
		pro.setPhonenum(request.getParameter("phonenum"));
		
		proDao.addProject(pro);
		List<Project> proList = proDao.getProjectList(intOffSet);
		request.setAttribute("proList", proList);
		request.setAttribute("count", proDao.getCount());
		request.getRequestDispatcher("/pages/project/projectEdits.jsp").forward(request, response);
	}
	/**
	 * 根据条件查询获取员工信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectProject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String select = request.getParameter("select");
		String neirong = request.getParameter("neirong");
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		List<Project> proList = proDao.selectProject(intOffSet, select, neirong);
		request.setAttribute("proList", proList);
		request.setAttribute("count", proDao.getSelectCount(select, neirong));
		request.getRequestDispatcher("/pages/project/projectEdits.jsp").forward(request, response);
	}
	

}
