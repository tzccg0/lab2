package com.api;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import com.resource.UserResource;

public class ApplicationAPI extends ResourceConfig {

	public ApplicationAPI() {

// 加载resources

		register(UserResource.class);

		//register(UserResource.class);

// 注册数据转换器

		register(JacksonJsonProvider.class);

// 注册日志

	    register(JspMvcFeature.class);  
	    
	}

}