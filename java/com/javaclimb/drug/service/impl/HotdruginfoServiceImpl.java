package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Hotdruginfo;
import com.javaclimb.drug.mapper.HotdruginfoMapper;
import com.javaclimb.drug.service.IHotdruginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药品service实现类
 */
@Service
public class HotdruginfoServiceImpl extends ServiceImpl<HotdruginfoMapper, Hotdruginfo> implements IHotdruginfoService {

    @Autowired
    private HotdruginfoMapper hotdruginfoMapper;

    /**
     * 分页查询药品数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-药品名称
     * @return
     */
    @Override
    public IPage<Hotdruginfo> selectHotdruginfoPage(Integer page, Integer limit, String param) {
        QueryWrapper<Hotdruginfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Hotdruginfo> page1 = new Page<>(page,limit);
        return hotdruginfoMapper.selectPage(page1,queryWrapper);
    }

    /**
     * 新增一条药品信息
     *
     * @param hotdruginfo
     */
    @Override
    public int addHotdruginfo(Hotdruginfo hotdruginfo) {
        return hotdruginfoMapper.insert(hotdruginfo);
    }

    /**
     * 修改一条药品信息
     *
     * @param druginfo
     */
    @Override
    public int editHotdruginfo(Hotdruginfo hotdruginfo) {
        return hotdruginfoMapper.updateById(hotdruginfo);
    }

    /**
     * 根据主键id查询一个药品对象
     *
     * @param id
     * @return
     */
    @Override
    public Hotdruginfo queryHotdruginfoById(Integer id) {
        return hotdruginfoMapper.selectById(id);
    }
    
    @Override
    public Hotdruginfo queryHotdruginfoByNumber(Integer number) {
        return hotdruginfoMapper.queryHotdruginfoByNumber(number);
    }

    /**
     * 根据主键id删除一个药品对象
     *
     * @param id
     * @return
     */
    @Override
    public int delHotdruginfoById(Integer id) {
        return hotdruginfoMapper.deleteById(id);
    }

    /**
     * 查询所有药品
     *
     * @return
     */
    @Override
    public List<Hotdruginfo> queryHotdruginfoList() {
        return hotdruginfoMapper.selectList(null);
    }

	@Override
	public Hotdruginfo queryHotdruginfoByDname(String dname) {
		// TODO Auto-generated method stub
		return hotdruginfoMapper.queryHotdruginfoByDname(dname);
	}
}
