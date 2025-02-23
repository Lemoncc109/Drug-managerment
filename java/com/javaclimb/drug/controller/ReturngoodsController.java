package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Billinfo;
import com.javaclimb.drug.entity.Returngoods;
import com.javaclimb.drug.service.IBillinfoService;
import com.javaclimb.drug.service.IReturngoodsService;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 收到退货相关的controller
 */
@Controller
@RequestMapping(value = "/returngoods")
public class ReturngoodsController {

    @Autowired
    private IReturngoodsService returngoodsService;
    @Autowired
    private IBillinfoService billinfoService;

    /**
     * 转向收到退货页面
     */
    @RequestMapping
    public String returngoods(){
        return "/returngoods";
    }

    /**
     * 分页查询收到退货列表
     */
    @RequestMapping(value = "/returngoodsQueryPage")
    @ResponseBody
    public Object returngoodsQueryPage(String param, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
            IPage<Returngoods> iPage = returngoodsService.selectReturngoodsPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 分页查询收到退货列表
     */
    @RequestMapping(value = "/returngoodsQueryPage2")
    @ResponseBody
    public Object returngoodsQueryPage2(String status, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
        	status="待审核";
            IPage<Returngoods> iPage = returngoodsService.selectdrugReturngoodsPage(page,limit,status);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 分页查询用户个人退货信息列表
     */
    @RequestMapping(value = "/returngoodsQueryPage1")
    @ResponseBody
    public Object billinfoQueryPage1(String param,String username, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
        	if(param.isEmpty()) {
        		
            IPage<Returngoods> iPage1 = returngoodsService.selectReturngoodsPage1(page,limit,username);
            return ResultMapUtil.getHashMapMysqlPage(iPage1);
            }
        	 IPage<Returngoods> iPage = returngoodsService.selectReturngoodsPage2(page,limit,param,username);
              return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 转向收到退货新增页面
     */
    @RequestMapping(value = "/returngoodsPage")
    public String returngoodsPage(){
        return "/returngoodsPage";
    }
    /**
     * 转向收到退货新增页面
     */
    @RequestMapping(value = "/userreturn")
    public String userreturn(){
        return "/userreturn";
    }
    /**
     * 查看收到退货页面
     */
    @RequestMapping(value = "/userreturnPage2")
    public String userreturnPage(){
        return "/userreturnPage2";
    }
    /**
     * 转向收到药剂师审核页面
     */
    @RequestMapping(value = "/drugUserreturngoodsPage")
    public String drugUserreturngoodsPage(){
        return "/drugUserreturngoodsPage";
    }
    /**
     * 转向收到退货待审核页面
     */
    @RequestMapping(value = "/durgUserreturngoods")
    public String durgUserreturngoods(){
        return "/durgUserreturngoods";
    }
    /**
     * 用户退货
     */
    @RequestMapping(value = "/returngoodsAdd")
    @ResponseBody
    public Object returngoodsAdd(Returngoods returngoods,Integer id){
        try{
        	returngoods.setOperatetime(new Date());
        	returngoods.setStatus("待审核");
        	 billinfoService.delBillinfoById(id);
             returngoodsService.addReturngoods(returngoods);
             return ResultMapUtil.getHashMapLogin("退货申请成功","1");
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货编辑页面
     */
    @RequestMapping(value = "/returngoodsQueryById")
    public String returngoodsQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Returngoods returngoods = returngoodsService.queryReturngoodsById(id);
        model.addAttribute("obj",returngoods);
        return "/returngoodsPage";
    }
    /**
     * 转向收到退货编辑页面
     */
    @RequestMapping(value = "/returngoodsQueryById1")
    public String returngoodsQueryById1(@RequestParam(name = "id",required = true)Integer id, Model model){
        Returngoods returngoods = returngoodsService.queryReturngoodsById(id);
        model.addAttribute("obj",returngoods);
        return "/drugUserreturngoodsPage";
    }
    /**
     * 转向收到退货编辑页面
     */
    @RequestMapping(value = "/returngoodsQueryById2")
    public String returngoodsQueryById2(@RequestParam(name = "id",required = true)Integer id, Model model){
        Returngoods returngoods = returngoodsService.queryReturngoodsById(id);
        model.addAttribute("obj",returngoods);
        return "/userreturnPage2";
    }

    /**
     * 修改一个收到退货
     */
    @RequestMapping(value = "/returngoodsEdit")
    @ResponseBody
    public Object returngoodsEdit(Returngoods returngoods){
        try{
            int i = returngoodsService.editReturngoods(returngoods);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个收到退货
     */
    @RequestMapping(value = "/returngoodsDelById")
    @ResponseBody
    public Object returngoodsDelById(Integer id){
        try{
            int i = returngoodsService.delReturngoodsById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 批量删除退货药品信息
     */
    @RequestMapping("/batchDeletereturngoods")
    @ResponseBody
    public Object deletePositionByIds(Integer[] ids) {
        try {
        	returngoodsService.removeByIds(Arrays.asList(ids));  
			 return ResultMapUtil.getHashMapLogin("删除成功","1");
        }
		 catch (Exception e2) {
			 return ResultMapUtil.getHashMapLogin("删除失败","2");
		}
    }
}





















