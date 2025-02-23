package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Billinfo;
import com.javaclimb.drug.entity.Returngoods;
import com.javaclimb.drug.mapper.ReturngoodsMapper;
import com.javaclimb.drug.service.IReturngoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 收到退货service实现类
 */
@Service
public class ReturngoodsServiceImpl extends ServiceImpl<ReturngoodsMapper, Returngoods> implements IReturngoodsService {

    @Autowired
    private ReturngoodsMapper returngoodsMapper;

    /**
     * 分页查询收到退货数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-收到退货名称
     * @return
     */
    @Override
    public IPage<Returngoods> selectReturngoodsPage(Integer page,Integer limit,String param) {
        QueryWrapper<Returngoods> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Returngoods> page1 = new Page<>(page,limit);
        return returngoodsMapper.selectPage(page1,queryWrapper);
    }
    
    /**
     * 分页查询收到退货审核数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-收到退货名称
     * @return
     */
    @Override
    public IPage<Returngoods> selectdrugReturngoodsPage(Integer page,Integer limit,String status) {
        QueryWrapper<Returngoods> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(status)){
            queryWrapper.like("status",status);
        }
        Page<Returngoods> page1 = new Page<>(page,limit);
        return returngoodsMapper.selectPage(page1,queryWrapper);
    }
    
    /**
     * 新增一条收到退货信息
     *
     * @param returngoods
     */
    @Override
    public int addReturngoods(Returngoods returngoods) {
        return returngoodsMapper.insert(returngoods);
    }

    /**
     * 修改一条收到退货信息
     *
     * @param returngoods
     */
    @Override
    public int editReturngoods(Returngoods returngoods) {
        return returngoodsMapper.updateById(returngoods);
    }

    /**
     * 根据主键id查询一个收到退货对象
     *
     * @param id
     * @return
     */
    @Override
    public Returngoods queryReturngoodsById(Integer id) {
        return returngoodsMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个收到退货对象
     *
     * @param id
     * @return
     */
    @Override
    public int delReturngoodsById(Integer id) {
        return returngoodsMapper.deleteById(id);
    }
    /**
     * 分页查询用户的个人退货信息数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-账单信息名称
     * @return
     */
    @Override
    public IPage<Returngoods> selectReturngoodsPage1(Integer page, Integer limit, String username) {
        QueryWrapper<Returngoods> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(username)){
            //根据用户名称精确查询账单
            queryWrapper.eq("username",username);
        }
        Page<Returngoods> page1 = new Page<>(page,limit);
        return returngoodsMapper.selectPage(page1,queryWrapper);
    }
    /**
     * 根据药品名称分页查询退货信息数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-账单信息名称
     * @return
     */
    @Override
    public IPage<Returngoods> selectReturngoodsPage2(Integer page, Integer limit, String param,String username) {
        QueryWrapper<Returngoods> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            //根据药品名称模糊查询
            queryWrapper.like("dname",param).eq("username", username);
        }
        Page<Returngoods> page1 = new Page<>(page,limit);
        return returngoodsMapper.selectPage(page1,queryWrapper);
    }
}
