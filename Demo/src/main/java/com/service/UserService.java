package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.model.User;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public boolean addUser(User user) {
		if (userMapper.selectByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
			return false;
		}
		userMapper.insert(user);
		return true;
	}
	
	public User getUser(String username, String password) {
		User user = userMapper.selectByUsernameAndPassword(username, password);
		System.out.println(999);
		return user;
	}
	
	public boolean updateUser(User user) {
		if (user == null || user.getUid() == null) {
			return false;
		}
		userMapper.updateByPrimaryKeySelective(user);
		return true;
	}
	
	public boolean deleteUser(Integer uid) {
		if (uid != null && uid > 0) {
			return false;
		}
		userMapper.deleteByPrimaryKey(uid);
		return true;
	}

}
