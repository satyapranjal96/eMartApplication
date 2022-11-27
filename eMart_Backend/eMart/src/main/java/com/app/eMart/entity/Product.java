package com.app.eMart.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_Id")
	private Long id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private Float productPrice;
	
	@Column(name="product_desc")
	private String productDescription;
	
	@Column(name="product_brand")
	private String productBrand;
	
	@Column(name="product_url")
	private String productImageUrl;
	
	@Column(name="product_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date productDate;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cat_id", referencedColumnName = "id",nullable = false)
	private Category catId;
	
	public Product() {
		
	}

	public Product(String productName, Float productPrice, String productDescription, String productBrand,
			String productImageUrl, Date productDate, Category catId) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productBrand = productBrand;
		this.productImageUrl = productImageUrl;
		this.productDate = productDate;
		this.catId = catId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Category getCatId() {
		return catId;
	}

	public void setCatId(Category catId) {
		this.catId = catId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDescription=" + productDescription + ", productBrand=" + productBrand + ", productImageUrl="
				+ productImageUrl + ", productDate=" + productDate + ", catId=" + catId + "]";
	}

	
	

}
