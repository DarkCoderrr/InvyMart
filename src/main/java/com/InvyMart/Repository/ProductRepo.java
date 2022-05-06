package com.InvyMart.Repository;

import java.sql.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.InvyMart.Model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

//	@Query(value = "select * from #{#entityName} p where p.PROD_ID=?1", nativeQuery = true)
//	public Product getById(long Id);
	Optional<Product> findProductByproductId(long productId);
	
//	@Transactional
//	@Modifying
//	@Query(value = "insert into product(name,expiry_Date, manufacturing_Date, price, expected_Stock, unit, DEP_ID, Order_ID) VALUES "
//			+ "(:name, :expiry_Date,:manufacturing_Date, :price, :expected_Stock,:DEP_ID, :Order_ID)", nativeQuery = true)
//	Integer addProduct(@Param("name") String name, @Param("expiry_Date") Date expiryDate, @Param("manufacturing_Date") Date manufacturingDate, 
//			@Param("price") long price, @Param("expected_Stock") long expectedStock,
//			@Param("DEP_ID") long DEP_ID, @Param("Order_ID") long Order_ID);
			
}

