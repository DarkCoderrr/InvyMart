package com.InvyMart.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.InvyMart.Model.Supervisor;
import com.InvyMart.Model.Supplier;
import com.InvyMart.Service.SupervisorServiceImpl;
import com.InvyMart.Service.SupplierServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginLogoutController {

	@Autowired
	SupervisorServiceImpl supervisorServiceImpl;
	
	@Autowired
	SupplierServiceImpl supplierServiceImpl;
	
	@Transactional
	@PostMapping(value="/{username}/{password}/{role}")
	public ResponseEntity<Object> SupervisorLogin(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("role") String role) {
		if(role.equalsIgnoreCase("supervisor")) { 
		Supervisor temp= supervisorServiceImpl.SupervisorLogin(username, password);
		return ResponseEntity.ok().body(temp);
		}
		else {
			Supplier  status= supplierServiceImpl.SupplierLogin(username, password);
				return ResponseEntity.ok().body(status);
			}
			
		}
	
	

	@Transactional
	@PostMapping(value = "/supervisor/logout")
	public ResponseEntity<Supervisor> SupervisorLogout(){
		Supervisor supervisor = supervisorServiceImpl.logout(false);
		return ResponseEntity.ok().body(supervisor);
	}
	
	@Transactional
	@PostMapping(value = "/supplier/logout")
	public ResponseEntity<Supplier> SupplierLogout(){
		Supplier supplier = supplierServiceImpl.logout(false);
		return ResponseEntity.ok().body(supplier);
	}

	
}
