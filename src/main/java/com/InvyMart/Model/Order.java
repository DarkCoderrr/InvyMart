package com.InvyMart.Model;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Orders")
@ToString
public class Order {

	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Order_ID",nullable = false)        //OCL NO-18
	private long orderId;
//	@Column(columnDefinition="default '00000'")
	private long Quantity=0;
//	@Column(columnDefinition="default '00000'")
	private long price=0;
	
////	@JsonIgnore
//	@OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)            //OCL NO-16
//    private List<Product> products; 
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "Supplier_ID") 
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Supplier supplier;
	
	
	@ManyToMany                                                         //#OCL No-11
    @JoinTable(name = "Suppervisor_Orders", joinColumns = @JoinColumn(name = "Order_ID"), 
	inverseJoinColumns = @JoinColumn(name = "SUP_ID"))
	public List<Supervisor> supervisors;
	
	
	@OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)	
	private List<OrderItem> orderItems;
//	public  Set<Supervisor> supervisors = new HashSet<>();
}
