package com.wwt.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.wwt.entity.SmbmsRole;
import com.wwt.entity.SmbmsUser;

public interface UserDao {
	
	/**
	 * ���
	 * @param eUser
	 * @return EasybuyUser
	 */
	SmbmsUser login(SmbmsUser eUser);
	/**
	 * ��ҳ��ѯ
	 * @param start
	 * @param size
	 * @return  List< EasybuyUser>
	 */
	List< SmbmsUser> searchList(@Param("userName")String queryname,@Param("userRole")int queryUserRole,@Param("start")int start ,@Param("size")int size);
	/**
	 * ��ѯȫ��
	 * @return
	 */
	List< SmbmsUser>  allUser(@Param("userName")String queryname,@Param("userRole")int queryUserRole);
	/**
	 * ��ѯ���н�ɫ
	 * @return List<SmbmsRole>
	 */
	List<SmbmsRole> allRole();
	/**
	 * �����û�IDɾ���û�
	 * @param uid
	 * @return
	 */
	int  delUser(Integer uid);
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	int addUser(SmbmsUser user);
	/**
	 * ����ID��ѯ�û���Ϣ
	 * @param id
	 * @return
	 */
	SmbmsUser userInfo(@Param("id")Integer  id);
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	int updateUser(SmbmsUser user,Integer id);
	/**\
	 * �޸�����
	 * @param oldPwd
	 * @param newPwd
	 * @param id
	 * @return
	 */
	int changePwd(@Param("oldPwd")String oldPwd,@Param("newPwd")String newPwd);
	/**
	 * ���������ѯ
	 * @param pass
	 * @return
	 */
	SmbmsUser searchByPwd(@Param("userPassword")String pass);
	
 
}
