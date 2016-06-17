package com.dao;

import org.apache.ibatis.annotations.Param;

import com.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
}