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

import com.InvyMart.Model.Order;

import com.InvyMart.Service.OrderServiceImpl;

@RestController
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderServiceImpl;
	

	@PostMapping(value = "/{supplierid}/add")

	public ResponseEntity<String> addOrder(@PathVariable("supplierid") long supplierid) {
		String doc = orderServiceImpl.addOrder(supplierid);
		return ResponseEntity.ok().body(doc);
	}

	@PutMapping(value = "/compute/{orderid}")
	public ResponseEntity<Order> computeOrder(@PathVariable("orderid") long orderId){
		Order docOrder = orderServiceImpl.computeOrder(orderId);
		return ResponseEntity.ok().body(docOrder);
	}
	
	@PutMapping(value = "/{id}/supervisor/{Id}")
	public ResponseEntity<Order> placeOrder (@PathVariable("id") long orderId, @PathVariable("Id") long supervisorId)
			throws Exception {

		Order doc = orderServiceImpl.placeOrder(orderId,supervisorId);
		return ResponseEntity.ok().body(doc);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable("id") long orderId)
			throws Exception {

		Order doc = orderServiceImpl.updateOrder(order, orderId);
		return ResponseEntity.ok().body(doc);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable long id) throws Exception {
		
		orderServiceImpl.deleteOrder(id);
		                 
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/fetchall")
	public ResponseEntity<List<Order>> viewOrders() {
		List<Order> doc = orderServiceImpl.viewOrders();
		return ResponseEntity.ok().body(doc);
	}
	
@GetMapping(value="/find/{id}")
 public ResponseEntity<Order> getOrderById(@PathVariable("id") long orderId){
	Order order = orderServiceImpl.findOrderByorderId(orderId);
	return ResponseEntity.ok().body(order);
}

	
}
