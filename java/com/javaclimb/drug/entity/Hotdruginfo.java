package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.javaclimb.drug.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 药品
 */
@TableName(value = "hotdruginfo")
public class Hotdruginfo implements Serializable {
	@TableId(value="id",type= IdType.AUTO)
	private Integer id;
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    /*药品名称*/
    private String dname;
    /*药品图片*/
    private String img;
    public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	/*药品企业*/
    private String supplier;
 
	/*库存*/
    private Integer salenum;
    /*库存*/
    private Integer number;
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Integer getSalenum() {
		return salenum;
	}

	public void setSalenum(Integer salenum) {
		this.salenum = salenum;
	}


}
