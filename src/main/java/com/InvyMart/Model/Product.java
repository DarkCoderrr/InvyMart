package com.InvyMart.Model;

import java.sql.Date;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Product {

	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PROD_ID",nullable = false,unique=true)       //#OCL No.1
	private Long productId;
	
	private String name;
	private Date expiryDate;
	private Date manufacturingDate;
	private long price;
	private long expectedStock;
//	private long unit;
	
	@JsonIgnore
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="DEP_ID")
	private Department department;
	
	public Product(Product product, Department department) {
		
		this.name=product.getName();
		this.manufacturingDate=product.getManufacturingDate();
		this.expiryDate=product.getExpiryDate();
		this.price=product.getPrice();
		this.expectedStock=product.getExpectedStock();
		this.department=department;
	}
	
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name="Order_ID")	
//	private Order orders;
//	
//	@JsonIgnore
//	@OneToOne
//	@JoinColumn(name="OrderItem_Id")
//	private OrderItem orderItem;
//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "Product_Orders", joinColumns = @JoinColumn(name = "name"), 
//			inverseJoinColumns = @JoinColumn(name = "Order_ID"))
//	@JoinColumn(name = "Order_ID")
//	private Order order;
	
}
