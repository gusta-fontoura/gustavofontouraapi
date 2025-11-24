package br.edu.infnet.venda.domain.model;
import java.time.*;

public class Order {
	private int id;
	private LocalDate date;
	private OrderStatus status;
	private Item item;
	
	
	
	public Order() {
		this.id = (int) (Math.random() * (100 - 0 + 1) + 0);
		this.date = LocalDate.now();
		this.status = OrderStatus.PENDING;
		
	}
	

	public enum OrderStatus{
		PENDING,
		PROCESSING,
		COMPLETE,
		CANCELLED
	}
	
	public int getId() {
		return id;
	}
	
	public LocalDate getOrderDate() {
		return date;
	}
	
	public OrderStatus getOrderStatus() {
		return status;
	}
	
	public Item getItem() {
		return item;
	}
	
	/*public enum setOrderStatus(String status) {
		
	}*/
	
}
