package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.constants.Constants;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

public class LoginServlet extends HttpServlet {
    public static String username;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2432225902692905068L;
	/**
	 * 
	 */

	UserDao userDao = new UserDaoImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("methodName");
		
		if(methodName!=null&&!methodName.equals("")&&methodName.equals("login")){
			//登录
			login(request, response);
		}else if(methodName.equals("loginOut")){
			//�?��
			loginOut(request,response);
		}
		
	}
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("login");
		String userName = request.getParameter("username");
		username = userName;
		String password = request.getParameter("password");
		request.setAttribute("username",userName);
		User user = userDao.login(userName, password);
		if(user!=null){
			//登录成功后，把用户的信息保存在Session�?
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("MAX_PAGE_COUNT", Constants.MAX_PAGE_COUNT);
			session.setAttribute("MAX_PAGE_INDEX", Constants.MAX_PAGE_INDEX);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			//return "main";
		}else{
			String error_msg = "用户名称或用户密码有误，请重新登录！";
			request.setAttribute("error_msg", error_msg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		return "";
	}
	/**
	 * �?��
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String loginOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//清空session
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return "";
	}

}
