package br.edu.infnet.venda.domain.model;

public class User {

	public int id;
	public String name;
	public String password;
	public String email;
	public String location;
	
	public User(int id, String name, String password, String email, String location){
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.location = location;
	}
	
	public void registerConfirmation() {
		System.out.println("Succesfull register user name: " + this.name);
	}
	
	public int getId() {
        return id;
    }
	
}

