package com.offcn.front.controller;

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

import net.sf.json.JSONArray;

@WebServlet(urlPatterns="/xiangqing")
public class xiangqing extends HttpServlet {
	
	/**
	 * 
	 */
	BaseDao dao=new BaseDao();
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String id=request.getParameter("id");
		String sql = "SELECT * FROM u_idle_info where id='"+id+"'";
		 Map<String, Object> map = dao.executeQuery(sql).get(0);
		
			request.setAttribute("map", map);
			
			request.getRequestDispatcher("front/xiangqing.jsp").forward(request, response);
		
		
	}
	
}

