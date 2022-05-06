package com.InvyMart.Service;

import java.util.List;

import com.InvyMart.Model.OrderItem;


public interface OrderItemService {

	public OrderItem addOrderItem(OrderItem orderItem,long productId, long orderid);
	public OrderItem findOrderItemByorderItemId(long orderitemid);
	public long calculatetotalItemPrice(OrderItem orderItem,long productId);
	public List<OrderItem> viewOrderItems();
	public List<OrderItem> findAllByOrderItemByorderId(long orderid);
	
//	public OrderItem updateOrderItem(OrderItem orderItem, long orderitemId);
}
