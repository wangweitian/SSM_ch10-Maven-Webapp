package com.wwt.services.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wwt.dao.UserDao;
import com.wwt.entity.SmbmsRole;
import com.wwt.entity.SmbmsUser;


import com.wwt.services.UserServices;
@Service
public class UserServicesImpl implements UserServices{
	@Autowired
	private UserDao dao;
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	public SmbmsUser login(SmbmsUser eUser) {
		// TODO Auto-generated method stub
		return dao.login(eUser);
	}
	public List<SmbmsUser> searchList(String queryname,int queryUserRole,int start, int size) {
		// TODO Auto-generated method stub
		return dao.searchList(queryname,queryUserRole,start, size);
	}
	public List<SmbmsUser> allUser(String queryname,int queryUserRole) {
		// TODO Auto-generated method stub
		return dao.allUser( queryname, queryUserRole);
	}
	public List<SmbmsRole> allRole() {
		// TODO Auto-generated method stub
		return dao.allRole();
	}
	public int delUser(Integer uid) {
		// TODO Auto-generated method stub
		return dao.delUser(uid);
	}
	public int addUser(SmbmsUser user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}
	public SmbmsUser userInfo(@Param("id") Integer id) {
		// TODO Auto-generated method stub
		return dao.userInfo(id);
	}
	public int updateUser(SmbmsUser user, Integer id) {
		// TODO Auto-generated method stub
		return dao.updateUser(user, id);
	}
	public int changePwd( String oldPwd,
			 String newPwd) {
		// TODO Auto-generated method stub
		return dao.changePwd(oldPwd, newPwd);
	}
	public SmbmsUser searchByPwd(@Param("userPassword") String pass) {
		// TODO Auto-generated method stub
		return dao.searchByPwd(pass);
	}

	
}
