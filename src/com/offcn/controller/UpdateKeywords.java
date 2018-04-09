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

import net.sf.json.JSONArray;

@WebServlet(urlPatterns="/UpdateKeywords")
public class UpdateKeywords extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IdleService ide=new IdleService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id= request.getParameter("id");
		String sql="update u_keywords set ";
		int n=new BaseDao().executeUpdate(sql);
		if(n>0)
		{
			String str_query="select * from u_keywords";
			List<Map<String, Object>> list = new BaseDao().executeQuery(str_query);
			String str=JSONArray.fromObject(list).toString();
			response.getWriter().write(str);
		}
	}
	
}