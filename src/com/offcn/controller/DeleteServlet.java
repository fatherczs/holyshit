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
import com.offcn.service.DeleteService;
import com.offcn.service.LoginService;

@WebServlet(urlPatterns="/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	DeleteService del = new DeleteService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int n=del.deletetable(request, response);
		if(n>0)
		{
			request.getRequestDispatcher("QueryServlet").forward(request, response);
		}
		
		
	}
	
}