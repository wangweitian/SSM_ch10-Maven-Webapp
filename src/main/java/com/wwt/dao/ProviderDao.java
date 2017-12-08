package com.wwt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwt.entity.SmbmsBill;
import com.wwt.entity.SmbmsProvider;

public interface ProviderDao {
	/**
	 * ���l����ѯ�����˵�
	 * @return
	 */
	List<SmbmsProvider> proList(@Param("proCode")String proCode,@Param("proName")String proName,
			@Param("start")int start ,@Param("size")int size);
	/**
	 * ��ѯ�����˵�
	 * @param start
	 * @param size
	 * @return
	 */
	int allPro(@Param("proCode")String proCode,@Param("proName")String proName
			);
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
