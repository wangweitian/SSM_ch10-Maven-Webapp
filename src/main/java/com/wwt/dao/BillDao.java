package com.wwt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwt.entity.SmbmsBill;
import com.wwt.entity.SmbmsProvider;

public interface BillDao {
	/**
	 * ���l����ѯ�����˵�
	 * @return
	 */
	List<SmbmsBill> billList(@Param("productName")String productName,@Param("providerId")Integer providerId,
			@Param("isPayment")Integer isPayment,@Param("start")int start ,@Param("size")int size);
	/**
	 * ��ѯ�����˵�
	 * @param start
	 * @param size
	 * @return
	 */
	int allBill(@Param("productName")String productName,@Param("providerId")Integer providerId,
			@Param("isPayment")Integer isPayment);
	/**
	 * ��������ṩ��
	 * @return
	 */
	List<SmbmsProvider> allProviders();
	/**
	 * ����IDɾ���˵�
	 * @param bId
	 * @return
	 */
	int delBillById(@Param("id")Integer bId);
	/**
	 * ����Id��ѯ��������
	 * @param bId
	 * @return
	 */
	SmbmsBill billInfo(@Param("bid")Integer bId);
	/**
	 * ����
	 * @param bill
	 * @return
	 */
	int updateBill(SmbmsBill bill);
	/**
	 * ������Ʒ
	 * @param bill
	 * @return
	 */
	int addBill(SmbmsBill bill);
	

}
