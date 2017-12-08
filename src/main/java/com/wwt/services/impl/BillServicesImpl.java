package com.wwt.services.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwt.dao.BillDao;
import com.wwt.entity.SmbmsBill;
import com.wwt.entity.SmbmsProvider;
import com.wwt.services.BillServices;
@Service
public class BillServicesImpl implements BillServices{
	@Autowired
	private BillDao dao;

	public List<SmbmsBill> billList(String productName, Integer providerId,
			Integer isPayment, int start, int size) {
		// TODO Auto-generated method stub
		return dao.billList(productName, providerId, isPayment, (start-1)*size, size);
	}

	public int allBill(String productName, Integer providerId,
			Integer isPayment) {
		// TODO Auto-generated method stub
		return dao.allBill(productName, providerId, isPayment);
	}

	public List<SmbmsProvider> allProviders() {
		// TODO Auto-generated method stub
		return dao.allProviders();
	}

	public int delBillById(Integer bId) {
		// TODO Auto-generated method stub
		return dao.delBillById(bId);
	}

	public SmbmsBill billInfo(@Param("id") Integer bId) {
		// TODO Auto-generated method stub
		return dao.billInfo(bId);
	}

	public int updateBill(SmbmsBill bill) {
		// TODO Auto-generated method stub
		return dao.updateBill(bill);
	}

	public int addBill(SmbmsBill bill) {
		// TODO Auto-generated method stub
		return dao.addBill(bill);
	}

	


}
