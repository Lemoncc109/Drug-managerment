package com.javaclimb.drug.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.Manager;
import com.javaclimb.drug.entity.User;

import java.util.HashMap;
import java.util.List;

/**
 * 给前端返回的json格式数据
 */
public class ResultMapUtil {

    /**
     * 登录返回结果
     */
    public static HashMap<String,Object> getHashMapLogin(String msg,String code){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg",msg);
        resultMap.put("code",code);
        if("1".equals(code)){
            resultMap.put("icon",1);
        }
        else if("2".equals(code)){
            resultMap.put("icon",1);
        }else if("3".equals(code)){
            resultMap.put("icon",1);
        }else if("4".equals(code)){
            resultMap.put("icon",1);
        }else if("5".equals(code)){
            resultMap.put("icon",1);
        }
        else {
            resultMap.put("icon",5);
        }
        resultMap.put("anim",4);
        return resultMap;
    }
    
    /**
     * 登录返回结果
     */
    public static HashMap<String,Object> getHashMapLogin1(User u,String msg,String code){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("u",u);
        resultMap.put("msg",msg);
        resultMap.put("code",code);
        if("1".equals(code)){
            resultMap.put("icon",1);
        }
        else if("2".equals(code)){
            resultMap.put("icon",1);
        }else {
            resultMap.put("icon",5);
        }
        resultMap.put("anim",4);
        return resultMap;
    }
    public static HashMap<String,Object> getHashMapLogin3(String msg,String code){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg",msg);
        resultMap.put("code",code);
        if("1".equals(code)){
            resultMap.put("icon",1);
        }
        else if("2".equals(code)){
            resultMap.put("icon",1);
        }else {
            resultMap.put("icon",5);
        }
        resultMap.put("anim",4);
        return resultMap;
    }
    /**
     * 分页查询结果
     */
    public static HashMap<String,Object> getHashMapMysqlPage(IPage<?> object){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",object.getTotal());
        resultMap.put("data",object.getRecords());
        return resultMap;
    }

    /**
     * 异常数据统一处理
     */
    public static HashMap<String,Object> getHashMapException(Exception e){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg",e.getMessage());
        return resultMap;
    }

    /**
     * 保存成功的统一返回格式
     */
    public static HashMap<String,Object> getHashMapSave(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","保存失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","保存成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;
    }
//    出库提醒
    public static HashMap<String,Object> getHashMapKC(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","出库失败，库存不足！");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }
        else if (i == 2) {
        	 resultMap.put("msg","出库成功");
             resultMap.put("code",0);
             resultMap.put("icon",1);
             resultMap.put("anim",4);
		}
        else {
            resultMap.put("msg","入库成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;
    }
    /**
     * 删除成功的统一返回格式
     */
    public static HashMap<String,Object> getHashMapDel(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if(i == 0){
            resultMap.put("msg","删除失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","删除成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;
    }

    /**
     * List返回格式
     */
    public static HashMap<String,Object> getHashMapList(List<?> list){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        if(list!=null&&list.size()>0){
            resultMap.put("msg","");
        }else {
            resultMap.put("msg","没有查询到数据！");
        }
        resultMap.put("data",list);
        return resultMap;
    }
}




















