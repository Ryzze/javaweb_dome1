package com.haha.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haha.domain.User;
import com.haha.service.UserService;

public class AddUserServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int operatorId=Integer.parseInt(request.getParameter("operatorId"));
		int status=Integer.parseInt(request.getParameter("status"));
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		User u=new User(operatorId, name, password, status);
		UserService service=new UserService();
		boolean flg=service.addUser(u);
		if(flg){
			request.setAttribute("msg", "success");
		}else{
			request.setAttribute("msg", "该用户已存在");
		}
		request.getRequestDispatcher("/add.jsp").forward(request, response);
	}

}
