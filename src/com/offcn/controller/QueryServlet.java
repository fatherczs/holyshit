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

@WebServlet(urlPatterns="/QueryServlet")
public class QueryServlet extends HttpServlet {
	
	IdleService ide=new IdleService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Map<String, Object>> list=ide.querytable();
		
		//��list���ϴ���ҳ���н�����ʾ
		
		//����Ҫ��ǰ̨��ʾ�����ݣ�����request����
		request.setAttribute("userlist",list);
		//ת����ǰ̨ҳ��
		request.getRequestDispatcher("module_idle/table.jsp").forward(request, response);
		
	}
	
}
