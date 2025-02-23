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
 * 收到退货
 */
@Data
@TableName(value = "returngoods")
public class Returngoods implements Serializable {
    
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Date getOperatetime() {
		return operatetime;
	}

	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}
	@TableId(value="id",type= IdType.AUTO)
	private Integer id;

	/*用户账号*/
    private String username;

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	/*药品名称*/
    private String dname;
    public String getDrugtype() {	
		return drugtype;
	}

	public void setDrugtype(String drugtype) {
		this.drugtype = drugtype;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	/*药品类别*/
    private String drugtype;
    /*药品供应商*/
    private String sname;

    /*数量*/
    private Integer count;

    /*退货原因*/
    private String reason;

    /*总金额*/
    private Float total;
    
    /*退货人姓名*/
    private String customer;

    public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	/*操作时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatetime;
    
    /*总金额*/
    private Float price;
    
    public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	/*退货状态*/
    private String status;
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*操作时间转换成年月日*/
    public String getOperatetimeStr(){
        return DateUtil.dateConvert(operatetime);
    }

}
