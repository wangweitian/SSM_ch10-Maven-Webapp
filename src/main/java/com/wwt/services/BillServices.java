package com.wwt.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwt.entity.SmbmsBill;
import com.wwt.entity.SmbmsProvider;

public interface BillServices {
	/**
	 * 按條件查询所有账单
	 * @return
	 */
	List<SmbmsBill> billList(String productName,Integer providerId,
			Integer isPayment,int start ,int size);
	/**
	 * 查询所有账单
	 * @param start
	 * @param size
	 * @return
	 */
	int allBill(String productName,Integer providerId,
			Integer isPayment);

	/**
	 * 获得所有提供者
	 * @return
	 */
	List<SmbmsProvider> allProviders();
	/**
	 * 根据ID删除账单
	 * @param bId
	 * @return
	 */
	int delBillById(Integer bId);
	/**
	 * 根据Id查询订单详情
	 * @param bId
	 * @return
	 */
	SmbmsBill billInfo(@Param("id")Integer bId);
	/**
	 * 更新
	 * @param bill
	 * @return
	 */
	int updateBill(SmbmsBill bill);
	/**
	 * 新增商品
	 * @param bill
	 * @return
	 */
	int addBill(SmbmsBill bill);
}
