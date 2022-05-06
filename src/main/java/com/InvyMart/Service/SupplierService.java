package com.InvyMart.Service;

import java.util.List;

import com.InvyMart.Model.Order;
import com.InvyMart.Model.Supplier;



public interface SupplierService {

	public Supplier addSupplier(Supplier supplier);
	public Supplier updateSupplier(Supplier supplier, long supplierId);
	public List<Supplier> viewAllSuppliers();
	public Supplier deleteSupplier(long supplierId);
	public Supplier findSupplierBysupplierId(long supplerId);
	//	public Supplier orderStatuSupplier(Order order);
	public Supplier SupplierLogin(String username, String password);
	public Supplier logout(boolean isactive);
}
