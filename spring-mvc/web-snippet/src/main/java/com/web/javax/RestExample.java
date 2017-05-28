package com.web.javax;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.web.javax.domain.User;

@Path("/")
public class RestExample
{
	private static final String ROOT_NODE = "root";

	// -----------例子1：返回text ----------
	@GET //这是Restful中的GET方法
    @Path("/text") //路径为/rest/hello/text
    @Produces(MediaType.TEXT_PLAIN) //response的ContentType为text/plain
    public String getHelloWorld() { 
//		因为输出是text/plain，所以返回一个String，经过测试，即使有toString()，也不能是其他类型
        return "Hello, my frist RESTFul Test";
    }

	// -----------例子2：返回Json，JAXBElement<String>格式 ----------
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public JAXBElement<String> getHelloWorldJSON()
	{
		JAXBElement<String> result = new JAXBElement<String>(new QName("", ROOT_NODE), String.class, "Hello,JSR!");
		return result;
	}

	// -----------例子3：URL带参数，返回Json，直接对象格式 ----------
	@GET
	@Path("/json/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getMe(@PathParam("id") String id)
	{
		User user = new User();
		user.setId(id);
		user.setName(id + "-Test");
		user.setEmail(id + "@hello");
		return user;
	}

	// -----------例子4：URL带参数，返回XML格式 ----------
	@GET
	@Path("/xml/user/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public User getUserInXML(@PathParam("id") String id)
	{
		User user = new User();
		user.setId(id);
		user.setName(id + "-TestXML");
		user.setEmail(id + "@XML");
		return user;
	}
}
