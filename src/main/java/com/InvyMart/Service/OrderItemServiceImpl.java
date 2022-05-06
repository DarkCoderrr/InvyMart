package com.InvyMart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvyMart.Model.Order;
import com.InvyMart.Model.OrderItem;
import com.InvyMart.Model.Product;
import com.InvyMart.Repository.OrderItemRepo;
import com.InvyMart.Repository.OrderRepo;
import com.InvyMart.Repository.ProductRepo;

@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	public OrderItemRepo orderItemRepo;
	
	@Autowired
	public ProductRepo productRepo;
	
	@Autowired
	public OrderRepo orderRepo;
	
	
	 //{OrderPlaced State}
	@Override
	public OrderItem addOrderItem(OrderItem orderItem, long productId, long orderID) {  
		
		orderItem.setTotalPrice(calculatetotalItemPrice(orderItem,productId));
		Product temProduct = productRepo.findProductByproductId(productId).get();
		Order tempOrder = orderRepo.findOrderByorderId(orderID).get();
		orderItem.setOrders(tempOrder);
		orderItem.setProduct(temProduct);
		return orderItemRepo.save(orderItem);
	}                                                               
	
	@Override
	public OrderItem findOrderItemByorderItemId(long orderitemId) {
		
	return orderItemRepo.findOrderItemByorderItemId(orderitemId).get();
		
	}
	
	
	//{Stock Check State}
	@Override
	public long calculatetotalItemPrice(OrderItem orderItem, long productid) {  
		
		Product temProduct = productRepo.findProductByproductId(productid).get();
		
		
		long totalprice = orderItem.getTotalQuantity()* temProduct.getPrice();
		
		return totalprice;
	}
	
	@Override
	public List<OrderItem> viewOrderItems(){
		return orderItemRepo.findAll();
	}
	
	@Override
	public List<OrderItem> findAllByOrderItemByorderId(long orderId) {
		return orderItemRepo.findAllByOrderItemByorderId(orderId).get();
	}
	

}
