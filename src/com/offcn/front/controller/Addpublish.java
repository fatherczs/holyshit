package com.offcn.front.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.offcn.dao.BaseDao;
import com.offcn.service.IdleService;

@WebServlet(urlPatterns="/Addpublish")
@MultipartConfig
public class Addpublish extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BaseDao dao=new BaseDao();
	IdleService ldle=new IdleService();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String fk_fisher=request.getParameter("id");
		String transfer_price=request.getParameter("transfer_price");
		String presentation=request.getParameter("presentation");
		String month=request.getParameter("month");
		String day=request.getParameter("day");
		String create_date=month+"/"+day+"/";
		String filename = ldle.saveImg(request, response);
		String sql="INSERT INTO u_idle_info(NAME,presentation,transfer_price,create_date,idleimg,fk_fisher) VALUES ('"+name+"','"+presentation+"','"+transfer_price+"','"+create_date+"','"+filename+"','"+fk_fisher+"')";
		int n=new BaseDao().executeUpdate(sql);
		if(n>0)
		{
			request.getRequestDispatcher("front/index.jsp").forward(request, response);
		}
	}
	
}