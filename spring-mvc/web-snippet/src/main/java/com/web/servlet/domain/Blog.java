package com.web.servlet.domain;

public class Blog
{
	private int id;
	private String title;
	private String content;

	public Blog(String title, String con)
	{
		this.title = title;
		this.content = con;
	}
	
	
	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

}
