package com.InvyMart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvyMart.Model.Department;
import com.InvyMart.Service.DepartmentServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Department")
public class DepartmentController {

	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	@PostMapping(value = "/add")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {

		Department doc = departmentServiceImpl.addDepartment(department);
		return ResponseEntity.ok().body(doc);
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department, @PathVariable("id") long departmentId)
			throws Exception {

		Department doc = departmentServiceImpl.updateDepartment(department, departmentId);
		return ResponseEntity.ok().body(doc);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Department> deleteDepartment(@PathVariable long id) throws Exception {
		
		departmentServiceImpl.deleteDepartment(id);
		                 
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/fetchall")
	public ResponseEntity<List<Department>> viewdepartments() {
		List<Department> doc = departmentServiceImpl.viewdepartments();
		return ResponseEntity.ok().body(doc);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long id){
		Department department = departmentServiceImpl.findDepartmentBydepartmentId(id);
		return ResponseEntity.ok().body(department);
	}
}
