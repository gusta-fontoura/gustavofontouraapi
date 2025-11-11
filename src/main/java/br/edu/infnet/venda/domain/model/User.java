package br.edu.infnet.venda.domain.model;


// potencialmente mudar essa classe para business...

public class User {

	private int id;
	private String name;
	private String password;
	//public String role;
	private Finance userFinance;
	private Stock userStock;
	
	public User(String name, String password){
		this.name = name;
		this.password = password;
		this.userFinance = new Finance();
		this.userStock = new Stock();
		
	}
	
	// TODO: criar os metodos buy e sell.
	
	public void Buy(String name, double value, int quantity) {
		
		double totalIncome = userFinance.showIncome();
		double totalDept = value * quantity;
		
		if(totalIncome < totalDept) {
			System.out.println("No funds to complete the operation");
		}else {
			for (int i = 0; i < quantity; i++) {
				Item item = new Item(name, value);
				userStock.enterItem(item);
			}
		}
		
		userStock.showStock();;
		
	}
	
	public void Sell(int quantity, Item item) {
		
		double income = quantity * 1.2;
		if(!userStock.checkItem(item)) {
			System.out.println("ERROR: No item available in stock");
		}else {
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
}
	
	
