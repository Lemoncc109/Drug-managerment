package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Druginfo;
import com.javaclimb.drug.mapper.DruginfoMapper;
import com.javaclimb.drug.service.IDruginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药品service实现类
 */
@Service
public class DruginfoServiceImpl extends ServiceImpl<DruginfoMapper, Druginfo> implements IDruginfoService {

    @Autowired
    private DruginfoMapper druginfoMapper;

    /**
     * 分页查询药品数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-药品名称
     * @return
     */
    @Override
    public IPage<Druginfo> selectDruginfoPage(Integer page, Integer limit, String param) {
        QueryWrapper<Druginfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<Druginfo> page1 = new Page<>(page,limit);
        return druginfoMapper.selectPage(page1,queryWrapper);
    }
    /**
     * 分页查询药品数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-药品名称
     * @return
     */
    @Override
    public IPage<Druginfo> selectDruginfoPage1(Integer page, Integer limit, String drugtype) {
        QueryWrapper<Druginfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(drugtype)){
            queryWrapper.like("drugtype",drugtype);
        }
        Page<Druginfo> page1 = new Page<>(page,limit);
        return druginfoMapper.selectPage(page1,queryWrapper);
    }
    
  //销售额排序orderByDesc，orderByAsc
  	@Override
  	public IPage<Druginfo> SelectCourseCollect(int index,int pageSize,String param) {
  		QueryWrapper<Druginfo> wrapper = new QueryWrapper<>();
  		wrapper.orderByDesc("salenum").like("name",param).ge("salenum",500);
  		long count=druginfoMapper.selectCount(wrapper);
          IPage<Druginfo> page = new Page<>(index, pageSize, count);
          return  druginfoMapper.selectPage(page, wrapper);
  	}
  	
  	 //销售额排序orderByDesc，orderByAsc
  	@Override
  	public IPage<Druginfo> SelectCourseCollect1(int index,int pageSize,String param) {
  		QueryWrapper<Druginfo> wrapper = new QueryWrapper<>();
  		wrapper.orderByDesc("salenum").like("name",param);
  		long count=druginfoMapper.selectCount(wrapper);
          IPage<Druginfo> page = new Page<>(index, pageSize, count);
          return  druginfoMapper.selectPage(page, wrapper);
  	}
  	
	 //库存排序orderByDesc，orderByAsc
  	@Override
  	public IPage<Druginfo> SelectDrugStock(int index,int pageSize,String param) {
  		QueryWrapper<Druginfo> wrapper = new QueryWrapper<>();
  		wrapper.orderByAsc("stock").like("name",param);
  		long count=druginfoMapper.selectCount(wrapper);
          IPage<Druginfo> page = new Page<>(index, pageSize, count);
          return  druginfoMapper.selectPage(page, wrapper);
  	}
  	
    /**
     * 新增一条药品信息
     *
     * @param druginfo
     */
    @Override
    public int addDruginfo(Druginfo druginfo) {
        return druginfoMapper.insert(druginfo);
    }

    /**
     * 修改一条药品信息
     *
     * @param druginfo
     */
    @Override
    public int editDruginfo(Druginfo druginfo) {
        return druginfoMapper.updateById(druginfo);
    }
//    /**
//     * 根据药品编号修改一条药品信息
//     *
//     * @param druginfo
//     */
//    @Override
//    public int NumeditDruginfo(Druginfo druginfo,Integer number) {
//    	UpdateWrapper<Druginfo> updateWrapper = new UpdateWrapper<>();
//    	updateWrapper.eq("number",number);
//        return druginfoMapper.update(druginfo,updateWrapper);
//    }

    /**
     * 根据主键id查询一个药品对象
     *
     * @param id
     * @return
     */
    @Override
    public Druginfo queryDruginfoById(Integer id) {
        return druginfoMapper.selectById(id);
    }
    /**
     * 根据主键number查询一个药品对象
     *
     * @param number
     * @return
     */
    @Override
    public Druginfo queryDruginfoByDname(String dname) {
    	 QueryWrapper<Druginfo> queryWrapper = new QueryWrapper<>();
         if(StringUtils.isNotEmpty(dname)){
             queryWrapper.eq("name",dname);
         }
        return druginfoMapper.selectOne(queryWrapper);
    }

    /**
     * 根据主键id删除一个药品对象
     *
     * @param id
     * @return
     */
    @Override
    public int delDruginfoById(Integer id) {
        return druginfoMapper.deleteById(id);
    }

    /**
     * 查询所有药品
     *
     * @return
     */
    @Override
    public List<Druginfo> queryDruginfoList() {
        return druginfoMapper.selectList(null);
    }
}
