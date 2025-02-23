package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Billinfo;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.entity.User;
import com.javaclimb.drug.mapper.UserMapper;
import com.javaclimb.drug.service.IUserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 用户service实现类
 */
@Service
public  class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 根据用户名查询用户对象
     *
     * @param user
     */
    @Override
    public User queryUserByUsername(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("password",user.getPassword()).eq("username",user.getUsername());
        return userMapper.selectOne(wrapper);
    }
    
    @Override
    public User queryUserByUsername1(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        return userMapper.selectOne(wrapper);
    }
    
    @Override
    public User queryUserByUsername2(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        return userMapper.selectOne(wrapper);
    }
    
    /**
     * 注册用户
     *
     * @param user
     */
    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
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
    public IPage<User> selectUserPage(Integer page,Integer limit,String param) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            //根据用户名称模糊查询
            queryWrapper.like("pname",param);
        }
        Page<User> page1 = new Page<>(page,limit);
        return userMapper.selectPage(page1,queryWrapper);
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
    public IPage<User> selectUserPage1(Integer page,Integer limit,String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(username)){
            //根据用户名称精确查询
            queryWrapper.eq("username",username);
        }
        Page<User> page1 = new Page<>(page,limit);
        return userMapper.selectPage(page1,queryWrapper);
    }
    
    /**
     * 根据主键id删除一个供应商对象
     *
     * @param id
     * @return
     */
    @Override
    public int userinfoDelById(Integer id) {
        return userMapper.deleteById(id);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> queryUserList() {
        return userMapper.selectList(null);
    }
    /**
     * 根据主键id查询一个用户对象
     *
     * @param id
     * @return
     */
    @Override
    public User queryuserinfoById(Integer id) {
        return userMapper.selectById(id);
    }
    /**
     * 修改一条用户信息
     *
     * @param supplier
     */	
    @Override
    public int edituserinfo(User user) {
        return userMapper.updateById(user);
    }
}
