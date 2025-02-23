package com.javaclimb.drug.service;

import java.util.List;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Manager;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.entity.User;

/**
 * 用户表的service接口
 */
public interface IUserService extends IService<User> {
	/**
	 * 根据用户名查询用户对象
	 *
	 * @param user
	 */
	public User queryUserByUsername(User user);
	/**
	 * 新增用户
	 *
	 * @param user
	 */
	public int addUser(User user);
	/**
	 * 分页查询
	 *
	 * @return
	 */
	public IPage<User> selectUserPage(Integer page, Integer limit, String param);
	/**
	 * 查询所有用户
	 *
	 * @return
	 */
	public List<User> queryUserList();
	/**
	 * 根据主键id删除一个用户
	 *
	 * @param id
	 * @return
	 */
	public int userinfoDelById(Integer id);
	/**
	 * 根据主键id删除一个供应商对象
	 *
	 * @param id
	 * @return
	 */
	/**
	 * 修改一条用户信息
	 *
	 * @param supplier
	 */
	public int edituserinfo(User user);
	
	/**
	 * 根据主键id查询一个用户对象
	 *
	 * @param id
	 * @return
	 */
	public User queryuserinfoById(Integer id);
	
	public IPage<User> selectUserPage1(Integer page, Integer limit, String username);
	
	public User queryUserByUsername1(User queryUser);
	
	public User queryUserByUsername2(String username);


}
