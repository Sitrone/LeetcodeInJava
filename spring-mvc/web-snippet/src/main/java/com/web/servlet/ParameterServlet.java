package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paraTest")
public class ParameterServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7272067532729373295L;

	/**
	 * http://localhost:8080/web-snippet/paraTest?key=123
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String value = req.getParameter("key");
		resp.getWriter().append("input key value is:" + value);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.sendError(HttpServletResponse.SC_FORBIDDEN);
	}
}
