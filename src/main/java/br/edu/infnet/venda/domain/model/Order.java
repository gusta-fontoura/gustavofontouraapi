package br.edu.infnet.venda.domain.model;
import java.time.*;

public class Order {
	private int id;
	private LocalDate date;
	private OrderStatus orderStatus;
	private OrderType orderType;
	private Item item;
	
	
	
	public Order(Item item) {
		this.id = (int) (Math.random() * (100 - 0 + 1) + 0);
		this.date = LocalDate.now();
		this.orderStatus = OrderStatus.PENDING;
		this.orderType = OrderType.NONE;
		this.item = item;
		
	}
	
	public enum OrderType{
		SELL,
		BUY,
		NONE
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
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", orderStatus=" + orderStatus + ", orderType=" + orderType
				+ ", item=" + item + "]";
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	public OrderType getOrderType() {
		return this.orderType;
	}
	
	public void setOrderTypeToBuy(){
		this.orderType = OrderType.BUY;
	}
	
	public void setOrderTypeToSell(){
		this.orderType = OrderType.SELL;
	}
	
	public Item getItem() {
		return item;
	}
	
	/*public enum setOrderStatus(String status) {
		
	}*/
	
}
