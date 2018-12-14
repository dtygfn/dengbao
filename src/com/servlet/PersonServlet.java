package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Person;
import com.dao.PersonDao;
import com.dao.impl.PersonDaoImpl;

public class PersonServlet extends HttpServlet{
	
	private static final long serialVersionUID = -4704901185627703734L;
	
    PersonDao psonDao = new PersonDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("methodName");
		if(methodName!=null&&!methodName.equals("")&&methodName.equals("getPerson")){
			getPerson(request, response);
		}else if(methodName.equals("deletePerson")){
			deletePerson(request,response);
		}else if(methodName.equals("toUpdatePerson")){
			toUpdatePerson(request,response);
		}else if(methodName.equals("updatePerson")){
			updatePerson(request,response);
		}else if(methodName.equals("toUpdateUser")){
			toUpdateUser(request,response);
		}else if(methodName.equals("updateUser")){
			updateUser(request,response);
		}else if(methodName.equals("addPerson")){
			addPerson(request,response);
		}else if(methodName.equals("getPersonEdits")){
			getPersonEdits(request,response);
		}else if(methodName.equals("selectPerson")){
			selectPerson(request,response);
		}
////		else if(methodName.equals("upPerson")){
//			upPerson(request,response);
//		}
	}
	

	/**
	 * 查询页面获取员工信息列表
	 */
	public void getPerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		List<Person> psonList = psonDao.getPersonList(intOffSet);
		request.setAttribute("psonList", psonList);
		request.setAttribute("count", psonDao.getCount());
		request.getRequestDispatcher("/pages/person/personSelect.jsp").forward(request, response);
	}
	/**
	 * 编辑界面获取员工信息列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getPersonEdits(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		List<Person> psonList = psonDao.getPersonList(intOffSet);
		request.setAttribute("psonList", psonList);
		request.setAttribute("count", psonDao.getCount());
		request.getRequestDispatcher("/pages/person/personEdits.jsp").forward(request, response);
	}
	/**
	 * 删除员工信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deletePerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		String workerid= request.getParameter("workerid");
		psonDao.deletePerson(workerid);
		List<Person> psonList = psonDao.getPersonList(intOffSet);
		request.setAttribute("psonList", psonList);
		request.getRequestDispatcher("/pages/person/personEdits.jsp").forward(request, response);
	}
	/**
	 * 根据Id查询信息后跳转到更新信息界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdatePerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String workerid= request.getParameter("workerid");
		Person pson = psonDao.queryByWorkerid(workerid);
		request.setAttribute("pson", pson);
		request.getRequestDispatcher("/pages/person/personUpdate.jsp").forward(request, response);
		
	}
	/**
	 * 执行修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatePerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		Person pson = new Person();
		
		pson.setWorkerid(request.getParameter("workerid"));
		pson.setWorkername(request.getParameter("workername"));
		pson.setAge(Integer.parseInt(request.getParameter("age")));
		pson.setSex(request.getParameter("sex"));
		pson.setTitle(request.getParameter("title"));
		pson.setTeleno(request.getParameter("teleno"));
		pson.setEmail(request.getParameter("email"));
	
		psonDao.updatePerson(pson,pson.getWorkerid());
		List<Person> psonList = psonDao.getPersonList(intOffSet);
		request.setAttribute("psonList", psonList);
		request.getRequestDispatcher("/pages/person/personEdits.jsp").forward(request, response);
	}/**
	 * 根据用户名查询信息后跳转到更新信息界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Person pson = psonDao.queryByWorkerid(LoginServlet.username);
		request.setAttribute("pson", pson);
		request.getRequestDispatcher("/pages/useredit/userUpdate.jsp").forward(request, response);
		
	}
	/**
	 * 执行修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Person pson = new Person();
		
		pson.setWorkerid(request.getParameter("workerid"));
		pson.setWorkername(request.getParameter("workername"));
		pson.setAge(Integer.parseInt(request.getParameter("age")));
		pson.setSex(request.getParameter("sex"));
		pson.setTitle(request.getParameter("title"));
		pson.setTeleno(request.getParameter("teleno"));
		pson.setEmail(request.getParameter("email"));
		psonDao.updatePerson(pson,pson.getWorkerid());
		
	}
	/**
	 * 添加员工信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addPerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		Person pson = new Person();
		
		pson.setWorkerid(request.getParameter("workerid"));
		pson.setWorkername(request.getParameter("workername"));
		pson.setAge(Integer.parseInt(request.getParameter("age")));
		pson.setSex(request.getParameter("sex"));
		pson.setTitle(request.getParameter("title"));
		pson.setTeleno(request.getParameter("teleno"));
		pson.setEmail(request.getParameter("email"));
		
		psonDao.addPerson(pson);
		List<Person> psonList = psonDao.getPersonList(intOffSet);
		request.setAttribute("psonList", psonList);
		request.setAttribute("count", psonDao.getCount());
		request.getRequestDispatcher("/pages/person/personEdits.jsp").forward(request, response);
	}
	/**
	 * 根据条件查询获取员工信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectPerson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String select = request.getParameter("select");
		String neirong = request.getParameter("neirong");
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		List<Person> psonList = psonDao.selectPerson(intOffSet, select, neirong);
		request.setAttribute("psonList", psonList);
		request.setAttribute("count", psonDao.getSelectCount(select, neirong));
		request.getRequestDispatcher("/pages/person/personEdits.jsp").forward(request, response);
	}
	


}
