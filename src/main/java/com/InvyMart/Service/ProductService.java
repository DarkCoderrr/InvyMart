package com.InvyMart.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.InvyMart.Model.Department;
import com.InvyMart.Model.Product;



public interface ProductService {

//	public String addProduct(Product product, long departmentId);
	public Product addProduct(Product product, Department department);
	public Product updateProduct(Product product, long productId);
	public List<Product> viewproducts();
	public Product deleteProduct(long prodId);
	public Product findProductByproductId(long prodId);
}
