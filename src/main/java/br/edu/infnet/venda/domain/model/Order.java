package br.edu.infnet.venda.domain.model;
import java.time.*;

public class Order {
	private int id;
	private LocalDate date;
	private OrderType orderType;
	private int quantity;
	private Product product;
	
	
	
	public Order(Product product, int quantity, OrderType orderType) {
		this.id = (int) (Math.random() * (100 - 0 + 1) + 0);
		this.date = LocalDate.now();
		this.orderType = orderType;;
		this.product = product;
		this.quantity = quantity;
		
	}
	
	public Order(Product product, OrderType orderType) {
		this.id = (int) (Math.random() * (100 - 0 + 1) + 0);
		this.date = LocalDate.now();
		this.orderType = orderType;;
		this.product = product;
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
				+ ", produto=" + product + "]";
	}


	public OrderType getOrderType() {
		return this.orderType;
	}
	
	
	public Product getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	
}
