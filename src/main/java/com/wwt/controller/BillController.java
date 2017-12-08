package com.wwt.controller;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwt.entity.SmbmsBill;
import com.wwt.entity.SmbmsUser;
import com.wwt.services.BillServices;


@Controller
public class BillController {
	private static final Object Boolean = null;
	@Autowired
	private BillServices bs;
	private int pageSize = 5;

	/**
	 * 查询
	 * 
	 * @param queryProductName
	 * @param queryProviderId
	 * @param queryIsPayment
	 * @param pageIndex
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "billlist.do")
	public String billList(String queryProductName, Integer queryProviderId,
			Integer queryIsPayment,
			@RequestParam(defaultValue = "1") Integer pageIndex,
			HttpSession session, Map<String, Object> model) {
		int totalCount = bs.allBill(queryProductName, queryProviderId,
				queryIsPayment);
		int totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		model.put("providerList", bs.allProviders());
		model.put("billList", bs.billList(queryProductName, queryProviderId,
				queryIsPayment, pageIndex, pageSize));
		model.put("currentPageNo", pageIndex);// 当前页
		model.put("totalPageCount", totalPageCount);// 总页数
		model.put("totalCount", totalCount);// 总记录数
		model.put("queryProviderId", queryProviderId);
		model.put("queryProductName", queryProductName);
		model.put("queryIsPayment", queryIsPayment);
		return "jsp/billlist";
	}
	/**
	 * 根据ID删除订单
	 * @param billid
	 * @return
	 */
	@RequestMapping(value = "billdel.do")
	public String delBillById(Integer billid) {
		System.err.println(billid);
		int del = bs.delBillById(billid);
		if (del > 0) {
		
			return "redirect:/billlist.do";
		} else {
			return "redirect:billlist";
		}

	}
	@RequestMapping(value="billInfo.do")
	public  String  billInfoById(Integer billid,HttpSession session,Map<String, Object> model) {
		SmbmsBill bill=bs.billInfo(billid);
		model.put("bill", bill);	
		model.put("providerList", bs.allProviders());
		return "jsp/billview";
	}
	@RequestMapping("changeBill")
	public String modifyBill(Integer billid,HttpSession session,Map<String, Object> model) {
		SmbmsBill bill=bs.billInfo(billid);
		model.put("bill", bill);	
		System.out.println(bs.allProviders());
		model.put("providerList", bs.allProviders());
		return "jsp/billmodify";
	}
	@RequestMapping(value="updateBill")
	public String updateBill(SmbmsBill bill,HttpSession session) {
		SmbmsUser	user=(SmbmsUser) session.getAttribute("users");
		bill.setCreatedBy(user.getId());
		bill.setCreationDate(new Timestamp(System.currentTimeMillis()));
		int update=bs.updateBill(bill);
		if (update>0) {
			return "redirect:/billlist.do";
		}
		return "jsp/billmodify";
	}
	@RequestMapping(value="showAdd.do")
	public String showAdd(@ModelAttribute("smbmsBill") SmbmsBill smbmsBill,Map<String, Object> model){
		model.put("providerList", bs.allProviders());
		return "jsp/billadd";
	}
	@RequestMapping(value="addBill")
	public String  addBill(SmbmsBill smbmsBill,HttpSession session) {
		SmbmsUser	user=(SmbmsUser) session.getAttribute("users");
		smbmsBill.setCreatedBy(user.getId());
		smbmsBill.setCreationDate(new Timestamp(System.currentTimeMillis()));
		int add=bs.addBill(smbmsBill);
		
		if(add>0){
			return "redirect:/billlist.do";
		}
		return "redirect:/showAdd.do";
	}

}
