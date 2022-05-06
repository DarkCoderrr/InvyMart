package com.InvyMart.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.el.parser.AstFalse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Supervisor implements Serializable{
        
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="SUP_ID",nullable = false, updatable = false)
	 @Column(nullable = false, updatable = false,unique=true)
	    private long supervisorId;
	    private String name;
	    @Column(name="seniorityLevel")
	    private String seniorityLevel;
	    @Column(unique=true)                    //#OCL-14
	    private String username;
	    private String password;
	    private String emailId;
	    private String supervisorCode;
	    private boolean isActive=false;
	 
	   @JsonIgnore 
	public boolean isActivesupervisor() {
	    	return isActive;
	    }
	    
	    
	    @JsonIgnore
	    @OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "department_ID",unique = true)
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	    private Department department;
	    
	    @JsonIgnore
	    @ManyToMany(mappedBy = "supervisors", cascade  = CascadeType.ALL)
//	    @JoinTable(name = "Suppervisor_Orders", joinColumns = @JoinColumn(name = "SUP_ID"), 
//		inverseJoinColumns = @JoinColumn(name = "Order_ID"))
	    private List<Order> orders;                                //#OCL-16
	    

}
