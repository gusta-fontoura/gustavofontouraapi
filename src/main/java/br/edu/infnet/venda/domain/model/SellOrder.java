package br.edu.infnet.venda.domain.model;
import java.time.*;

public class SellOrder {
	private int id;
	private LocalDate date;
	private int quantity;
	private Product product;
	
	public SellOrder(Product product, int quantity) {
		this.id = (int) (Math.random() * (100 - 0 + 1) + 0);
		this.date = LocalDate.now();
		this.product = product;
		this.quantity = quantity;
		
	}
	
	public SellOrder(Product product) {
		this.id = (int) (Math.random() * (100 - 0 + 1) + 0);
		this.date = LocalDate.now();
		this.product = product;
		this.quantity = 1;
		
	}

	public int getId() {return id;}
	
	public LocalDate getOrderDate() {return date;}
	
	public Product getProduct() {return product;}
	
	@Override
	public String toString() {return "Order [id=" + id + ", date=" + date + ", produto=" + product + "]";}
	
	
	public int getQuantity() {return quantity;}
}
