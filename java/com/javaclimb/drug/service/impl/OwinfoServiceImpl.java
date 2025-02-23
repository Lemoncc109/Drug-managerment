package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Billinfo;
import com.javaclimb.drug.entity.Owinfo;
import com.javaclimb.drug.mapper.OwinfoMapper;
import com.javaclimb.drug.service.IOwinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药品出入库service实现类
 */
@Service
public class OwinfoServiceImpl extends ServiceImpl<OwinfoMapper, Owinfo> implements IOwinfoService {

    @Autowired
    private OwinfoMapper owinfoMapper;

    /**
     * 分页查询药品出入库数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-药品出入库名称
     * @return
     */
    @Override
    public IPage<Owinfo> selectOwinfoPage(Integer page,Integer limit,String param) {
        QueryWrapper<Owinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Owinfo> page1 = new Page<>(page,limit);
        return owinfoMapper.selectPage(page1,queryWrapper);
    }
    /**
     * 分页展示审核信息数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-账单信息名称
     * @return
     */
    @Override
    public IPage<Owinfo> owinfobillQueryPage(Integer page, Integer limit, String status) {
        QueryWrapper<Owinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(status)){
            queryWrapper.eq("status",status);
        }
        Page<Owinfo> page1 = new Page<>(page,limit);
        return owinfoMapper.selectPage(page1,queryWrapper);
    }
    /**
     * 分页展示审核信息数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-账单信息名称
     * @return
     */
    @Override
    public IPage<Owinfo> owinfobillQueryPage2(Integer page, Integer limit, String applier) {
        QueryWrapper<Owinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(applier)){
            queryWrapper.eq("applier",applier);
        }
        Page<Owinfo> page1 = new Page<>(page,limit);
        return owinfoMapper.selectPage(page1,queryWrapper);
    }
    
    /**
     * 新增一条药品出入库信息
     *
     * @param owinfo
     */
    @Override
    public int addOwinfo(Owinfo owinfo) {
        return owinfoMapper.insert(owinfo);
    }

    /**
     * 修改一条药品出入库信息
     *
     * @param owinfo
     */
    @Override
    public int editOwinfo(Owinfo owinfo) {
        return owinfoMapper.updateById(owinfo);
    }

    /**
     * 根据主键id查询一个药品出入库对象
     *
     * @param id
     * @return
     */
    @Override
    public Owinfo queryOwinfoById(Integer id) {
        return owinfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个药品出入库对象
     *
     * @param id
     * @return
     */
    @Override
    public int delOwinfoById(Integer id) {
        return owinfoMapper.deleteById(id);
    }

}
