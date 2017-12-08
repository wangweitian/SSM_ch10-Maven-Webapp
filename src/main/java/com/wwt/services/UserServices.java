package com.wwt.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwt.entity.SmbmsRole;
import com.wwt.entity.SmbmsUser;




public interface UserServices {
	/**
	 * 登录
	 * @param eUser
	 * @return eUser
	 */
	SmbmsUser login(SmbmsUser eUser);
	/**
	 * 分页查询
	 * @param start
	 * @param size
	 * @return
	 */
	List< SmbmsUser> searchList(String queryname,int queryUserRole,int start ,int size);
	/**
	 * 查询全部
	 * @return
	 */
	List< SmbmsUser>  allUser(String queryname,int queryUserRole);
	/**
	 * 查询全部角色
	 * @return
	 */
	List<SmbmsRole> allRole();
	/**
	 * 根据用户ID删除用户
	 * @param uid
	 * @return
	 */
	int  delUser(Integer uid);
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int addUser(SmbmsUser user);
	/**
	 * 根据ID查询用户信息
	 * @param id
	 * @return
	 */
	SmbmsUser userInfo(Integer  id);
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	int updateUser(SmbmsUser user,Integer id);
	/**\
	 * 修改密码
	 * @param oldPwd
	 * @param newPwd
	 * @param id
	 * @return
	 */
	int changePwd(String oldPwd,String newPwd);
	/**
	 * 根据密码查询
	 * @param pass
	 * @return
	 */
	SmbmsUser searchByPwd(String pass);

}
