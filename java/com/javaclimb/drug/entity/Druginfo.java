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
@Data
@TableName(value = "druginfo")
public class Druginfo implements Serializable {
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Date getProducttime() {
		return producttime;
	}

	public void setProducttime(Date producttime) {
		this.producttime = producttime;
	}

	public String getWarrenty() {
		return warrenty;
	}

	public void setWarrenty(String warrenty) {
		this.warrenty = warrenty;
	}

//	public String getNumber() {
//		return number;
//	}
//
//	public void setNumber(String number) {
//		this.number = number;
//	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@TableId(value="id",type= IdType.AUTO)
	private Integer id;

    /*药品名称*/
    private String name;

    /*药品名称*/
    private String supplier;

    /*生产时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date producttime;

    /*保质期（月）*/
    private String warrenty;

//    /*药品编码*/
//    private String number;

    /*价格*/
    private Float price;

    /*库存*/
    private Integer stock;
    /*药品类型*/
    private String drugtype;
    /*药品图片*/
    private String img;
    /*药品详情*/
    private String detailinfo;
    /*药品详情*/
    private Integer salenum;
    
    
    
    public Integer getSalenum() {
		return salenum;
	}

	public void setSalenum(Integer salenum) {
		this.salenum = salenum;
	}

	public String getDrugtype() {
		return drugtype;
	}

	public void setDrugtype(String drugtype) {
		this.drugtype = drugtype;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDetailinfo() {
		return detailinfo;
	}

	public void setDetailinfo(String detailinfo) {
		this.detailinfo = detailinfo;
	}

	/*生产时间转换成年月日*/
    public String getProducttimeStr(){
        return DateUtil.dateConvert(producttime);
    }

}
