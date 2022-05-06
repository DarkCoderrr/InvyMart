package com.InvyMart.Controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
import com.InvyMart.Model.Product;
import com.InvyMart.Service.DepartmentServiceImpl;
import com.InvyMart.Service.ProductServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

//	@PostMapping(value = "/add")
//	public ResponseEntity<Product> addProduct(@RequestBody Product Product) {
//
//		Product doc = productServiceImpl.addProduct(Product);
//		return ResponseEntity.ok().body(doc);
//	}
//	@PostMapping(value = "/department/{department_id}/order/{order_id}/add")
//	public ResponseEntity<String> addProduct(@RequestBody Product Product, @PathVariable ("department_id") long department_id, @PathVariable ("order_id") long order_id) {
//
//		String doc = productServiceImpl.addProduct(Product,department_id,order_id);
//		return ResponseEntity.ok().body(doc);
//	}
//	
	
	@PostMapping(value = "/add/{id}")
	public ResponseEntity<Product> addProduct(@RequestBody Product product,@PathVariable("id") Long id) {

		 Department department = departmentServiceImpl.findDepartmentBydepartmentId(id);
		
		Product doc = productServiceImpl.addProduct(product,department);
		return ResponseEntity.ok().body(doc);
	}
	
//	public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
//        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
//        if (!optionalCategory.isPresent()) {
//            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
//        }
//        Category category = optionalCategory.get();
//        productService.addProduct(productDto, category);
//        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
//    }

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") long productId)
			throws Exception {

		Product doc = productServiceImpl.updateProduct(product, productId);
		return ResponseEntity.ok().body(doc);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) throws Exception {
		
		productServiceImpl.deleteProduct(id);
		                 
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/fetchall")
	public ResponseEntity<List<Product>> viewProducts() {
		List<Product> doc = productServiceImpl.viewproducts();
		return ResponseEntity.ok().body(doc);
	}
	
	@GetMapping(value="/find/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id){
		Product product = productServiceImpl.findProductByproductId(id);
		return ResponseEntity.ok().body(product);
	}
}
