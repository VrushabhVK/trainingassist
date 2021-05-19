package com.gta.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long catid;
	
	@Column(nullable = false, unique = true, length = 50)
	private String CategoryName;
	
	
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "Category [catid=" + catid + ", CategoryName=" + CategoryName + "]";
	}
	
	
	
}
