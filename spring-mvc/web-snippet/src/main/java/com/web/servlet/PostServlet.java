package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.servlet.domain.Blog;

@WebServlet("/create")
public class PostServlet extends HttpServlet
{
	private List<Blog> blogRepository = new ArrayList<>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 720396222104320650L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");

		String title = request.getParameter("title");
		String content = request.getParameter("content");

		Blog blog = new Blog(title, content);
		blogRepository.add(blog);

		PrintWriter writer = response.getWriter();
		writer.append("<html><head><meta charset='utf-8' /><title>天码营博客</title></head><body>");
		writer.append(String.format("<h1>%d. %s</h1>", blog.getId(), blog.getTitle()));
		writer.append(String.format("<p>这是天码营博客的第一篇文章</p>", blog.getContent()));
		writer.append("</body></html>");
	}
}
