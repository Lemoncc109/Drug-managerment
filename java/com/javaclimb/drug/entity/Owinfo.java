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
 * 药品出入库
 */
@Data
@TableName(value = "owinfo")
public class Owinfo implements Serializable {
	@TableId(value="id",type= IdType.AUTO)
    private Integer id;

    /*药品名称*/
    private String dname;
    /*申请人名称*/
    private String applier;
    public String getApplier() {
		return applier;
	}

	public void setApplier(String applier) {
		this.applier = applier;
	}

	/*审核状态*/
    private String status;

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/*出库/入库*/
    private String type;

    /*数量*/
    private Integer count;

    /*操作人*/
    private String operator;
    /*操作人*/
    private String supplier;

    public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/*操作时间*/
    private Date createtime;
}
