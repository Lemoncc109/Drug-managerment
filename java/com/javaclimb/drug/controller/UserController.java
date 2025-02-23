package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Billinfo;
import com.javaclimb.drug.entity.Druginfo;
import com.javaclimb.drug.entity.Manager;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.entity.User;
import com.javaclimb.drug.service.IDruginfoService;
import com.javaclimb.drug.service.IManagerService;
import com.javaclimb.drug.service.IUserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.websocket.Session;

/**
 * 用户相关的controller
 */
@Controller
public class UserController {
	 @Autowired
	    private IUserService us;
	 @Autowired
	    private IManagerService ms;
    /**
     * 转向登录页面
     */
    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }
    /**
     * 转向用户管理页面
     */
    @RequestMapping(value = "/userinfo")
    public String userinfo(){
        return "/userinfo";
    }
    /**
     * 转向用户订单页面
     */
    @RequestMapping(value = "/userbillinfo")
    public String userbillinfo(){
        return "/userbillinfo";
    }
    /**
     * 判断用户登录是否成功
     */
//    @RequestMapping(value = "/toLogin")
//  public String toDemo(@RequestParam(name = "identity")String identity,Model model,String username,String password,User user,Manager manager,HttpSession session) {
//		try {			
//		    if("管理员".equals(identity)) {
//		    	Manager queryManager = new Manager();
//		    	queryManager.setPassword(password);
//		        //根据用户名查询管理员是否存在
//		    	Manager m=ms.queryUserByMUsername(queryManager);
//			    String b=m.getStatus();
//			if(m!=null&&b.equals("允许")){
//				session.setAttribute("pname", m.getPname());					
//				session.setAttribute("username", m.getUsername());
//				session.setAttribute("identity",m.getIdentity());
//				session.setAttribute("id", m.getId());
//				  model.addAttribute("obj",m);
//				return "/index";
//			}
//		    }
//			else if("普通用户".equals(identity)) {
//				  User queryUser = new User();
//			        queryUser.setPassword(password);
//			        //根据用户名查询用户是否存在
//			        User s = us.queryUserByUsername(queryUser);
//				    String c=s.getStatus();
//				  if(s!=null&&c.equals("允许")){
//					  session.setAttribute("pname", s.getPname());
//						session.setAttribute("username", s.getUsername());
//						session.setAttribute("identity",s.getIdentity());
//						session.setAttribute("id", s.getId());
//						model.addAttribute("obj",s);
//						return "/userindex";
//				}							 
//		    }
//		    model.addAttribute("密码错误", session);
//		    return "/login";
//		}catch(Exception e) {
//			e.printStackTrace();
//			 model.addAttribute("密码错误", session);
//			 return "/login";
//		}
//}
    /**
     * 判断用户登录是否成功
     */
    @RequestMapping(value = "/toLogin")
    @ResponseBody
    public Object toDemo(@RequestParam(name = "identity")String identity,Model model,String username,String password,User user,Manager manager,HttpSession session) {
        if(username==null||password==null){
            return ResultMapUtil.getHashMapLogin("用户名密码不能为空","2");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
        	 if("管理员".equals(identity)) {
        		 Manager queryManager = new Manager();
 		    	queryManager.setUsername(username);
 		    	queryManager.setPassword(password);
 		        //根据用户名查询管理员是否存在
 		    	Manager m=ms.queryUserByMUsername(queryManager);
 			    String b=m.getStatus();
 			if(m!=null&&b.equals("允许")){
 				subject.login(token);
 	            return ResultMapUtil.getHashMapLogin("登录成功","1");
 			}
            }
        	 
        	 else if("普通用户".equals(identity)) {
        		 User queryUser = new User();
				  queryUser.setUsername(username);
			        queryUser.setPassword(password);
			        //根据用户名查询用户是否存在
			        User s = us.queryUserByUsername(queryUser);
				    String c=s.getStatus();
				    String d=s.getIdentity();
				    if(c.equals("允许")&&d.equals("普通用户")) { 
				    	subject.login(token);
				    	return ResultMapUtil.getHashMapLogin("登录成功","2");}
        	 }
        	 else if("医生".equals(identity)) {
        		 User queryUser = new User();
				  queryUser.setUsername(username);
			        queryUser.setPassword(password);
			        //根据用户名查询用户是否存在
			        User s = us.queryUserByUsername(queryUser);
				    String c=s.getStatus();
				    String d=s.getIdentity();
				    if(c.equals("允许")&&d.equals("医生")) { 				    	
				    	subject.login(token);
				    	return ResultMapUtil.getHashMapLogin("登录成功","3");}
        	 }
        	 else if("药剂师".equals(identity)) {
        		 User queryUser = new User();
				  queryUser.setUsername(username);
			        queryUser.setPassword(password);
			        //根据用户名查询用户是否存在
			        User s = us.queryUserByUsername(queryUser);
				    String c=s.getStatus();
				    String d=s.getIdentity();
				    if(c.equals("允许")&&d.equals("药剂师")) {  
				    	subject.login(token);
				    	return ResultMapUtil.getHashMapLogin("登录成功","4");}
        	 }
        	 else if("库存管理员".equals(identity)) {
        		 User queryUser = new User();
				  queryUser.setUsername(username);
			        queryUser.setPassword(password);
			        //根据用户名查询用户是否存在
			        User s = us.queryUserByUsername(queryUser);
				    String c=s.getStatus();
				    String d=s.getIdentity();
				    if(c.equals("允许")&&d.equals("库存管理员")) { 
				    	subject.login(token);
				    	return ResultMapUtil.getHashMapLogin("登录成功","5");}
        	 }
        	 return ResultMapUtil.getHashMapLogin("该账号已被禁止","6");
        }
        catch(Exception e) {
			e.printStackTrace();
			 return ResultMapUtil.getHashMapLogin("账号密码错误","6");
		}
    }
//    /**
//     * 判断用户登录是否成功
//     */
//    @RequestMapping(value = "/toLogin")
//    @ResponseBody
//    public Object toLogin(String username,String password){
//        if(username==null||password==null){
//            return ResultMapUtil.getHashMapLogin("用户名密码不能为空","2");
//        }
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        try{
//            subject.login(token);
//        }catch (UnknownAccountException e){
//            return ResultMapUtil.getHashMapLogin("用户名不存在","2");
//        }catch (IncorrectCredentialsException e){
//            return ResultMapUtil.getHashMapLogin("密码错误","2");
//        }
//        return ResultMapUtil.getHashMapLogin("验证成功","1");
//    }
//    /**
//     * 判断用户登录是否成功
//     */
//    
//    @PostMapping(value = "/toLogin")
//    @ResponseBody
//  public Object toDemo(@RequestParam(name = "identity")String identity,Model model,String username,String password,User user,Manager manager,HttpSession session) {
//		try {			
//		    if("管理员".equals(identity)) {
//		    	Manager queryManager = new Manager();
//		    	queryManager.setUsername(username);
//		    	queryManager.setPassword(password);
//		        //根据用户名查询管理员是否存在
//		    	Manager m=ms.queryUserByMUsername(queryManager);
//			    String b=m.getStatus();
//			if(m!=null&&b.equals("允许")){
//				return ResultMapUtil.getHashMapLogin("登录成功","1");
//			}
//		    }
//			else if("普通用户".equals(identity)) {
//				  User queryUser = new User();
//				  queryUser.setUsername(username);
//			        queryUser.setPassword(password);
//			        //根据用户名查询用户是否存在
//			        User s = us.queryUserByUsername(queryUser);
//				    String c=s.getStatus();
//				  if(s!=null&&c.equals("允许")){
//					return ResultMapUtil.getHashMapLogin("登录成功","2");
//				}							 
//		    }
//		    return ResultMapUtil.getHashMapLogin("该账号已被禁止","5");
//		}catch(Exception e) {
//			e.printStackTrace();
//			 return ResultMapUtil.getHashMapLogin("账号密码错误","5");
//		}
//}
 
    /**
     * 转向管理员后台管理首页
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "/index";
    }
    /**
     * 转向用户管理首页
     */
    @RequestMapping(value = "/userindex")
    public String userindex(){
        return "/userindex";
    }
    /**
     * 转向医生管理首页
     */
    @RequestMapping(value = "/doctorUserindex")
    public String doctorUserindex(){
        return "/doctorUserindex";
    } 
    /**
     * 转向医生管理首页
     */
    @RequestMapping(value = "/doctorPage")
    public String doctorPage(){
        return "/doctorPage";
    } 
    
    /**
     * 转向药剂师管理首页
     */
    @RequestMapping(value = "/drugUserindex")
    public String drugUserindex(){
        return "/drugUserindex";
    } 
    
    /**
     * 转向库存管理员管理首页
     */
    @RequestMapping(value = "/stockUserindex")
    public String stockUserindex(){
        return "/stockUserindex";
    }
    
//    注册账号
    @RequestMapping(value = "/toregister")
    public String toregister(String username,HttpServletRequest request){
        return "/register";
    }
    @RequestMapping(value = "/addregister")
    @ResponseBody
    public Object adregister(String username,String password,User user,HttpSession session){
    	 if(username==null||password==null){
             return ResultMapUtil.getHashMapLogin("用户名密码不能为空","2");
         }
    	 User queryUser = new User();
	     queryUser.setUsername(username);
    	User u = us.queryUserByUsername(queryUser);
    	if(u==null){
            us.addUser(user);
            return ResultMapUtil.getHashMapLogin("注册成功","1");
    	}else {   
    		return ResultMapUtil.getHashMapLogin("注册失败","5");
    		}
    }
 
    /**
     * 分页查询用户列表
     */
    @RequestMapping(value = "/userinfoQueryPage")
    @ResponseBody
    public Object userinfoQueryPage(String param, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
            IPage<User> iPage = us.selectUserPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    
    /**
     * 精确查询用户列表
     */
    @RequestMapping(value = "/userinfoQueryPage1")
    @ResponseBody
    public Object userinfoQueryPage1(String username, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
            IPage<User> iPage = us.selectUserPage1(page,limit,username);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 分页查询管理员列表
     */
    @RequestMapping(value = "/managerinfoQueryPage")
    @ResponseBody
    public Object managerinfoQueryPage(String param, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
        	
            IPage<Manager> iPage = ms.selectManagerPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    
    /**
     * 转向用户编辑页面
     */
    @RequestMapping(value = "/userinfoQueryById")
    public String userinfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        User user = us.queryuserinfoById(id);
        model.addAttribute("obj",user);
        return "/userinfoPage";
    }
    
    /**
     * 转向用户个人中心编辑页面
     */
    @RequestMapping(value = "/userinfoQueryById1")
    public String userinfoQueryById1(@RequestParam(name = "id",required = true)Integer id, Model model){
        User user = us.queryuserinfoById(id);
        model.addAttribute("obj",user);
        return "/userinfoPage2";
    }
    /**
     * 转向管理员个人中心编辑页面
     */
    @RequestMapping(value = "/managerinfoQueryById")
    public String managerinfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Manager manager = ms.querymanagerinfoById(id);
        model.addAttribute("obj",manager);
        return "/managerinfoPage";
    }
    /**
     * 修改一个用户信息
     */
    @RequestMapping(value = "/userinfoEdit")
    @ResponseBody
    public Object userinfoEdit(User user){
        try{
            int i = us.edituserinfo(user);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 修改一个用户信息
     */
    @RequestMapping(value = "/managerinfoEdit")
    @ResponseBody
    public Object managerinfoEdit(Manager manager){
        try{
            int i = ms.editmanagerinfo(manager);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 删除一个用户
     */
    @RequestMapping(value = "/userinfoDelById")
    @ResponseBody
    public Object userinfoDelById(Integer id){
        try{
            int i = us.userinfoDelById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 批量删除用户信息
     */
    @RequestMapping("/batchDeletuserinfo")
    @ResponseBody
    public Object deletePositionByIds(Integer[] ids) {
        try {
        	us.removeByIds(Arrays.asList(ids));  
			 return ResultMapUtil.getHashMapLogin("删除成功","1");
        }
		 catch (Exception e2) {
			 return ResultMapUtil.getHashMapLogin("删除失败","2");
		}
    }
    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout")
    public String logout(){
    	 Subject subject = SecurityUtils.getSubject();
         subject.logout();
        return "redirect:/login";
    }
    /**
     * 获取所有用户
     */
    @RequestMapping(value = "/userinfoList")
    @ResponseBody
    public Object userinfoList(){
        List<User> userinfoList = us.queryUserList();
        return ResultMapUtil.getHashMapList(userinfoList);
    }

    /**
     * 管理员个人中心
     */
  @RequestMapping(value = "/tomanager")
  public String tomanager(String username,HttpServletRequest request){
      return "/tomanager";
  }
    /**
     * 用户个人中心
     */
  @RequestMapping(value = "/touser")
  public String touser(String username,HttpServletRequest request){
      return "/touser";
  }
}
