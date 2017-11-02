package com.test.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.springboot.dao.pojo.User;

@Mapper
public interface UserMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);
    
    List<User> queryList();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}