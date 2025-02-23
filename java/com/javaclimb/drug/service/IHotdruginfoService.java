package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Druginfo;
import com.javaclimb.drug.entity.Hotdruginfo;

import java.util.List;

/**
 * 药品的service接口
 */
public interface IHotdruginfoService extends IService<Hotdruginfo> {
    /**
     * 分页查询药品数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-药品名称
     * @return
     */
    public IPage<Hotdruginfo> selectHotdruginfoPage(Integer page, Integer limit, String param);

    /**
     * 新增一条药品信息
     * @param hotdruginfo
     */
    public int addHotdruginfo(Hotdruginfo hotdruginfo);

    /**
     * 修改一条药品信息
     * @param hotdruginfo
     */
    public int editHotdruginfo(Hotdruginfo hotruginfo);

    /**
     * 根据主键id查询一个药品对象
     * @param id
     * @return
     */
    public Hotdruginfo queryHotdruginfoById(Integer id);
    /**
     * 根据药品编号number查询一个药品对象
     * @param number
     * @return
     */
    public Hotdruginfo queryHotdruginfoByNumber(Integer number);
    /**
     * 根据主键id删除一个药品对象
     * @param id
     * @return
     */
    public int delHotdruginfoById(Integer id);
    /**
     * 查询所有药品
     * @return
     */
    public List<Hotdruginfo> queryHotdruginfoList();
    /**
     * 根据要药品名称查询相关药品
     * @return
     */
	public Hotdruginfo queryHotdruginfoByDname(String dname);


}
