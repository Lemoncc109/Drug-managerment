package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Druginfo;

import java.util.List;

/**
 * 药品的service接口
 */
public interface IDruginfoService extends IService<Druginfo> {
    /**
     * 分页查询药品数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-药品名称
     * @return
     */
    public IPage<Druginfo> selectDruginfoPage(Integer page, Integer limit, String param);
    /**
	 * 分页查询药品数据
	 *
	 * @param pageNum  第几页
	 * @param pageSize 每页多少条数据
	 * @param drugtype    查询参数-药品类别
	 * @return
	 */
	public IPage<Druginfo> selectDruginfoPage1(Integer page, Integer limit, String drugtype);
	
    /**
     * 新增一条药品信息
     * @param druginfo
     */
    public int addDruginfo(Druginfo druginfo);

    /**
     * 修改一条药品信息
     * @param druginfo
     */
    public int editDruginfo(Druginfo druginfo);

    /**
     * 根据主键id查询一个药品对象
     * @param id
     * @return
     */
    public Druginfo queryDruginfoById(Integer id);
    
//    /**
//     * 根据药品编号number查询一个药品对象
//     * @param number
//     * @return
//     */
//    public Druginfo queryDruginfoByNumber(Integer number);
    /**
     * 根据主键id删除一个药品对象
     * @param id
     * @return
     */
    public int delDruginfoById(Integer id);

    /**
     * 查询所有药品
     * @return
     */
    public List<Druginfo> queryDruginfoList();
    /**
     * 根据要药品名称查询相关药品
     * @return
     */
	public Druginfo queryDruginfoByDname(String dname);
	
	/**
     * 用户界面热销药品排行
     * @return
     */
	public IPage<Druginfo> SelectCourseCollect(int index, int pageSize, String param);
	/**
     * 管理界面销售排行
     * @return
     */
	IPage<Druginfo> SelectCourseCollect1(int index, int pageSize, String param);
	/**
     * 管理界面库存排行
     * @return
     */
	
	IPage<Druginfo> SelectDrugStock(int index, int pageSize, String param);
	
//	/**
//	 * 根据药品编号修改一条药品信息
//	 *
//	 * @param druginfo
//	 */
//	int NumeditDruginfo(Druginfo druginfo, Integer number);

}
	
