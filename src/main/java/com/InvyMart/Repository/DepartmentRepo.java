package com.InvyMart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.InvyMart.Model.Department;
import com.InvyMart.Model.DepartmentType;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

//	@Query(value = "select * from #{#entityName} d where d.DEP_ID=?1", nativeQuery = true)
//	public Department getById(long Id);
	
	Optional<Department> findDepartmentBydepartmentId(long id);
	
	Optional<Department> findDepartmentBytype(String type);
}
