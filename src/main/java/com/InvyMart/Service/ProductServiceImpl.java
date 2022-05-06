package com.InvyMart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvyMart.Exception.OrderNotFoundException;
import com.InvyMart.Exception.ProductNotFoundException;
import com.InvyMart.Model.Department;
import com.InvyMart.Model.Product;
import com.InvyMart.Repository.DepartmentRepo;
import com.InvyMart.Repository.OrderRepo;
import com.InvyMart.Repository.ProductRepo;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	public ProductRepo productRepo;
	
	@Autowired
	public OrderRepo orderRepo;
	
	@Autowired
	public DepartmentRepo departmentRepo;
	
//	@Override
//	public Product addProduct(Product product) {
//		return productRepo.save(product);             //#OCL No.6
//	}
	
//	@Override
//	public String addProduct(Product product, long departmentId) {
//		
//		return departmentRepo.findDepartmentBydepartmentId(departmentId).map(products->{
//			productRepo.addProduct(product.getName(), product.getManufacturingDate(),product.getExpiryDate()
//					,product.getPrice(),product.getExpectedStock(),departmentId);
//			return "success";
//		}).orElseThrow(()->new ProductNotFoundException("Department by id " + departmentId + " was not found"));
//	}
	
	@Override
	public Product addProduct(Product product,Department department) {
		
		Product producttemp = new Product(product,department);
		return productRepo.save(producttemp);
		
	}
	
	@Override
	public Product updateProduct(Product product, long productId) {
		Product temp = productRepo.findProductByproductId(productId).get();
		
		temp.setName(product.getName());
		temp.setPrice(product.getPrice());
		temp.setManufacturingDate(product.getExpiryDate());
		temp.setExpiryDate(product.getExpiryDate());
		temp.setExpectedStock(product.getExpectedStock());
		
		return productRepo.save(temp);
	}
	
	@Override
	public List<Product> viewproducts(){
		return productRepo.findAll();
	}
	
	@Override
	public Product deleteProduct(long prodId) {       //#OCL No.7
		
		Product product = productRepo.getById(prodId);
		productRepo.delete(product);
		return product;
	}
	
	@Override
	public Product findProductByproductId(long prodId)
	{
		return productRepo.findProductByproductId(prodId).orElseThrow(()-> 
		new ProductNotFoundException("Product by id " + prodId + " was not found") );
	}
	
}
