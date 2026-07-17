package br.edu.infnet.venda.domain.model;

public class Product {
	private String name;
	private String id;
	private double value;
	private int quantity;
	
	public Product(String name, String id, double value, int quantity) {
		this.name = name;
		this.value = value;
		this.id = id;
		this.quantity = quantity;
	}
	
	public void setName(String name) {this.name = name;}
	
	public void setValue(double value) {this.value = value;}
	
	public void setQuantity(int value) {this.quantity = value;}
	
	public double getValue() {return value;}
	
	public String getName() {return name;}

	public String getId() {return id;}
	
	public int getQuantity() {return quantity;}
	
	@Override
	public String toString() {return "Item [name=" + name + ", value=" + value + "]";}
}


