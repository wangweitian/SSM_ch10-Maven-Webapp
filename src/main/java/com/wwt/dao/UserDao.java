package com.wwt.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.wwt.entity.SmbmsRole;
import com.wwt.entity.SmbmsUser;

public interface UserDao {
	
	/**
	 * 登陸
	 * @param eUser
	 * @return EasybuyUser
	 */
	SmbmsUser login(SmbmsUser eUser);
	/**
	 * 分页查询
	 * @param start
	 * @param size
	 * @return  List< EasybuyUser>
	 */
	List< SmbmsUser> searchList(@Param("userName")String queryname,@Param("userRole")int queryUserRole,@Param("start")int start ,@Param("size")int size);
	/**
	 * 查询全部
	 * @return
	 */
	List< SmbmsUser>  allUser(@Param("userName")String queryname,@Param("userRole")int queryUserRole);
	/**
	 * 查询所有角色
	 * @return List<SmbmsRole>
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
	SmbmsUser userInfo(@Param("id")Integer  id);
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
	int changePwd(@Param("oldPwd")String oldPwd,@Param("newPwd")String newPwd);
	/**
	 * 根据密码查询
	 * @param pass
	 * @return
	 */
	SmbmsUser searchByPwd(@Param("userPassword")String pass);
	
 
}
