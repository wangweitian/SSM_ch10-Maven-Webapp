package com.wwt.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwt.entity.SmbmsBill;
import com.wwt.entity.SmbmsProvider;

public interface BillServices {
	/**
	 * ���l����ѯ�����˵�
	 * @return
	 */
	List<SmbmsBill> billList(String productName,Integer providerId,
			Integer isPayment,int start ,int size);
	/**
	 * ��ѯ�����˵�
	 * @param start
	 * @param size
	 * @return
	 */
	int allBill(String productName,Integer providerId,
			Integer isPayment);

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
	int delBillById(Integer bId);
	/**
	 * ����Id��ѯ��������
	 * @param bId
	 * @return
	 */
	SmbmsBill billInfo(@Param("id")Integer bId);
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
