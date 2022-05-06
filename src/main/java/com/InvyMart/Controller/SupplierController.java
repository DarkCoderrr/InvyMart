package com.InvyMart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvyMart.Model.Supervisor;
import com.InvyMart.Model.Supplier;
import com.InvyMart.Service.SupplierServiceImpl;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierServiceImpl supplierServiceImpl;
	
	@PostMapping(value = "/add")
	public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {

		Supplier doc = supplierServiceImpl.addSupplier(supplier);
		return ResponseEntity.ok().body(doc);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier, @PathVariable("id") long supplierId)
			throws Exception {

		Supplier doc = supplierServiceImpl.updateSupplier(supplier, supplierId);
		return ResponseEntity.ok().body(doc);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Supplier> deleteSupplier(@PathVariable long id) throws Exception {
		
		supplierServiceImpl.deleteSupplier(id);
		                 
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/fetchall")
	public ResponseEntity<List<Supplier>> viewAllSuppliers() {
		List<Supplier> doc = supplierServiceImpl.viewAllSuppliers();
		return ResponseEntity.ok().body(doc);
	}
	
	@GetMapping(value="/find/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") long id){
		Supplier supplier = supplierServiceImpl.findSupplierBysupplierId(id);
		return ResponseEntity.ok().body(supplier);
	}
}
