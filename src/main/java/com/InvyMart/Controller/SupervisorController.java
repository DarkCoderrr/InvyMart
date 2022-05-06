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

import com.InvyMart.Model.Order;
import com.InvyMart.Model.Supervisor;
import com.InvyMart.Service.SupervisorServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

	@Autowired
	private SupervisorServiceImpl supervisorServiceImpl;

//	@PostMapping(value = "/add")
//	public ResponseEntity<Supervisor> addSupervisor(@RequestBody Supervisor supervisor) {
//
//		Supervisor doc = supervisorServiceImpl.addSupervisor(supervisor);
//		return ResponseEntity.ok().body(doc);
//	}
	
	@PostMapping(value = "/{departmentid}/add")
	public ResponseEntity<String> placeOrder(@PathVariable("departmentid") long departmentid,@RequestBody Supervisor supervisor) {

		String doc = supervisorServiceImpl.addSupervisor(supervisor,departmentid);
		return ResponseEntity.ok().body(doc);
	}


	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Supervisor> updateSupervisor(@RequestBody Supervisor supervisor,@PathVariable("id") long supervisorid){
		Supervisor doc = supervisorServiceImpl.updateSupervisor(supervisor, supervisorid);

		
		return ResponseEntity.ok().body(doc);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Supervisor> deleteSupervisor(@PathVariable long id) throws Exception {
		
		                 supervisorServiceImpl.deleteSupervisor(id);
		                 
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	@GetMapping(value = "/fetchall")
	public ResponseEntity<List<Supervisor>> viewSupervisors() {
		List<Supervisor> doc = supervisorServiceImpl.viewSupervisors();
		return ResponseEntity.ok().body(doc);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Supervisor> getSupervisorById(@PathVariable("id") long id) {
		Supervisor supervisor = supervisorServiceImpl.findSupervisorBysupervisorId(id);
		return ResponseEntity.ok().body(supervisor);
	}
}
