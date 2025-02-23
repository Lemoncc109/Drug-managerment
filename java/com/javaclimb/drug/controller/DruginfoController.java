package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Druginfo;
import com.javaclimb.drug.entity.Owinfo;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.service.IDruginfoService;
import com.javaclimb.drug.service.IOwinfoService;

import org.apache.ibatis.mapping.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 药品相关的controller
 */
@Controller
@RequestMapping(value = "/druginfo")
public class DruginfoController {

    @Autowired
    private IDruginfoService druginfoService;
    @Autowired
    private IOwinfoService owinfoService;
    /**
     * 转向药品页面
     */
    @RequestMapping
    public String druginfo(){
        return "/druginfo";
    }
    /**
     * 转向用户普通药品页面
     */
    @RequestMapping(value = "/userdruginfo")
    public String userdruginfo(){
        return "/userdruginfo";
    }
    /**
     * 转向用户热销药品页面
     */
    @RequestMapping(value = "/userhotdruginfo")
    public String userhotdruginfo(){
        return "/userhotdruginfo";
    }
    /**
     * 转向用户急救药品页面
     */
    @RequestMapping(value = "/userhelpdruginfo")
    public String userhelpdruginfo(){
        return "/userhelpdruginfo";
    }
    /**
     * 分页查询药品名称列表
     */
    @RequestMapping(value = "/druginfoQueryPage")
    @ResponseBody
    public Object druginfoQueryPage(String param,String drugtype, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
        	
       	if(param.isEmpty()){
       		IPage<Druginfo> iPage1 = druginfoService.selectDruginfoPage1(page,limit,drugtype);
       	    return ResultMapUtil.getHashMapMysqlPage(iPage1);
        		}
       		IPage<Druginfo> iPage = druginfoService.selectDruginfoPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    
    /**
     * 销售额排序分页查询药品名称列表
     */
    @RequestMapping(value = "/druginfoQueryPage1")
    @ResponseBody
    public Object hotdruginfoQueryPage(String param,@RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
           		IPage<Druginfo> iPage = druginfoService.SelectCourseCollect1(page, limit,param);
                return ResultMapUtil.getHashMapMysqlPage(iPage);
            }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 用户热销药品排序分页列表
     */
    @RequestMapping(value = "/druginfoQueryPage2")
    @ResponseBody
    public Object hotdruginfoQueryPage2(String param,@RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
           		IPage<Druginfo> iPage = druginfoService.SelectCourseCollect(page, limit,param);
                return ResultMapUtil.getHashMapMysqlPage(iPage);
            }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    
    /**
     * 库存排序分页查询热销药品名称列表
     */
    @RequestMapping(value = "/druginfoQueryPage3")
    @ResponseBody
    public Object hotdruginfoQueryPage3(String param,@RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
           		IPage<Druginfo> iPage = druginfoService.SelectDrugStock(page, limit,param);
                return ResultMapUtil.getHashMapMysqlPage(iPage);
            }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 分页查询急救药品名称列表
     */
    @RequestMapping(value = "/helpdruginfoQueryPage")
    @ResponseBody
    public Object helpdruginfoQueryPage(String param,String drugtype, @RequestParam(value = "page", defaultValue = "1")Integer page,@RequestParam(value = "limit",defaultValue = "10")Integer limit){
        try{
        	if(param.isEmpty()){
        		drugtype="急救药";
           		IPage<Druginfo> iPage1 = druginfoService.selectDruginfoPage1(page,limit,drugtype);
           	    return ResultMapUtil.getHashMapMysqlPage(iPage1);
            		}
           		IPage<Druginfo> iPage = druginfoService.selectDruginfoPage(page,limit,param);
                return ResultMapUtil.getHashMapMysqlPage(iPage);
            }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    
    /**
     * 批量删除药品列表
     */
    @RequestMapping("/batchDeletedruginfo")
    @ResponseBody
    public Object deletePositionByIds(Integer[] ids) {
        try {
			druginfoService.removeByIds(Arrays.asList(ids));  
			 return ResultMapUtil.getHashMapLogin("删除成功","1");
        }
		 catch (Exception e2) {
			 return ResultMapUtil.getHashMapLogin("删除失败","2");
		}
    }
    
    /**
     * 转向药品新增页面
     */
    @RequestMapping(value = "/druginfoPage")
    public String druginfoPage(){
        return "/druginfoPage";
    }
    /**
     * 转向急救药品页面
     */
    @RequestMapping(value = "/helpdruginfoPage")
    public String helpdruginfoPage(){
        return "/helpdruginfoPage";
    }
    /**
     * 转向医生查看药品页面
     */
    @RequestMapping(value = "/doctordruginfo")
    public String doctordruginfo(){
        return "/doctordruginfo";
    }
    /**
     * 转向药剂师药方审核页面
     */
    @RequestMapping(value = "/drugUserPage")
    public String drugUserPage(){
        return "/drugUserPage";
    }
    /**
     * 转向药品出入库页面
     */
    @RequestMapping(value = "/owdrug")
    public String owdrug(){
        return "/owdrug";
    }
    /**
     * 转向药品出入库页面
     */
    @RequestMapping(value = "/owdrugPage")
    public String owdrugPage(){
        return "/owdrugPage";
    }
    /**
     * 添加一个药品
     */
    @RequestMapping(value = "/druginfoAdd")
    @ResponseBody
    public Object druginfoAdd(Druginfo druginfo,Owinfo owinfo){
        try{
            int i = druginfoService.addDruginfo(druginfo);
            owinfo.setDname(druginfo.getName());
            owinfo.setOperator("老王");
            owinfo.setCount(druginfo.getStock());
            owinfo.setType("入库");       
            owinfo.setCreatetime(new Date());
            owinfoService.addOwinfo(owinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    
    //图片上传
    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
    	System.out.println("okkkk");
        if (!file.isEmpty()) {
            try {
                // 文件存放服务端的位置
                String rootPath = request.getSession().getServletContext().getRealPath("/");
                File dir = new File(rootPath + File.separator + "img");
                System.out.println("文件不为空");
                // 判断是否有此路径
                if (!dir.exists()) {
                    dir.mkdir();
                    System.out.println("有路径");
                }
                // 通过时间戳命名文件
                long path = System.currentTimeMillis();
                // 写入文件的路径
                File serverFile = new File(dir.getAbsolutePath()+"/" + path );
                // 写文件到服务器
                file.transferTo(serverFile);
                System.out.println("写入路径");
                return "img/" + path;
            } catch (Exception e) {
                return "";
            }
        } else {
            return "";
        }
        
    }

    
    /**
     * 转向药品编辑页面
     */
    @RequestMapping(value = "/druginfoQueryById")
    public String druginfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Druginfo druginfo = druginfoService.queryDruginfoById(id);
        model.addAttribute("obj",druginfo);
        return "/druginfoPage";
    }
    
    /**
     * 转向药品购买页面
     */
    @RequestMapping(value = "/userdruginfoQueryById")
    public String userdruginfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Druginfo druginfo = druginfoService.queryDruginfoById(id);
        model.addAttribute("obj",druginfo);
        return "/billinfoPage";
    }
    
    /**
     * 转向药品购买页面
     */
    @RequestMapping(value = "/owdrugQueryById")
    public String owdrugQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Druginfo druginfo = druginfoService.queryDruginfoById(id);
        model.addAttribute("obj",druginfo);
        return "/owdrugPage";
    }
    
    /**
     * 修改一个药品
     */
    @RequestMapping(value = "/druginfoEdit")
    @ResponseBody
    public Object druginfoEdit(Druginfo druginfo){
        try{
            int i = druginfoService.editDruginfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个药品
     */
    @RequestMapping(value = "/druginfoDelById")
    @ResponseBody
    public Object druginfoDelById(Integer id){
        try{
            int i = druginfoService.delDruginfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有药品
     */
    @RequestMapping(value = "/druginfoList")
    @ResponseBody
    public Object druginfoList(){
        List<Druginfo> druginfoList = druginfoService.queryDruginfoList();
        return ResultMapUtil.getHashMapList(druginfoList);
    }

    /**
     * 转向药品保质期检查页面
     */
    @RequestMapping(value = "/warranty")
    public String warranty(){
        return "/warranty";
    }
    /**
     * 转向药品库存检查页面
     */
    @RequestMapping(value = "/stockinfo")
    public String stockinfo(){
        return "/stockinfo";
    }
    /**
     * 转向急救药品页面
     */
    
    @RequestMapping(value = "/helpdruginfo")
    public String helpdruginfo(){
        return "/helpdruginfo";
    }
  
}





















