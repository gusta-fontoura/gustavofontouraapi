package br.edu.infnet.venda.domain.model;
import java.time.*;

public class Order {
	private int id;
	private LocalDate date;
	private OrderType orderType;
	private Item item;
	private int quantity;
	
	
	
	public Order(Item item, int quantity, OrderType orderType) {
		this.id = (int) (Math.random() * (100 - 0 + 1) + 0);
		this.date = LocalDate.now();
		this.orderType = orderType;;
		this.item = item;
		this.quantity = quantity;
		
	}
	
	public Order(Item item, OrderType orderType) {
		this.id = (int) (Math.random() * (100 - 0 + 1) + 0);
		this.date = LocalDate.now();
		this.orderType = orderType;;
		this.item = item;
		this.quantity = 1;
		
	}
	
	public enum OrderType{
		SELL,
		BUY,
		NONE
	}
	
	public int getId() {
		return id;
	}
	
	public LocalDate getOrderDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", orderType=" + orderType
				+ ", item=" + item + "]";
	}


	public OrderType getOrderType() {
		return this.orderType;
	}
	
	
	public Item getItem() {
		return item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	
}
