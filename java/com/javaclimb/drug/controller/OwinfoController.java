package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Druginfo;
import com.javaclimb.drug.entity.Owinfo;
import com.javaclimb.drug.entity.User;
import com.javaclimb.drug.service.IDruginfoService;
import com.javaclimb.drug.service.IOwinfoService;
import com.javaclimb.drug.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * 药品出入库相关的controller
 */
@Controller
@RequestMapping(value = "/owinfo")
public class OwinfoController {

    @Autowired
    private IOwinfoService owinfoService;
    @Autowired
    private IDruginfoService druginfoService;
    @Autowired
    private IUserService userService;
    /**
     * 转向药品出入库页面
     */
    @RequestMapping
    public String owinfo(){
        return "/owinfo";
    }
    

    /**
     * 分页查询药品出入库列表
     */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/owinfoQueryPage")
    @ResponseBody
    public Object owinfoQueryPage(String param,@RequestParam(value = "page",defaultValue = "1")Integer page,
    		@RequestParam(value="limit",defaultValue="10")Integer limit){
        try{
            IPage<Owinfo> iPage = owinfoService.selectOwinfoPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    

    /**
     * 分页查询药品出入库列表
     */
    @RequestMapping(value = "/owinfoQueryPage2")
    @ResponseBody
    public Object owinfoQueryPage2(String status,@RequestParam(value = "page",defaultValue = "1")Integer page,
    		@RequestParam(value="limit",defaultValue="10")Integer limit){
        try{
        	status="待审核";
            IPage<Owinfo> iPage = owinfoService.owinfobillQueryPage(page,limit,status);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    
    /**
     * 药剂师分页查询药品出入库列表
     */
    @RequestMapping(value = "/owinfoQueryPage3")
    @ResponseBody
    public Object owinfoQueryPage3(String applier,String username,@RequestParam(value = "page",defaultValue = "1")Integer page,
    		@RequestParam(value="limit",defaultValue="10")Integer limit){
        try{
        	User user = userService.queryUserByUsername2(username);
        	applier=user.getPname();
            IPage<Owinfo> iPage = owinfoService.owinfobillQueryPage2(page,limit,applier);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    
    /**
     * 转向药品出入库待审核页面
     */
    @RequestMapping(value = "/stockUserPage")
    public String stockUserPage(){
        return "/stockUserPage";
    }
    /**
     * 查看药品出入库审核页面
     */
    @RequestMapping(value = "/drugUserowinfoPage")
    public String drugUserowinfoPage(){
        return "/drugUserowinfoPage";
    }
    
    /**
     * 转向药品出入库审核页面
     */
    @RequestMapping(value = "/stockUserOwinfoPage")
    public String stockUserOwinfoPage(){
        return "/stockUserOwinfoPage";
    }
    /**
     * 转向药品出入库申请页面
     */
    @RequestMapping(value = "/stockEnterPage")
    public String stockEnterPage(){
        return "/stockEnterPage";
    }
    /**
     * 转向药剂师药品出入库待审核页面
     */
    @RequestMapping(value = "/drugUserOutbillPage")
    public String drugUserOutbillPage(){
        return "/drugUserOutbillPage";
    }
    /**
     * 转向药剂师药品出入库待审核页面
     */
    @RequestMapping(value = "/drugUserOutPage")
    public String drugUserOutPage(){
        return "/drugUserOutPage";
    }
    /**
     * 转向药品出入库新增页面
     */
    @RequestMapping(value = "/owinfoPage")
    public String owinfoPage(){
        return "/owinfoPage";
    }
    /**
     * 转向急救药品出入库页面
     */
    @RequestMapping(value = "/owhelpdruginfo")
    public String owhelpdruginfo(){
        return "/owhelpdruginfo";
    }
    /**
     * 添加一个药品出入库
     * @param id 
     */
    @RequestMapping(value = "/owinfoAdd")
    @ResponseBody
    public Object owinfoAdd(Owinfo owinfo,Model model){
        try{
        	Druginfo druginfo =druginfoService.queryDruginfoById(owinfo.getId());
        	int n = owinfo.getCount();
        	if("入库".equals(owinfo.getType())) {
        		int num =n+druginfo.getStock();
            	druginfo.setStock(num);
            	druginfoService.editDruginfo(druginfo);
            	owinfo.setCreatetime(new Date());
            	owinfo.setStatus("入库成功");
            	owinfo.setApplier("王智鑫");
                int i = owinfoService.addOwinfo(owinfo);
                return ResultMapUtil.getHashMapKC(i);
        	}
        	else{
        		int num =druginfo.getStock()-n;
            	if(num>=0){
            		druginfo.setStock(num);
            		druginfoService.editDruginfo(druginfo);
            		owinfo.setCreatetime(new Date());
            		owinfo.setStatus("出库成功");
            		owinfo.setApplier("王智鑫");
                    int i = owinfoService.addOwinfo(owinfo)+1;
                    return ResultMapUtil.getHashMapKC(i);
            	}
            	else {
                    return ResultMapUtil.getHashMapKC(0);
				}
        	}
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 申请药品出入库
     * @param id 
     */
    @RequestMapping(value = "/owinfoAdd2")
    @ResponseBody
    public Object owinfoAdd2(Owinfo owinfo,Model model){
        try{
            		owinfo.setCreatetime(new Date());
            		owinfo.setStatus("待审核");
                    int i = owinfoService.addOwinfo(owinfo);
                    return ResultMapUtil.getHashMapKC(i);
            	}
         catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
            }
    }
    /**
     * 转向药品出入库编辑页面
     */
    @RequestMapping(value = "/owinfoQueryById")
    public String owinfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Owinfo owinfo = owinfoService.queryOwinfoById(id);
        model.addAttribute("obj",owinfo);
        return "/owinfoPage";
    }
    
    /**
     * 转向药品出入库审核编辑页面
     */
    @RequestMapping(value = "/owinfoQueryById1")
    public String owinfoQueryById1(@RequestParam(name = "id",required = true)Integer id, Model model){
        Owinfo owinfo = owinfoService.queryOwinfoById(id);
        model.addAttribute("obj",owinfo);
        return "/stockUserOwinfoPage";
    }
    
    /**
     * 转向药品出入库审核查看页面
     */
    @RequestMapping(value = "/owinfoQueryById2")
    public String owinfoQueryById2(@RequestParam(name = "id",required = true)Integer id, Model model){
        Owinfo owinfo = owinfoService.queryOwinfoById(id);
        model.addAttribute("obj",owinfo);
        return "/drugUserowinfoPage";
    }
    

    /**
     * 修改一个药品出入库
     */
    @RequestMapping(value = "/owinfoEdit")
    @ResponseBody
    public Object owinfoEdit(Owinfo owinfo){
        try{
        	
            int i = owinfoService.editOwinfo(owinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    
    /**
     * 审核一个药品出入库
     */
    @RequestMapping(value = "/owinfoEdit2")
    @ResponseBody
    public Object owinfoEdit2(Owinfo owinfo){
        try{
        	Druginfo druginfo =druginfoService.queryDruginfoByDname(owinfo.getDname());
        	int n = owinfo.getCount();
        	if("入库".equals(owinfo.getType())) {
        		int num =n+druginfo.getStock();
            	druginfo.setStock(num);
            	druginfoService.editDruginfo(druginfo);
                owinfoService.editOwinfo(owinfo);
                return ResultMapUtil.getHashMapLogin("入库审核成功","1");
        	}
        	else{
        		int num =druginfo.getStock()-n;
            	if(num>=0){
            		druginfo.setStock(num);
            		druginfoService.editDruginfo(druginfo);
                    owinfoService.editOwinfo(owinfo);
                    return ResultMapUtil.getHashMapLogin("出库审核成功","1");
            	}
            	else {
                    return ResultMapUtil.getHashMapKC(0);
				}
        	}
        }
        		catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
   
    /**
     * 删除一个药品出入库
     */
    @RequestMapping(value = "/owinfoDelById")
    @ResponseBody
    public Object owinfoDelById(Integer id){
        try{
            int i = owinfoService.delOwinfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    
    /**
     * 批量删除出入库信息
     */
    @RequestMapping("/batchDeleteowinfo")
    @ResponseBody
    public Object deletePositionByIds(Integer[] ids) {
        try {
        	owinfoService.removeByIds(Arrays.asList(ids));  
			 return ResultMapUtil.getHashMapLogin("删除成功","1");
        }
		 catch (Exception e2) {
			 return ResultMapUtil.getHashMapLogin("删除失败","2");
		}
    }
}





















