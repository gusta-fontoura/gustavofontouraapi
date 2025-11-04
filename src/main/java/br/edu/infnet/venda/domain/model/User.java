package br.edu.infnet.venda.domain.model;


// potencialmente mudar essa classe para business...

public class User {

	public int id;
	public String name;
	public String password;
	//public String role;
	private Finance userFinance;
	
	public User(String name, String password){
		this.name = name;
		this.password = password;
		this.userFinance = new Finance();
	}
	
	public void Buy() {
		
	}
	
	public void Sell() {
		
	}
	
	
	public void registerConfirmation() {
		System.out.println("Succesfull register user name: " + this.name);
		System.out.println("Succesfull register user ID: " + this.id);
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
	
	
