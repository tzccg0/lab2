package com.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.HelloWorldService;

@Path("helloworld")
public class HelloWorldResource {
	
	@Autowired
	HelloWorldService helloWorldService;
	
	@GET
	public String HelloWorld() {
		return helloWorldService.HelloWorld();
	}

}
