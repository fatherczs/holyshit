package com.offcn.front.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;
import com.sun.xml.internal.messaging.saaj.util.Base64;

import net.sf.json.JSONArray;

@WebServlet(urlPatterns="/PayXinxi")
public class PayXinxi extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String sql="select * from u_idle_info where id='"+id+"'";
		Map<String, Object> map = new BaseDao().executeQuery(sql).get(0);
		request.getSession().setAttribute("imap",map);
		request.getRequestDispatcher("front/confirm.jsp").forward(request, response);
		
		
	
	}

}
