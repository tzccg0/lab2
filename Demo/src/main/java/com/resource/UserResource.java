package com.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.User;
import com.service.UserService;

@Path("user")
public class UserResource {

	@Autowired
	UserService userService;
	
	@GET
	public User getUser(@QueryParam("username")String username, @QueryParam("password")String password) {
		User user = userService.getUser(username, password);
		System.out.println(user.getDescription());
		return user;
	}
	
	@POST
	public boolean addUser(@QueryParam("username")String username, @QueryParam("password")String password, @QueryParam("description")String description) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setDescription(description);
		return userService.addUser(user);
	}
	
	@PUT
	public boolean updateUser(@QueryParam("username")String username, @QueryParam("password")String password, @QueryParam("description")String description) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setDescription(description);
		return userService.updateUser(user);
	}
	
	@DELETE
	public boolean deleteUser(@QueryParam("username")String username, @QueryParam("password")String password) {
		User user = userService.getUser(username, password);
		if (user == null) return false;
		return userService.deleteUser(user.getUid());
	}
	
}
