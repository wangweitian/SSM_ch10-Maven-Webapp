package com.wwt.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



import com.wwt.entity.SmbmsRole;
import com.wwt.entity.SmbmsUser;
import com.wwt.services.UserServices;

@Controller
public class UserController {
	@Autowired
	private UserServices us;
	
	@RequestMapping(value = "login.do")
	public String login(SmbmsUser user, HttpSession session) {
		SmbmsUser userLogin = us.login(user);
		System.out.println(userLogin);
		if (userLogin != null) {
			session.setAttribute("users", userLogin);
			return "jsp/frame";
		}else{
			session.setAttribute("error", "用戶名或密码输入错误");
			return "login";
		}
		
	}
	@RequestMapping(value = "userList.do")
	public ModelAndView listUser(String queryname,String queryUserRole,String page, HttpSession session) {
		int userRole=0;
		if(queryUserRole!=null){
			userRole=Integer.parseInt(queryUserRole);
		}
		// 每页显示的条数
		int pageSize = 4;
		List<SmbmsUser> users = new ArrayList<SmbmsUser>();
		users = this.us.allUser(queryname,userRole);
		// 查到的总用户数
		session.setAttribute("userNum", users.size());
		// 总页数
		int pageTimes;
		if (users.size() % pageSize == 0) {
			pageTimes = users.size() / pageSize;
		} else {
			pageTimes = users.size() / pageSize + 1;
		}
		session.setAttribute("pageTimes", pageTimes);
		// 页面初始的时候page没有值
		if (null == page) {
			page = "1";
		}
		// 每页开始的第几条记录
		int startRow = (Integer.parseInt(page) - 1) * pageSize;
		users = this.us.searchList(queryname,userRole,startRow, pageSize);
		session.setAttribute("currentPage", Integer.parseInt(page));
		session.setAttribute("user", users);
		List<SmbmsRole> roles=us.allRole();
		session.setAttribute("role", roles);
		return new ModelAndView("jsp/userlist");
	}
	/*public String delUser() {
		int id=
		int del=us.delUser(uid);
		return "redirect:listUser";
		
	}*/
	@RequestMapping(value="userAdd.do")
	public String addUser(@ModelAttribute("smbmsUser") SmbmsUser smbmsUser) {
		return "jsp/useradd";
		
	}
	@RequestMapping(value="userSave.do")
	public String addUserSave(SmbmsUser smbmsUser ,HttpSession session) {
		SmbmsUser	user=(SmbmsUser) session.getAttribute("users");
		//smbmsUser.setId((long)111);
		smbmsUser.setCreatedBy(user.getId());
		smbmsUser.setCreationDate(new Timestamp(System.currentTimeMillis()));
		if(us.addUser(smbmsUser)>0){
			return "redirect:listUser";
		}
		return "jsp/useradd";
	}
	@RequestMapping(value="changePwd.do")
	@ResponseBody
	public  String  changePwd(String oldpassword ,Map<Object, Object> map)  {
	//	Map<String,Object> resultMap = new HashMap<String, Object>();  
		SmbmsUser user=us.searchByPwd(oldpassword);
		if(user!=null){
			map.put("result", true);  
		} 
		return "jsp/pwdmodify";
		
		
	}
	@RequestMapping(value="alterPwd.do")
	public  String  alterPwd(String oldpassword ,String newpassword ,HttpSession session) {
		int change=us.changePwd(oldpassword, newpassword);
		if(change>0){
			session.removeAttribute("users");
			return "login";
		}
		return "redirect:/";
		
		
	}
	@RequestMapping(value="lougout.do")
	public  String  lougout(HttpSession session) {
		session.removeAttribute("users");
		return "login";
		
	}
	@RequestMapping(value="userInfo.do")
	public  String userInfo (Integer uid,HttpSession session) {
		SmbmsUser user=us.userInfo(uid);
		session.setAttribute("user", user);
		return "jsp/userview";
	}
/*	@RequestMapping("userInfo.do")
	public  String userSearch(Integer uid,HttpSession session) {
		SmbmsUser user=us.userInfo(uid);
		session.setAttribute("user", user);
		return "usermodify";
	}*/
}