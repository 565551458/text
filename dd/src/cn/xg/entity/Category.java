package cn.xg.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable{

	private int id;
	private int turn;
	private String enName;
	private String name;
	private String description;
	private int parentId;
	//新增属性 表示他的子分类 用来处理表内关联 1:m的问题
	private List<Category> subCategory = new ArrayList<Category>();
	private List<Book> subBookList = new ArrayList<Book>();
	private int subNum;
	
	public String toString() {
		return "Category [id=" + id +  ", name=" + name + ", parentId=" + parentId + ", subCategory=" + subCategory.size() + "]";
	}

	public Category() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public List<Category> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<Category> subCategory) {
		this.subCategory = subCategory;
	}

	public List<Book> getSubBookList() {
		return subBookList;
	}

	public void setSubBookList(List<Book> subBookList) {
		this.subBookList = subBookList;
	}

	public int getSubNum() {
		return subNum;
	}

	public void setSubNum(int subNum) {
		this.subNum = subNum;
	}

	
	
	
}
