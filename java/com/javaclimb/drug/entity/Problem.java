package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题药品
 */
@Data
@TableName(value = "problem")
public class Problem implements Serializable {
	@TableId(value="id",type= IdType.AUTO)
    private Integer id;

    /*药品名称*/
    private String dname;

    /*问题药品数量*/
    private Integer dcount;

    /*药品单价*/
    private Float dprice;

    /*药品价值*/
    private Float total;
    public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	/*问题原因*/
    private String reason;

    /*操作时间*/
    private Date createtime;

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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

	public Integer getDcount() {
		return dcount;
	}

	public void setDcount(Integer dcount) {
		this.dcount = dcount;
	}

	public Float getDprice() {
		return dprice;
	}

	public void setDprice(Float dprice) {
		this.dprice = dprice;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
