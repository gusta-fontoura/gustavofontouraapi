package br.edu.infnet.venda.domain.model;

public class Item {
	String name;
	private double value;
	
	
	public Item(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	public Item(String name) {
		value = 0;
		System.out.println("Item foi criado sem valor.");
	}
	
	public Item() {
		System.out.println("O item foi criado vazio.");
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public void SetValue(double value) {
		this.value = value;
	}
	
	public double GetValue() {
		return this.value;
	}
}


