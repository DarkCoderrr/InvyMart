package com.InvyMart.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.InvyMart.Model.OrderItem;


public interface OrderItemRepo extends JpaRepository<OrderItem, Long>{
	
Optional<OrderItem> findOrderItemByorderItemId(long orderitemid);

//Optional<List<OrderItem>> findAllByOrderItemByorderId(long orderid);

@Transactional

@Query(value = "select * from order_item O where O.order_id=:order_id ", nativeQuery = true)
Optional<List<OrderItem>>  findAllByOrderItemByorderId(@Param("order_id") long order_id);
		

}
