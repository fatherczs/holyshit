package com.offcn.front.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;

@WebServlet(urlPatterns="/FrontLogin")
public class FrontLogin extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BaseDao dao=new BaseDao();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//当前登录用户
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String sql = "SELECT * FROM u_idle_user WHERE u_phonenum = '"+username+"' AND u_password = '"+password+"'";
		
		Map<String, Object> map = new BaseDao().executeQuery(sql).get(0);
		if(map!=null){
			request.getSession().setAttribute("ses",map);
			request.getRequestDispatcher("front/index.jsp").forward(request, response);
		}else{
			response.sendRedirect("front/login.jsp");
		}
		
	}
	
}
