package br.edu.infnet.venda.domain.model;

public class Item {
	String name;
	private double value;

	public Item(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	public Item(String name) {
		this(name, 0);
		System.out.println("Item foi criado sem valor.");
	}
	
	public Item() {
		System.out.println("O item foi criado vazio.");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Item [name=" + name + ", value=" + value + "]";
	}
}


