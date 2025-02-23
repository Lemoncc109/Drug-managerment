package com.javaclimb.drug.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaclimb.drug.entity.User;

/**
 * 用户表的增删改查Mapper
 */
public interface UserMapper extends BaseMapper<User> {

	
}
