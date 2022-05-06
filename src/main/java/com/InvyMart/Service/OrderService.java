package com.InvyMart.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.InvyMart.Model.Order;



public interface OrderService {
//	public Order placeOrder(Order order);
	public Order computeOrder(long orderItemId);
	public String addOrder(long supplierId);
	public Order placeOrder(long orderId, long supervisorId);
//	public Order placeOrder(Order order, Long supervisorid);
	public Order updateOrder(Order order, long orderId);
	public List<Order> viewOrders();
	public Order deleteOrder(long orderId);
	public Order findOrderByorderId(long Id);
//	public Long totalPrice(Order order);
	
}
