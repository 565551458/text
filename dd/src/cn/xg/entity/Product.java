package cn.xg.entity;

import java.io.Serializable;

public class Product implements Serializable{
	
	private Integer id;
	private String product_name;
	private	String description;
	private Long   add_time;
	private Double fixed_price;
	private Double dang_price;
	private String keywords;
	private Integer has_deleted;
	private String product_pic;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer id, String product_name, String description, Long add_time, Double fixed_price,
			Double dang_price, String keywords, Integer has_deleted, String product_pic) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.description = description;
		this.add_time = add_time;
		this.fixed_price = fixed_price;
		this.dang_price = dang_price;
		this.keywords = keywords;
		this.has_deleted = has_deleted;
		this.product_pic = product_pic;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public Double getFixed_price() {
		return fixed_price;
	}
	public void setFixed_price(Double fixed_price) {
		this.fixed_price = fixed_price;
	}
	public Double getDang_price() {
		return dang_price;
	}
	public void setDang_price(Double dang_price) {
		this.dang_price = dang_price;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Integer getHas_deleted() {
		return has_deleted;
	}
	public void setHas_deleted(Integer has_deleted) {
		this.has_deleted = has_deleted;
	}
	public String getProduct_pic() {
		return product_pic;
	}
	public void setProduct_pic(String product_pic) {
		this.product_pic = product_pic;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", description=" + description + ", add_time="
				+ add_time + ", fixed_price=" + fixed_price + ", dang_price=" + dang_price + ", keywords=" + keywords
				+ ", has_deleted=" + has_deleted + ", product_pic=" + product_pic + "]";
	}
	
	

}
