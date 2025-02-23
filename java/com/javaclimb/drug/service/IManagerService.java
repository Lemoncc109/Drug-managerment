package com.javaclimb.drug.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Manager;
import com.javaclimb.drug.entity.User;

/**
 * 用户表的service接口
 */
public interface IManagerService extends IService<Manager> {
   
//	/**
//	 * 根据用户名查询用户对象
//	 *
//	 * @param Manager
//	 */ 
//	public Manager queryUserByUsername(Manager manager);

	/**
	 * 根据用户名查询用户对象
	 *
	 * @param user
	 */
	public Manager queryUserByMUsername(Manager manager);

	/**
	 * 根据用户名修改对象
	 *
	 * @param user
	 */
	public int editmanagerinfo(Manager manager);

	public Manager querymanagerinfoById(Integer id);

	public IPage<Manager> selectManagerPage(Integer page, Integer limit, String param);

	/**
	 * 查询所有用户
	 *
	 * @return
	 */
	public List<Manager> queryManagerList();

	/**
	 * 根据主键id删除一个供应商对象
	 *
	 * @param id
	 * @return
	 */
	public int managerinfoDelById(Integer id);
}
