package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Hotdruginfo;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.service.IHotdruginfoService;

import org.apache.ibatis.mapping.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 药品相关的controller
 */
@Controller
@RequestMapping(value = "/hotdruginfo")
public class HotdruginfoController {

    @Autowired
    private IHotdruginfoService hotdruginfoService;

    /**
     * 热销转向药品页面
     */
    @RequestMapping
    public String Hotdruginfo(){
        return "/hotdruginfo";
    }
    @RequestMapping(value = "/phsaledruginfo")
    public String Phsaledruginfo(){
        return "/phsaledruginfo";
    }
    /**
     * 分页查询药品列表
     */
    @RequestMapping(value = "/hotdruginfoQueryPage")
    @ResponseBody
    public Object HotdruginfoQueryPage(String param, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
            IPage<Hotdruginfo> iPage = hotdruginfoService.selectHotdruginfoPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 批量删除药品列表
     */
    @DeleteMapping("/batchDelete")
    public Object deletePositionByIds(Integer[] ids) {
        try {
			hotdruginfoService.removeByIds(Arrays.asList(ids));  
			 return ResultMapUtil.getHashMapLogin("删除成功","1");
        }
		 catch (Exception e2) {
			// TODO: handle exception 
			 return ResultMapUtil.getHashMapLogin("删除失败","2");
		}
    }
 
    
    /**
     * 转向药品新增页面
     */
    @RequestMapping(value = "/hotdruginfoPage")
    public String HotdruginfoPage(){
        return "/hotdruginfoPage";
    }

    /**
     * 添加一个药品
     */
    @RequestMapping(value = "/hotdruginfoAdd")
    @ResponseBody
    public Object HotdruginfoAdd(Hotdruginfo hotdruginfo){
        try{
            int i = hotdruginfoService.addHotdruginfo(hotdruginfo);
            
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品编辑页面
     */
    @RequestMapping(value = "/hotdruginfoQueryById")
    public String HotdruginfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Hotdruginfo hotdruginfo = hotdruginfoService.queryHotdruginfoById(id);
        model.addAttribute("obj",hotdruginfo);
        return "/hotdruginfoPage";
    }

    /**
     * 修改一个药品
     */
    @RequestMapping(value = "/hotdruginfoEdit")
    @ResponseBody
    public Object HotdruginfoEdit(Hotdruginfo hotdruginfo){
        try{
            int i = hotdruginfoService.editHotdruginfo(hotdruginfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个药品
     */
    @RequestMapping(value = "/hotdruginfoDelById")
    @ResponseBody
    public Object HotdruginfoDelById(Integer id){
        try{
            int i = hotdruginfoService.delHotdruginfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 批量删除热销药品信息
     */
    @RequestMapping("/batchDeletehotdruginfo")
    @ResponseBody
    public Object deletePositionByIds1(Integer[] ids) {
        try {
        	hotdruginfoService.removeByIds(Arrays.asList(ids));  
			 return ResultMapUtil.getHashMapLogin("删除成功","1");
        }
		 catch (Exception e2) {
			 return ResultMapUtil.getHashMapLogin("删除失败","2");
		}
    }
    /**
     * 获取所有药品
     */
    @RequestMapping(value = "/hotdruginfoList")
    @ResponseBody
    public Object HotdruginfoList(){
		List<Hotdruginfo> hotdruginfoList = hotdruginfoService.queryHotdruginfoList();
        return ResultMapUtil.getHashMapList(hotdruginfoList);
    }
}





















