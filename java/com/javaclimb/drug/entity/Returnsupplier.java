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
 * 退货给供应商
 */
@Data
@TableName(value = "returnsupplier")
public class Returnsupplier implements Serializable {
    
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

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}


	public Date getProducttime() {
		return producttime;
	}

	public void setProducttime(Date producttime) {
		this.producttime = producttime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@TableId(value="id",type= IdType.AUTO)
	private Integer id;

    /*药品名称*/
    private String dname;

    /*数量*/
    private Integer dcount;
    
    /*药品单价*/
    private Float dprice;
    
    /*药品总价值*/
    private Float total;

    /*供应商名称*/
    private String sname;

    public Float getDprice() {
		return dprice;
	}

	public void setDprice(Float dprice) {
		this.dprice = dprice;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
	/*进货时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date producttime;

    /*退货原因*/
    private String reason;

    /*退货时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    /*进货时间转换成年月日*/
    public String getBuytimeStr(){
        return DateUtil.dateConvert(producttime);
    }

    /*退货时间转换成年月日*/
    public String getCreatetimeStr(){
        return DateUtil.dateConvert(createtime);
    }


}
