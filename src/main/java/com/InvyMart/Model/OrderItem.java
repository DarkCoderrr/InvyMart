package com.InvyMart.Model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

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
public class OrderItem {

	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="OrderItem_Id",nullable = false,unique=true)
	private long orderItemId;
	
	private long totalQuantity;
	private long totalPrice;

	
	@OneToOne
	@JoinColumn(name="PROD_ID", referencedColumnName ="PROD_ID" )
	private Product product;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Order_ID")
	private Order orders;
	
}
