package com.InvyMart.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.InvyMart.Model.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{

//	@Query(value = "select * from #{#entityName} d where d.SUP_ID=?1", nativeQuery = true)
//     public Order getsupervisorID(long Id);
	
	Optional<Order> findOrderByorderId(Long orderId);
	
	
	@Transactional
	@Modifying
	@Query(value = "insert into Orders(Quantity, price, Supplier_ID) VALUES "
			+ "(:Quantity, :price,:Supplier_ID)", nativeQuery = true)
	Integer addOrder(@Param("Quantity") long Quantity, 
			@Param("price") long price, @Param("Supplier_ID") long Supplier_ID);
			
	
	
}
