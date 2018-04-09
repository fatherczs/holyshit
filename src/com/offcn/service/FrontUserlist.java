package com.offcn.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;

public class FrontUserlist {
	
	public int updatefrontuser(HttpServletRequest request, HttpServletResponse response){
	
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String id=request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String phonenum = request.getParameter("phonenum");
		String birthday = request.getParameter("birthday");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		
		String sql = "UPDATE u_idle_user SET u_nickname='"+nickname+"',u_phonenum='"+phonenum+"',u_birthday='"+birthday+"',u_province='"+province+"',u_city='"+city+"',u_district='"+district+"' WHERE u_id='"+id+"'";
		
		int n = new BaseDao().executeUpdate(sql);
		
		return n;
		
	}

}