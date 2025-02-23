package com.javaclimb.drug.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.entity.Druginfo;
import com.javaclimb.drug.entity.Hotdruginfo;
import com.javaclimb.drug.entity.Supplier;

/**
 * 药品的增删改查Mapper
 */
public interface HotdruginfoMapper extends BaseMapper<Hotdruginfo> {

	Hotdruginfo queryHotdruginfoByDname(String dname);

	Hotdruginfo queryHotdruginfoByNumber(Integer number);

}
