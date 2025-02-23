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
 * 账单信息
 */
@TableName(value = "billinfo")
public class Billinfo implements Serializable {
	@TableId(value="id",type= IdType.AUTO)
	private Integer id;
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
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

	/*供应商名称*/
    private String sname;
    /*医生名称*/
    private String doctor;
    public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	/*药品名称*/
    private String dname;
    /*供应商名称*/
    private String drugtype;
    /*用户名称*/
    private String customer;
    /*用户名*/
    private String username;
    /*开药原因*/
    private String reason;
    /*审核状态*/
    private String status;


    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/*数量*/
    private Integer count;
    /*药品价格*/
    private Float price;

    /*总金额*/
    private Float total;

    /*进货时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buytime;

  

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getBuytime() {
		return buytime;
	}

	public void setBuytime(Date buytime) {
		this.buytime = buytime;
	}

	/*操作时间转换成年月日*/
    public String getBuytimeStr(){
        return DateUtil.dateConvert(buytime);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	  public String getDrugtype() {
			return drugtype;
		}

		public void setDrugtype(String drugtype) {
			this.drugtype = drugtype;
		}

		public String getCustomer() {
			return customer;
		}

		public void setCustomer(String customer) {
			this.customer = customer;
		}

}
