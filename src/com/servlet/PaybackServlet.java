package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Payback;
import com.dao.PaybackDao;
import com.dao.impl.PaybackDaoImpl;

public class PaybackServlet extends HttpServlet{

	/**
	 * 回款信息servlet
	 */
	private static final long serialVersionUID = -4704901175697703734L;

    PaybackDao payDao = new PaybackDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("methodName");
		if(methodName!=null&&!methodName.equals("")&&methodName.equals("getPayback")){
			getPayback(request, response);
		}else if(methodName.equals("deletePayback")){
			deletePayback(request,response);
		}else if(methodName.equals("toUpdatePayback")){
			toUpdatePayback(request,response);
		}else if(methodName.equals("updatePayback")){
			updatePayback(request,response);
		}else if(methodName.equals("addPayback")){
			addPayback(request,response);
		}else if(methodName.equals("getPaybackEdits")){
			getPaybackEdits(request,response);
		}else if(methodName.equals("selectPayback")){
			selectPayback(request,response);
		}
	}
	/**
	 * 查询页面获取回款信息列表
	 */
	public void getPayback(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		List<Payback> payList = payDao.getPaybackList(intOffSet);
		request.setAttribute("payList", payList);
		request.setAttribute("count", payDao.getCount());
		request.getRequestDispatcher("/pages/payback/paybackSelect.jsp").forward(request, response);
	}
	/**
	 * 编辑界面获取回款信息列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getPaybackEdits(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		List<Payback> payList = payDao.getPaybackList(intOffSet);
		request.setAttribute("payList", payList);
		request.setAttribute("count", payDao.getCount());
		request.getRequestDispatcher("/pages/payback/paybackEdits.jsp").forward(request, response);
	}
	/**
	 * 删除回款信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deletePayback(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		String payid= request.getParameter("payid");
		payDao.deletePayback(payid);
		List<Payback> payList = payDao.getPaybackList(intOffSet);
		request.setAttribute("payList", payList);
		request.getRequestDispatcher("/pages/payback/paybackEdits.jsp").forward(request, response);
	}
	/**
	 * 根据Id查询信息后跳转到更新信息界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdatePayback(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String payid= request.getParameter("payid");
		Payback pay = payDao.queryByPayid(payid);
		request.setAttribute("pay", pay);
		request.getRequestDispatcher("/pages/payback/paybackUpdate.jsp").forward(request, response);
		
	}
	/**
	 * 执行修改
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatePayback(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		
		Payback pay = new Payback();
		
		pay.setPayid(request.getParameter("payid"));
		pay.setName(request.getParameter("name"));
		pay.setMoney(request.getParameter("money"));
		pay.setAmount(request.getParameter("amount"));
		pay.setInvoice(request.getParameter("invoice"));
		pay.setBilldate(request.getParameter("billdate"));
		pay.setOfficer(request.getParameter("officer"));
	
		payDao.updatePayback(pay,pay.getPayid());
		List<Payback> payList = payDao.getPaybackList(intOffSet);
		request.setAttribute("payList", payList);
		request.getRequestDispatcher("/pages/payback/paybackEdits.jsp").forward(request, response);
	}
	/**
	 * 添加回款信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addPayback(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		Payback pay = new Payback();
		
		pay.setPayid(request.getParameter("payid"));
		System.out.println(pay.getPayid());

		pay.setName(request.getParameter("name"));
		pay.setMoney(request.getParameter("money"));
		pay.setAmount(request.getParameter("amount"));
		pay.setInvoice(request.getParameter("invoice"));
		pay.setBilldate(request.getParameter("billdate"));
		pay.setOfficer(request.getParameter("officer"));

		
		payDao.addPayback(pay);
		List<Payback> payList = payDao.getPaybackList(intOffSet);
		request.setAttribute("payList", payList);
		request.setAttribute("count", payDao.getCount());
		request.getRequestDispatcher("/pages/payback/paybackEdits.jsp").forward(request, response);
	}
	/**
	 * 根据条件查询获取员工信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectPayback(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String select = request.getParameter("select");
		String neirong = request.getParameter("neirong");
		String offset = request.getParameter("pager.offset");
		int intOffSet = 0;
		if(offset!=null){
			intOffSet = new Integer(offset).intValue();
		}
		List<Payback> payList = payDao.selectPayback(intOffSet, select, neirong);
		request.setAttribute("payList", payList);
		request.setAttribute("count", payDao.getSelectCount(select, neirong));
		request.getRequestDispatcher("/pages/payback/paybackEdits.jsp").forward(request, response);
	}


}
