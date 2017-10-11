package com.ch.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ch.dao.UserDao;
import com.ch.userpo.UserPo;
import com.ch.util.MybatisUtil;

public class UserServiceImpl implements UserService{

	UserDao ud;
	SqlSession session;
	public UserServiceImpl() {
		session=MybatisUtil.getSession();
		ud=session.getMapper(UserDao.class);
	}

	@Override
	public  UserPo login(UserPo up) {
		// TODO Auto-generated method stub
		return ud.login(up);
	}

	@Override
	public List<UserPo> getUserInfo() {
		// TODO Auto-generated method stub
		return ud.getUserInfo();
	}

	@Override
	public UserPo getUserById(int id) {
		// TODO Auto-generated method stub
		return ud.getUserById(id);
	}

	@Override
	public boolean update(UserPo up) {
		boolean ok=ud.update(up);
		session.commit();//提交会话
		return ok;
	}

	@Override
	public boolean delete(UserPo up) {
		boolean ko = ud.delete(up);
		session.commit();
		return ko;
	}

	@Override
	public boolean add(UserPo up) {
		boolean ko = ud.add(up);
		session.commit();
		return ko;
	}

	
}
