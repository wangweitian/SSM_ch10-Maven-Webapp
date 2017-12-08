package com.wwt.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwt.entity.SmbmsRole;
import com.wwt.entity.SmbmsUser;




public interface UserServices {
	/**
	 * ��¼
	 * @param eUser
	 * @return eUser
	 */
	SmbmsUser login(SmbmsUser eUser);
	/**
	 * ��ҳ��ѯ
	 * @param start
	 * @param size
	 * @return
	 */
	List< SmbmsUser> searchList(String queryname,int queryUserRole,int start ,int size);
	/**
	 * ��ѯȫ��
	 * @return
	 */
	List< SmbmsUser>  allUser(String queryname,int queryUserRole);
	/**
	 * ��ѯȫ����ɫ
	 * @return
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
	SmbmsUser userInfo(Integer  id);
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
	int changePwd(String oldPwd,String newPwd);
	/**
	 * ���������ѯ
	 * @param pass
	 * @return
	 */
	SmbmsUser searchByPwd(String pass);

}
