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

@WebServlet(urlPatterns="/updateState")
public class updateState extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IdleService ide=new IdleService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String sql="UPDATE u_idle_user SET u_state=IF(u_state='正常','锁定','正常') WHERE u_id='"+id+"'";
		int n=new BaseDao().executeUpdate(sql);
		
		if(n>0)
		{
		request.getRequestDispatcher("QueryUserServlet").forward(request, response);
		}
		
	}
	
}
