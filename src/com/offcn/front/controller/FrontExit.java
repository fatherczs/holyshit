package com.offcn.front.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontExit extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.invalidate();
		try {
			response.sendRedirect("front/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
