package com.InvyMart.Service;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvyMart.Exception.SupplierNotFoundException;
import com.InvyMart.Exception.UserNotFoundException;
import com.InvyMart.Model.Supervisor;
import com.InvyMart.Model.Supplier;

import com.InvyMart.Repository.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService{
	
    @Autowired
	public  SupplierRepo supplierRepo;
    
    Supplier temporaryObjectSupplier = new Supplier();
	
	
	@Override
	public Supplier addSupplier(Supplier supplier) {
		return supplierRepo.save(supplier);
	}
	
	
	//{Manage Supplier State}
	@Override
	public Supplier updateSupplier(Supplier supplier, long supplierid) {
		Supplier temp= supplierRepo.findSupplierBysupplierId(supplierid).get();
		
		temp.setUserName(supplier.getUserName());
		temp.setPassword(supplier.getPassword());
		return supplierRepo.save(temp);
	}
	
	@Override
	public List<Supplier> viewAllSuppliers(){
		return supplierRepo.findAll();
	}
	
	@Override
	public Supplier deleteSupplier(long supplierid) {
		
		Supplier supplier = supplierRepo.getById(supplierid);
		supplierRepo.delete(supplier);
		return supplier;
	}
	@Override
	public Supplier findSupplierBysupplierId(long supplierId) {
		return supplierRepo.findSupplierBysupplierId(supplierId).orElseThrow(()->
		new SupplierNotFoundException("Supplier by id " + supplierId + " was not found"));
	}
	
	
	//{Authenticate State}
	//{Logged In State}
	@Override
	public Supplier SupplierLogin(String username, String password) {
		
        if(supplierRepo.isSupplierExistByUsernameAndPassword(username,password)== 1) {
        	temporaryObjectSupplier = supplierRepo.findSupplierByuserName(username).get();
        	temporaryObjectSupplier.setActive(true);
        	temporaryObjectSupplier.setSupplier(true);
        return	supplierRepo.save(temporaryObjectSupplier);
        			
		}
        
        else { 
        	
        	throw new UserNotFoundException("Supplier by username " + username + " was not found");
			
        }
	}
	
	
	//{Supplier Logout State}
	@Override
	public Supplier logout(boolean isactive) {
		
		if(temporaryObjectSupplier.isActivesupplier()) {
			temporaryObjectSupplier.setActive(isactive);
		
		return supplierRepo.save(temporaryObjectSupplier);
		}
		
		else {
			throw new UserNotFoundException("Supplier already logout");
		}

}
}
