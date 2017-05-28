package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns = "/imageUpload",
        initParams =
        {
            @WebInitParam(name = "saveDir", value = "D:/FileUpload"),
            @WebInitParam(name = "allowedTypes", value = "jpg,jpeg,gif,png")
        }
)
public class ImageUploadServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String saveDir = getInitParameter("saveDir");
		String fileTypes = getInitParameter("allowedTypes");

		PrintWriter writer = response.getWriter();

		writer.println("saveDir = " + saveDir);
		writer.println("fileTypes = " + fileTypes);
	}
}
