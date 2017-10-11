package com.ch.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.service.UserService;
import com.ch.service.UserServiceImpl;
import com.ch.userpo.UserPo;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    UserService us = new UserServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String method=request.getParameter("method");
		
		 if("add".equals(method)) {
			this.add(request,response);
		} else if ("pupdate".equals(method)) {
			this.pupdate(request, response);
		} else if ("update".equals(method)) {
			this.update(request, response);
		} else if("delete".equals(method)) {
			this.delete(request,response);
		}else {
			this.info(request, response);
		}
		
	}
		

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String UserName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		UserPo up = new UserPo();
		up.setUserName(UserName);
		up.setPassWord(passWord);
		boolean bo = us.add(up);
		if(bo==true) {
			response.sendRedirect("UserServlet");
		}
	}


	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userId = request.getParameter("userId");
		UserPo up= new UserPo();
		up.setUserId(Integer.parseInt(userId));
		boolean bo = us.delete(up);
		if(bo==true) {
			response.sendRedirect("UserServlet");
		}else {
			response.sendRedirect("add.jsp");
		}
	}


	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//傳入要修改的數據
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		UserPo up = new UserPo();
		up.setUserId(Integer.parseInt(userId));
		up.setUserName(userName);
		up.setPassWord(passWord);
		boolean bo = us.update(up);
		if(bo==true) {
			response.sendRedirect("UserServlet");
		}else {
			response.sendRedirect("update.jsp");//如何讓他修改失敗????
		}
	}


	private void pupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		UserPo up = us.getUserById(Integer.parseInt(userId));//使用Integer强转String
		request.setAttribute("up",up);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}


	private void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserPo> list = us.getUserInfo();
		request.setAttribute("userInfo", list);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
