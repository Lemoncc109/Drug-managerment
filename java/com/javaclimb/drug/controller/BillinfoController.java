package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Billinfo;
import com.javaclimb.drug.entity.Druginfo;
import com.javaclimb.drug.service.IBillinfoService;
import com.javaclimb.drug.service.IDruginfoService;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 账单信息相关的controller
 */
@Controller
@RequestMapping(value = "/billinfo")
public class BillinfoController {

    @Autowired
    private IBillinfoService billinfoService;
    @Autowired
    private IDruginfoService druginfoService;

    /**
     * 转向账单信息页面
     */
    @RequestMapping
    public String billinfo(){
        return "/billinfo";
    }

    /**
     * 分页查询账单信息列表
     */
    @RequestMapping(value = "/billinfoQueryPage")
    @ResponseBody
    public Object billinfoQueryPage(String param, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
            IPage<Billinfo> iPage = billinfoService.selectBillinfoPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 分页查询用户个人账单信息列表
     */
    @RequestMapping(value = "/billinfoQueryPage1")
    @ResponseBody
    public Object billinfoQueryPage1(String param,String username, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
        	if(param.isEmpty()) {
            IPage<Billinfo> iPage1 = billinfoService.selectBillinfoPage1(page,limit,username);
            return ResultMapUtil.getHashMapMysqlPage(iPage1);
            }
        	 IPage<Billinfo> iPage = billinfoService.selectBillinfoPage2(page,limit,param,username);
              return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 分页查询账单信息列表
     */
    @RequestMapping(value = "/billinfoQueryPage2")
    @ResponseBody
    public Object billinfoQueryPage2(String status, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
        	status="待审核";
            IPage<Billinfo> iPage = billinfoService.drugbillinfoQueryPage1(page,limit,status);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
//    /**
//     * 分页查询审核信息列表
//     */
//    @RequestMapping(value = "/drugbillinfoQueryPage")
//    @ResponseBody
//    public Object drugbillinfoQueryPage(String param,String status, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
//        try{
//        	status="待审核";
//        	if(param.isEmpty()) {
//        		System.out.println(status);
//            IPage<Billinfo> iPage1 = billinfoService.drugbillinfoQueryPage1(page,limit,status);
//            return ResultMapUtil.getHashMapMysqlPage(iPage1);
//            }
//        	 IPage<Billinfo> iPage = billinfoService.drugbillinfoQueryPage2(page,limit,param,status);
//        	 System.out.println(status);
//              return ResultMapUtil.getHashMapMysqlPage(iPage);
//        } catch (Exception e){
//            return ResultMapUtil.getHashMapException(e);
//        }
//    }
    /**
     * 转向账单信息新增页面
     */
    @RequestMapping(value = "/billinfoPage")
    public String billinfoPage(){
        return "/billinfoPage";
    }
    
    /**
     * 转向个人账单信息新增页面
     */
    @RequestMapping(value = "/UserbillinfoPage2")
    public String UserbillinfoPage2(){
        return "/UserbillinfoPage2";
    }
    
    /**
     * 转向购买信息页面
     */
    @RequestMapping(value = "/userbillinfoPage")
    public String userbillinfoPage(){
        return "/userbillinfoPage";
    }
    
    /**
     * 转向购买药品页面
     */
    @RequestMapping(value = "/userbillinfoQueryById")
    public String userbillinfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Druginfo druginfo = druginfoService.queryDruginfoById(id);
        model.addAttribute("obj",druginfo);
        return "/userbillinfoPage";
    }
    
    /**
     * 转向查看订单页面
     */
    @RequestMapping(value = "/userbillinfoQueryById2")
    public String userbillinfoQueryById2(@RequestParam(name = "id",required = true)Integer id, Model model){
    	   Billinfo billinfo = billinfoService.queryBillinfoById(id);
        model.addAttribute("obj",billinfo);
        return "/UserbillinfoPage2";
    }
    
    /**
     * 转向药品退货页面
     */
    @RequestMapping(value = "/userreturnQueryById")
    public String userreturnQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
    	   Billinfo billinfo = billinfoService.queryBillinfoById(id);
        model.addAttribute("obj",billinfo);
        return "/userreturnPage";
    }
    
    /**
     * 转向药剂师审核页面
     */
    @RequestMapping(value = "/drugUserbillinfoPage")
    public String drugUserbillinfoPage(@RequestParam(name = "id",required = true)Integer id, Model model){
        return "/drugUserbillinfoPage";
    }
    
    /**
     * 添加一个账单信息
     */
    @RequestMapping(value = "/billinfoAdd")
    @ResponseBody
    public Object billinfoAdd(Billinfo billinfo){
        try{
        	billinfo.setBuytime(new Date());
        	billinfo.setStatus("待审核");
            int i = billinfoService.addBillinfo(billinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 用户购买药品账单信息
     */
    @RequestMapping(value = "/userbillinfoAdd")
    @ResponseBody
    public Object userbillinfoAdd(Billinfo billinfo){
        try{
        	Druginfo druginfo =druginfoService.queryDruginfoByDname(billinfo.getDname());
        	System.out.println(billinfo.getDname());
    	    int n = billinfo.getCount();
        	int num =druginfo.getStock()-n;
        	int salenum = druginfo.getSalenum()+n; 
        	        	if(num>=0){
        		druginfo.setStock(num);
        		druginfo.setSalenum(salenum);
        		druginfoService.editDruginfo(druginfo);
        	 billinfo.setBuytime(new Date());
             billinfoService.editBillinfo(billinfo);
            return ResultMapUtil.getHashMapLogin("付款审核成功","1");
        } 
        		return ResultMapUtil.getHashMapLogin("药品库存不足，审核失败","5");
        	}
        	catch (Exception e){
        		  return ResultMapUtil.getHashMapException(e);
        }
    }
    
  
    /**
     * 转向账单信息编辑页面
     */
    @RequestMapping(value = "/billinfoQueryById")
    public String billinfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Billinfo billinfo = billinfoService.queryBillinfoById(id);
        model.addAttribute("obj",billinfo);
        return "/billinfoPage";
    }
    /**
     * 转向审核账单信息编辑页面
     */
    @RequestMapping(value = "/billinfoQueryById1")
    public String billinfoQueryById1(@RequestParam(name = "id",required = true)Integer id, Model model){
        Billinfo billinfo = billinfoService.queryBillinfoById(id);
        model.addAttribute("obj",billinfo);
        return "/drugUserbillinfoPage";
    }
    /**
     * 修改一个账单信息
     */
    @RequestMapping(value = "/billinfoEdit")
    @ResponseBody
    public Object billinfoEdit(Billinfo billinfo){
        try{
            billinfoService.editBillinfo(billinfo);
            return ResultMapUtil.getHashMapLogin("保存成功","1");
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 修改一个账单信息
     */
    @RequestMapping(value = "/billinfoEdit1")
    @ResponseBody
    public Object billinfoEdit1(Billinfo billinfo){
        try{
        	Druginfo druginfo =druginfoService.queryDruginfoByDname(billinfo.getDname());
    	    int n = billinfo.getCount();
        	int num =druginfo.getStock()-n;
        	int salenum = druginfo.getSalenum()+n; 
        	if(num>=0){
        		druginfo.setStock(num);
        		druginfo.setSalenum(salenum);
        		druginfoService.editDruginfo(druginfo);
        	 billinfo.setBuytime(new Date());
        	 billinfoService.editBillinfo(billinfo);
         	return ResultMapUtil.getHashMapLogin("付款审核成功","1");
        }  
    	return ResultMapUtil.getHashMapLogin("药品库存不足，审核失败","5");
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 删除一个账单信息
     */
    @RequestMapping(value = "/billinfoDelById")
    @ResponseBody
    public Object billinfoDelById(Integer id){
        try{
            int i = billinfoService.delBillinfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    
    /**
     * 批量删除药品销售账单信息
     */
    @RequestMapping("/batchDeletebillinfo")
    @ResponseBody
    public Object deletePositionByIds(Integer[] ids) {
        try {
        	billinfoService.removeByIds(Arrays.asList(ids));  
			 return ResultMapUtil.getHashMapLogin("删除成功","1");
        }
		 catch (Exception e2) {
			 return ResultMapUtil.getHashMapLogin("删除失败","2");
		}
    }

}





















