package com.InvyMart.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Supplier {

	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Supplier_ID",nullable = false)
	private long supplierId;
	@Column(unique=true)                       //#OCL No-10
	private String userName;
	private String Password;
	private boolean isActive=false;
	private boolean isSupplier= true;
	 
	@JsonIgnore 
		public boolean isActivesupplier() {
		    	return isActive;
		    }
	
	@JsonIgnore
	@OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
	private List<Order> orders;
}
