package com.offcn.front.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.offcn.service.FrontUserlist;

@WebServlet(urlPatterns="/FrontUseServlet")
public class FrontUseServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FrontUserlist list =new FrontUserlist();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = list.updatefrontuser(request, response);
		if(n>0){
			request.getRequestDispatcher("front/index.jsp").forward(request, response);
		}
	}
}
