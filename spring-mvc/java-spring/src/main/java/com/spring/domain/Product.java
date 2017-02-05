package com.spring.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable 
{

	private static final long serialVersionUID = 2519593427357947906L; 
	
	private int id;
	private String name;
    private String description;
    private BigDecimal price;
    
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public BigDecimal getPrice()
	{
		return price;
	}
	public void setPrice(BigDecimal bigDecimal)
	{
		this.price = bigDecimal;
	}
    
}
