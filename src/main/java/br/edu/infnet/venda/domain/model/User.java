package br.edu.infnet.venda.domain.model;

import java.util.ArrayList;
import java.util.List;

// potencialmente mudar essa classe para business...

public class User {

	private int id;
	private String name;
	private String password;
	private boolean activeStatus;
	//public String role;
	private Finance userFinance;
	private Stock userStock;
	
	private List<Order> orderList = new ArrayList<>();

	public User(String name, String password){
		this.name = name;
		this.password = password;
		this.userFinance = new Finance();
		this.userStock = new Stock();
		this.activeStatus = true;
	}
	
	public User (String name) {
		this(name, null);
	}
	
	private void MakeOrderToStock(Item item, String type){
		Order order = new Order(item);
		orderList.add(order);
		
		switch(type) {
			case "sell":
				order.setOrderTypeToSell();
				break;
			case "buy":
				order.setOrderTypeToBuy();
				break;
		}
	}
	
		
	public void Buy(String name, double value, int quantity) {
		
		double totalIncome = userFinance.showIncome();
		double totalDept = value * quantity;
		
		if(totalIncome < totalDept) {
			System.out.println("No funds to complete the operation");
		}else {
			for (int i = 0; i < quantity; i++) {
				Item item = new Item(name, value);
				MakeOrderToStock(item, "buy");
				userStock.enterItem(item);
			}
		}
		userStock.showStock();
	}
	
	public void Sell(int quantity, Item item) {
		
		double income = quantity * 1.2;
		if(!userStock.checkItem(item)) {
			System.out.println("ERROR: No item available in stock");
		}else {
			MakeOrderToStock(item, "sell");
			userStock.removeItem(item);
			userFinance.addIncome(income);
		}
		
	}
	
	
	public void registerConfirmation() {
		System.out.println("Succesfull register user name: " + this.name);
		System.out.println("Succesfull register user ID: " + this.id);
	}
	
	public void addIncome(double income) {
		this.userFinance.addIncome(income);
	}
	
	public void checkIncome() {
		System.out.println("Checando o saldo da conta..");
		double saldo = this.userFinance.showIncome();
		System.out.println(this.name + ", seu saldo é: " + saldo);
	}
	
	
	public int getId() {
        return id;
    }
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public boolean getActiveStatus() {
		return activeStatus;
	}
	
	public void SetActiveStatusToFalse() {
		this.activeStatus = false;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", activeStatus=" + activeStatus
				+ ", userFinance=" + userFinance + ", userStock=" + userStock + ", orderList=" + orderList + "]";
	}
	
}
	
	
