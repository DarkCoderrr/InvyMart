package com.InvyMart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvyMart.Exception.DepartmentNotFoundException;
import com.InvyMart.Model.Department;
import com.InvyMart.Model.DepartmentType;
import com.InvyMart.Repository.DepartmentRepo;


@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	public DepartmentRepo departmentRepo;
	
	
	@Override
	public Department addDepartment(Department department) {
		return departmentRepo.save(department);
	}
	
	@Override
	public Department updateDepartment(Department department, long departmentid) {
		Department temp= departmentRepo.findDepartmentBydepartmentId(departmentid).get();
		
		temp.setType(department.getType());
		return departmentRepo.save(temp);
	}
	
	@Override
	public List<Department> viewdepartments(){ 
		return departmentRepo.findAll();
	}
	
	@Override
	public Department deleteDepartment(long depId) {
		
		Department department = departmentRepo.getById(depId);
		departmentRepo.delete(department);
		return department;
	}
	
	@Override
	public Department findDepartmentBydepartmentId(long depId) {
		return departmentRepo.findDepartmentBydepartmentId(depId).orElseThrow(()->
		new DepartmentNotFoundException("Department by id " + depId + " was not found"));
	}
	
	@Override
	public Department findDepartmentBytype(String type) {
		return departmentRepo.findDepartmentBytype(type).get();
	}
}
