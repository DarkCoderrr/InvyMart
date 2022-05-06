package com.InvyMart.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvyMart.Exception.OrderNotFoundException;

import com.InvyMart.Model.Order;
import com.InvyMart.Model.OrderItem;
import com.InvyMart.Model.Supervisor;
import com.InvyMart.Repository.OrderItemRepo;
import com.InvyMart.Repository.OrderRepo;
import com.InvyMart.Repository.ProductRepo;
import com.InvyMart.Repository.SupervisorRepo;
import com.InvyMart.Repository.SupplierRepo;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	public OrderRepo orderRepo; 
	
	@Autowired
	public SupplierRepo supplierRepo;

	@Autowired
	public SupervisorRepo supervisorRepo;
	
	@Autowired 
	public ProductRepo productRepo;
	
	@Autowired
	public OrderItemRepo orderItemRepo;

	long price =0;
	long quantity =0;
	

	
	//{Processing Order State}
	
	@Override
	public Order computeOrder(long orderId) {
		
	List<OrderItem>	 tempItem = orderItemRepo.findAllByOrderItemByorderId(orderId).get();
	Order tempOrder = orderRepo.findOrderByorderId(orderId).get();
	for (OrderItem orderItem : tempItem) {                      
		
		price += orderItem.getTotalPrice();                 
		quantity += orderItem.getTotalQuantity();
	}
	tempOrder.setPrice(price);
	tempOrder.setQuantity(quantity);
	
	return orderRepo.save(tempOrder);

		
	}
	
	@Override
	public String addOrder(long supplierId) {                  
		
//		OrderItem tempItem = orderItemRepo.findOrderItemByorderItemId(orderItemId).get();
		Order tempOrder = new Order();
		return supplierRepo.findSupplierBysupplierId(supplierId).map(order->{
			orderRepo.addOrder(tempOrder.getPrice(),tempOrder.getQuantity(),supplierId);
			return "success";
		}).orElseThrow(()->new OrderNotFoundException("Order by id " + supplierId + " was not found"));
		
	}
	
	
	
	//{Fulfilled Order Request State}
	@Override
	public Order placeOrder(long orderid, long supervisorId) {        
		
		Supervisor supervisor = supervisorRepo.findById(supervisorId).get();
		Order tempOrder = orderRepo.findById(orderid).get();
		
		List<Supervisor> listSupervisors = new ArrayList<>(); 
//		Product prod = productRepo.findProductByproductId(supervisorId)
		
		listSupervisors.add(supervisor);
		tempOrder.supervisors.add(supervisor);	
		return orderRepo.save(tempOrder);		
		
	}
	
	
	
	//{Order Updated State}
	@Override
	public Order updateOrder(Order order, long orderId) {                 
		Order tempOrder =  orderRepo.findOrderByorderId(orderId).get();
		
		tempOrder.setPrice(order.getPrice());
		tempOrder.setQuantity(order.getQuantity());
		
		return orderRepo.save(tempOrder); 
	}
	
	@Override
	public List<Order> viewOrders(){
		return orderRepo.findAll();
	}
	
	@Override
	public Order deleteOrder(long orderId) {
		
		Order order = orderRepo.getById(orderId);
		orderRepo.delete(order);
		return order;
	}
	
	@Override
	public Order findOrderByorderId(long orderId) {
		return orderRepo.findOrderByorderId(orderId).orElseThrow(() -> 
		new OrderNotFoundException("Order by id " + orderId + " was not found"));
	}
	
	
}
