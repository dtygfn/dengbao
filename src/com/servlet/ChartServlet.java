package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PerChart;
import com.bean.ProChart;
import com.dao.PerChartDao;
import com.dao.ProChartDao;
import com.dao.impl.PerChartDaoImpl;
import com.dao.impl.ProChartDaoImpl;

import java.io.IOException;
import java.util.List;


public class ChartServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2432296562692905068L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String methodName = request.getParameter("methodName");
		if(methodName!=null&&!methodName.equals("")&&methodName.equals("getProChart")){
			getProchart(request, response);
		}else if(methodName!=null&&!methodName.equals("")&&methodName.equals("getPerChart")){
			getPerchart(request, response);
		}
    
    }


	private void getProchart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProChartDao proChartDao = new ProChartDaoImpl();
        List<ProChart> proChartList;
        proChartList= proChartDao.query();
		request.setAttribute("proChartList", proChartList);
		request.getRequestDispatcher("/pages/chart/proChart.jsp").forward(request, response);
	}
	
	private void getPerchart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PerChartDao perChartDao = new PerChartDaoImpl();
        List<PerChart> perChartList;
        perChartList= perChartDao.query();
		request.setAttribute("perChartList", perChartList);
		request.getRequestDispatcher("/pages/chart/perChart.jsp").forward(request, response);
	}
	
}