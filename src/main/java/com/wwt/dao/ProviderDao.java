package com.wwt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwt.entity.SmbmsBill;
import com.wwt.entity.SmbmsProvider;

public interface ProviderDao {
	/**
	 * 按條件查询所有账单
	 * @return
	 */
	List<SmbmsProvider> proList(@Param("proCode")String proCode,@Param("proName")String proName,
			@Param("start")int start ,@Param("size")int size);
	/**
	 * 查询所有账单
	 * @param start
	 * @param size
	 * @return
	 */
	int allPro(@Param("proCode")String proCode,@Param("proName")String proName
			);
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
