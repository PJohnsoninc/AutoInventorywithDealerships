package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @authors peterjohnson & logan kennebeck - pmjohnson5 & ljkennebeck1
 * CIS175-Fall 2022
 * October 11, 2022
 */
@Entity
@Table(name = "brands")
public class AutoBrands {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "BRAND")
	private String brandName;
	
	public AutoBrands() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AutoBrands(String brandName) {
		super();
		this.brandName = brandName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Override
	public String toString() {
		return "AutoBrands [id=" + id + ", brandName=" + brandName + "]";
	}
	
	
	
	

}
