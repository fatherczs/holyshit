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

@WebServlet(urlPatterns="/FuzzyqueryUser")
public class FuzzyqueryUser extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IdleService ide=new IdleService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Map<String, Object>> list=ide.FuzzyqueryUser(request, response);
		
		request.setAttribute("userlist",list);
		//转发到前台页面
		request.getRequestDispatcher("module_ulist/userlist.jsp").forward(request, response);
		
	}
	
}