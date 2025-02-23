package com.javaclimb.drug.service;

import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Billinfo;

/**
 * 账单信息的service接口
 */
public interface IBillinfoService extends IService<Billinfo> {
    /**
     * 分页查询账单信息数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-账单信息名称
     * @return
     */
    public IPage<Billinfo> selectBillinfoPage(Integer page, Integer limit, String param);

    /**
     * 新增一条账单信息信息
     * @param billinfo
     */
    public int addBillinfo(Billinfo billinfo);

    /**
     * 修改一条账单信息信息
     * @param billinfo
     */
    public int editBillinfo(Billinfo billinfo);

    /**
     * 根据主键id查询一个账单信息对象
     * @param id
     * @return
     */
    public Billinfo queryBillinfoById(Integer id);

    /**
     * 根据主键id删除一个账单信息对象
     * @param id
     * @return
     */
    public int delBillinfoById(Integer id);

	public IPage<Billinfo> selectBillinfoPage1(Integer page, Integer limit, String username);

	public IPage<Billinfo> selectBillinfoPage2(Integer page, Integer limit, String param, String username);
	
//待审核查询
	public IPage<Billinfo> drugbillinfoQueryPage1(Integer page, Integer limit, String status);
//待审核查询-搜索
	public IPage<Billinfo> drugbillinfoQueryPage2(Integer page, Integer limit, String param, String status);

	/**
	 * 分页查询账单信息数据
	 *
	 * @param pageNum  第几页
	 * @param pageSize 每页多少条数据
	 * @param param    查询参数-账单信息名称
	 * @return
	 */
}
