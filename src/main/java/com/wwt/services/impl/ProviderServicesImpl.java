package com.wwt.services.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwt.dao.ProviderDao;
import com.wwt.entity.SmbmsProvider;
import com.wwt.services.ProviderServices;
@Service
public class ProviderServicesImpl implements ProviderServices{
	@Autowired
	private ProviderDao dao;
	public List<SmbmsProvider> proList(String proCode, String proName,
			 int start, int size) {
		// TODO Auto-generated method stub
		return dao.proList(proCode, proName, (start-1)*size, size);
	}

	public int allProvider(String proCode, String proName) {
		// TODO Auto-generated method stub
		return dao.allPro(proCode, proName);
	}

	public int delProById(@Param("id") Integer pId) {
		// TODO Auto-generated method stub
		return dao.delProById(pId);
	}

	public SmbmsProvider proInfo(@Param("id") Integer pId) {
		// TODO Auto-generated method stub
		return dao.proInfo(pId);
	}

	public int updatePro(SmbmsProvider provider) {
		// TODO Auto-generated method stub
		return dao.updatePro(provider);
	}

}
