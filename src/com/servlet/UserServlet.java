package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

public class UserServlet extends HttpServlet{

	/**
	 * 用户管理的Servlet
	 */
	private static final long serialVersionUID = -4706951185397703734L;
	   UserDao userDao= new UserDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("methodName");
		if(methodName!=null&&!methodName.equals("")&&methodName.equals("getUser")){
			getUser(request, response);
		}else if(methodName.equals("deleteUser")){
			deleteUser(request,response);
		}else if(methodName.equals("toUpdateUser")){
			toUpdateUser(request,response);
		}else if(methodName.equals("updateUser")){
			updateUser(request,response);
		}else if(methodName.equals("toUpdatePassword")){
			toUpdatePassword(request,response);
		}else if(methodName.equals("updatePassword")){
			updatePassword(request,response);
		}else if(methodName.equals("addUser")){
			addUser(request,response);
		}else if(methodName.equals("getUserEdits")){
			getUserEdits(request,response);
		}else if(methodName.equals("selectUser")){
			selectUser(request,response);
		}
	}
	/**
	 * 查询页面获取用户信息列表
	 */
	public void getUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		List<User> userList = userDao.getUserList(intOffSet);
		request.setAttribute("userList", userList);
		request.setAttribute("count", userDao.getCount());
		request.getRequestDispatcher("/pages/user/userSelect.jsp").forward(request, response);
	}
	/**
	 * 编辑界面获取用户信息列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getUserEdits(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		List<User> userList = userDao.getUserList(intOffSet);
		request.setAttribute("userList", userList);
		request.setAttribute("count", userDao.getCount());
		request.getRequestDispatcher("/pages/user/userEdits.jsp").forward(request, response);
	}
	/**
	 * 删除用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		String username = request.getParameter("username");
		userDao.deleteUser(username);
		List<User> userList = userDao.getUserList(intOffSet);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/pages/user/userEdits.jsp").forward(request, response);
	}
	/**
	 * 根据Id查询信息后跳转到更新信息界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		User user = userDao.queryByUsername(username);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/pages/user/userUpdate.jsp").forward(request, response);
		
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
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		//String id = request.getParameter("id");
		User user = new User();
		//pson.setId(Integer.parseInt("id"));
		
		user.setUsername(request.getParameter("username"));
		System.out.println(user.getUsername());
        
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		if(request.getParameter("jurisdiction").equals("管理员"))
            user.setJurisdiction("0");
		else if(request.getParameter("jurisdiction").equals("普通用户"))
			 user.setJurisdiction("1");
		
		userDao.updateUser(user,user.getUsername());
		
		List<User> userList = userDao.getUserList(intOffSet);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/pages/user/userEdits.jsp").forward(request, response);
	}
	/**
	 * 根据Id查询信息后跳转到更新信息界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdatePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = userDao.queryByUsername(LoginServlet.username);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/pages/useredit/passwordUpdate.jsp").forward(request, response);
		
	}
	/**
	 * 执行修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatePassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setUsername(request.getParameter("username"));
		if (request.getParameter("password0").equals(request.getParameter("password")) && request.getParameter("password1").equals(request.getParameter("password2"))) {
			user.setPassword(request.getParameter("password1"));
		}
		user.setName(request.getParameter("name"));
		user.setJurisdiction(request.getParameter("jurisdiction"));
		System.out.println(user.getName()+user.getUsername());
	    userDao.updateUser(user,user.getUsername());
		
	}
	/**
	 * 添加用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		User user = new User();
		
		user.setUsername(request.getParameter("username"));        
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		
		if(request.getParameter("jurisdiction").equals("管理员"))
            user.setJurisdiction("0");
		else if(request.getParameter("jurisdiction").equals("普通用户"))
			 user.setJurisdiction("1");
		
		userDao.addUser(user);
		
		List<User> userList = userDao.getUserList(intOffSet);
		request.setAttribute("userList", userList);
		request.setAttribute("count", userDao.getCount());
		request.getRequestDispatcher("/pages/user/userEdits.jsp").forward(request, response);
	}
	/**
	 * 根据条件查询获取用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String select = request.getParameter("select");
		String neirong = request.getParameter("neirong");
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		if (select.equals("jurisdiction")&&neirong.equals("管理员")) {
			neirong = "0";
		}else if (select.equals("jurisdiction")&&neirong.equals("普通用户")) {
			neirong = "1";
		}
		
		System.out.println(neirong);
		List<User> userList = userDao.selectUser(intOffSet, select, neirong);
		
		request.setAttribute("userList", userList);
		request.setAttribute("count", userDao.getSelectCount(select, neirong));
		request.getRequestDispatcher("/pages/user/userEdits.jsp").forward(request, response);
	}
	

}
