package com.offcn.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;

public class DeleteService {
	BaseDao dao = new BaseDao();
	
	public int deletetable(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String sql = "DELETE FROM u_idle_info WHERE id = "+id+"";
		
		int n = dao.executeUpdate(sql);
		
		return n;
	}

}
