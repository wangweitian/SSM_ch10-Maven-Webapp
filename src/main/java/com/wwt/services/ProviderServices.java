package com.wwt.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.wwt.entity.SmbmsProvider;

public interface ProviderServices {
	/**
	 * ���l����ѯ���й�Ӧ��
	 * @return
	 */
	List<SmbmsProvider> proList(String proCode,String proName,
			int start ,int size);
	/**
	 * ��ѯ���й�Ӧ��
	 * @param start
	 * @param size
	 * @return
	 */
	int allProvider(String proCode,String proName);
	/**
	 * ����IDɾ���˵�
	 * @param bId
	 * @return
	 */
	int delProById(@Param("id")Integer pId);
	/**
	 * ����Id��ѯ��������
	 * @param 
	 * @return
	 */
	SmbmsProvider proInfo(@Param("id")Integer pId);
	/**
	 * ����
	 * @param 
	 * @return
	 */
	int updatePro(SmbmsProvider provider);

	
}
