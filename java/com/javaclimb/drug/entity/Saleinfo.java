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
 * 销售记录
 */
@Data
@TableName(value = "saleinfo")
public class Saleinfo implements Serializable {
   
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

	public String getDnumber() {
		return dnumber;
	}

	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}
	@TableId(value="id",type= IdType.AUTO)
	private Integer id;

    /*药品名称*/
    private String dname;

    /*药品编号*/
    private String dnumber;

    /*数量*/
    private Integer count;

    /*金额*/
    private Float total;

    /*操作人*/
    private String operator;

    /*操作时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatetime;

    /*操作时间转换成年月日*/
    public String getOperatetimeStr(){
        return DateUtil.dateConvert(operatetime);
    }
}
