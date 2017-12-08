package com.wwt.controller;
import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwt.entity.SmbmsProvider;
import com.wwt.entity.SmbmsUser;
import com.wwt.services.ProviderServices;

@Controller
public class ProController {
	@Autowired
	private ProviderServices ps;
	private int pageSize=5;

	@RequestMapping(value = "providerlist.do")
	public String proList(String queryProCode,String queryProName,
			 @RequestParam(defaultValue="1")Integer pageIndex, HttpSession session,Map<String, Object> model) {
		model.put("providerList", ps.proList(queryProCode, queryProName, pageIndex, pageSize));
		model.put("currentPageNo", pageIndex);//当前页
		int totalCount=ps.allProvider(queryProCode, queryProName);
		int	totalPageCount= totalCount%pageSize==0?
				totalCount/pageSize:totalCount/pageSize+1;
		model.put("totalPageCount", totalPageCount);//总页数
		model.put("totalCount",totalCount );//总记录数
		model.put("queryProCode",queryProCode );
		model.put("queryProName",queryProName );
		return "jsp/providerlist";
	}
	@RequestMapping(value="proAdd.do")
	public String addPro(@ModelAttribute("smbmsProvider") SmbmsProvider smbmsProvider) {
		return "jsp/provideradd";
		
	}
	@RequestMapping(value="delPro.do")
	public String  delPro(Integer proid) {
		int del=ps.delProById(proid);
		if(del>0){
			return "redirect:/providerlist";
		}
		return "redirect:/providerlist";
	}
	@RequestMapping(value="proInfo.do")
	public String proInfo(Integer proid,HttpSession session){
		SmbmsProvider provider=ps.proInfo(proid);
		session.setAttribute("provider", provider);
		return "jsp/providerview";
	}
	@RequestMapping(value="searchInfo.do")
	public String searchInfo(Integer proid,HttpSession session){
		SmbmsProvider provider=ps.proInfo(proid);
		session.setAttribute("provider", provider);
		return "jsp/providermodify";
	}
	public String updatePro(SmbmsProvider provider,HttpSession session) {
		SmbmsUser	user=(SmbmsUser) session.getAttribute("users");
		provider.setCreatedBy(user.getId());
		provider.setCreationDate(new Timestamp(System.currentTimeMillis()));
		int update=ps.updatePro(provider);
		if(update>0){
			return "redirect:/providerlist";
		}
		return "redirect:/providerlist";
	}

}
