package com.offcn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;
import com.offcn.service.IdleService;
import com.offcn.service.LoginService;

@WebServlet(urlPatterns="/CountServlet")
public class CountServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IdleService ide=new IdleService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sql="SELECT u_province,COUNT(u_province)AS amount FROM u_idle_user GROUP BY u_province";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		
		request.setAttribute("userlist",list);
		//转发到前台页面
		request.getRequestDispatcher("module_ulist/count.jsp").forward(request, response);
		
	}
	
}