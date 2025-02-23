package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Manager;
import com.javaclimb.drug.entity.User;
import com.javaclimb.drug.mapper.ManagerMapper;
import com.javaclimb.drug.mapper.UserMapper;
import com.javaclimb.drug.service.IManagerService;
import com.javaclimb.drug.service.IUserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户service实现类
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    /**
     * 根据用户名查询用户对象
     *
     * @param user
     */
    @Override
    public Manager queryUserByMUsername(Manager manager ) {
        QueryWrapper<Manager> wrapper = new QueryWrapper<>();
        wrapper.eq("password",manager.getPassword()).eq("username",manager.getUsername());
        return managerMapper.selectOne(wrapper);
    }
    /**
     * 修改一条用户信息
     *
     * @param supplier
     */	
    @Override
    public int editmanagerinfo(Manager manager) {
        return managerMapper.updateById(manager);
    }
    
    /**
     * 分页查询用户信息数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-账单信息名称
     * @return
     */
    @Override
    public IPage<Manager> selectManagerPage(Integer page,Integer limit,String param) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            //根据用户名称模糊查询
            queryWrapper.like("pname",param);
        }
        Page<Manager> page1 = new Page<>(page,limit);
        return managerMapper.selectPage(page1,queryWrapper);
    }
    
    /**
     * 根据主键id删除一个供应商对象
     *
     * @param id
     * @return
     */
    @Override
    public int managerinfoDelById(Integer id) {
        return managerMapper.deleteById(id);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<Manager> queryManagerList() {
        return managerMapper.selectList(null);
    }
    /**
     * 根据主键id查询一个用户对象
     *
     * @param id
     * @return
     */
    @Override
    public Manager querymanagerinfoById(Integer id) {
        return managerMapper.selectById(id);
    }
}
