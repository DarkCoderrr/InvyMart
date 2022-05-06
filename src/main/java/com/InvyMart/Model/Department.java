package com.InvyMart.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="DEP_ID",nullable = false,unique=true)   //#OCL NO-8
	private long departmentId;
	
	@Enumerated(EnumType.STRING)
	private DepartmentType type;
	
	 @JsonIgnore
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private List<Product> products;
	
	@JsonIgnore
	@OneToOne(mappedBy = "department", cascade =  CascadeType.ALL)
	private Supervisor supervisor;
}
