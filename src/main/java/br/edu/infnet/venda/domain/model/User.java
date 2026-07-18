package br.edu.infnet.venda.domain.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.venda.domain.services.StockService;
import br.edu.infnet.vendas.domain.exception.InsuficientFundsException;


public class User {

	private int id;
	private String name;
	private String password;
	private boolean activeStatus;
	private StockService userStock;
	
	private List<SellOrder> orderList = new ArrayList<>();

	public User(String name, String password){
		this.name = name;
		this.password = password;
		this.userStock = new StockService();
		this.activeStatus = true;
	}
	
	public User (String name) {
		this(name, null);
	}
	
		
	public void Buy(String name, String id, double value, int quantity, String motivo) {
		
		try {
			Product product = new Product(name, id, value, quantity);
			
			if(motivo == "") {
				userStock.addProduct(null);
			}else {
				userStock.addProduct(product);
			}
			userStock.showStock();
		}	catch(InsuficientFundsException e) {
			System.err.println("ERRO NA COMPRA: " + e.getMessage());
		}	catch(Exception e) {
			System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
		}
	}
	
	public void Sell(int quantity, Product product) {
		
		if(!userStock.checkProduct(product)) {
			System.out.println("ERROR: No item available in stock");
		}else {
			;
			userStock.removeProduct(product.getId());
		}
		
	}
	
	public void registerConfirmation() {
		System.out.println("Succesfull register user name: " + this.name);
		System.out.println("Succesfull register user ID: " + this.id);
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
	
	
	public void getStock() {
		userStock.showStock();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", activeStatus=" + activeStatus
				+ ", userStock=" + userStock + ", orderList=" + orderList + "]";
	}
}
	
	
