package com.ch.dao;

import java.util.List;

import com.ch.userpo.UserPo;

public interface UserDao {

	public  UserPo login(UserPo up); 
	
	public List<UserPo> getUserInfo();
	
	public UserPo getUserById(int id);
	
	public boolean update(UserPo up);
	
	public boolean delete(UserPo up);
	
	public boolean add(UserPo up);
}
