package com.InvyMart.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.InvyMart.Model.Department;
import com.InvyMart.Model.DepartmentType;



public interface DepartmentService {

	public Department addDepartment(Department department);
	public Department updateDepartment(Department department, long departmentid);
	public List<Department> viewdepartments();
	public Department deleteDepartment(long depId);
	public Department findDepartmentBydepartmentId(long depId);
	public Department findDepartmentBytype(String type);
}
