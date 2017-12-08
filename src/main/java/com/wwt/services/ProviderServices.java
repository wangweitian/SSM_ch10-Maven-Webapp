package com.wwt.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.wwt.entity.SmbmsProvider;

public interface ProviderServices {
	/**
	 * 按條件查询所有供应商
	 * @return
	 */
	List<SmbmsProvider> proList(String proCode,String proName,
			int start ,int size);
	/**
	 * 查询所有供应商
	 * @param start
	 * @param size
	 * @return
	 */
	int allProvider(String proCode,String proName);
	/**
	 * 根据ID删除账单
	 * @param bId
	 * @return
	 */
	int delProById(@Param("id")Integer pId);
	/**
	 * 根据Id查询订单详情
	 * @param 
	 * @return
	 */
	SmbmsProvider proInfo(@Param("id")Integer pId);
	/**
	 * 更新
	 * @param 
	 * @return
	 */
	int updatePro(SmbmsProvider provider);

	
}
