package com.InvyMart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.InvyMart.Model.OrderItem;
import com.InvyMart.Service.OrderItemServiceImpl;



@RestController
@RequestMapping("/OrderItem")
public class OrderItemController {

	@Autowired
	public OrderItemServiceImpl orderItemServiceImpl;
	
	
	@PostMapping(value = "/add/{productId}/{orderId}")
	public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItem order,@PathVariable("productId") long productId,@PathVariable("orderId") long orderId) {

	 OrderItem temp	=orderItemServiceImpl.addOrderItem(order, productId, orderId);
	 return ResponseEntity.ok().body(temp);
	}
		
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<OrderItem>> findAllOrderItem(){
		List<OrderItem> tempItems=orderItemServiceImpl.viewOrderItems();
		
		return ResponseEntity.ok().body(tempItems);
	}
	
	@GetMapping(value = "/findAll/{orderid}")
	public ResponseEntity<List<OrderItem>> findAllByOrderItemByorderItemId(@PathVariable("orderid") long orderid){
		List<OrderItem> tempItems=orderItemServiceImpl.findAllByOrderItemByorderId(orderid);
		
		return ResponseEntity.ok().body(tempItems);
	}
	
//	@PutMapping(value = "/update/{id}")
//	public ResponseEntity<OrderItem> updateOrderItem(@RequestBody OrderItem orderItem,@PathVariable("id") long id)
//		throws Exception {
//		OrderItem temp = orderItemServiceImpl.updateOrderItem(orderItem, id);
//		return ResponseEntity.ok().body(temp);
//	}
}
