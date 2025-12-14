package br.edu.infnet.venda.domain.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.venda.domain.model.Order.OrderType;
import br.edu.infnet.vendas.domain.exception.InsuficientFundsException;
import br.edu.infnet.vendas.domain.infrastructure.LogRepository;


public class User {

	private int id;
	private String name;
	private String password;
	private boolean activeStatus;
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
	
	private Order MakeOrderToStock(Item item, String type, int quantity){
		
		
		if(type == "buy") {
				Order buyOrder = new Order(item, quantity, OrderType.BUY);
				orderList.add(buyOrder);
				return buyOrder;
				}
		else {
				Order sellOrder = new Order(item, quantity, OrderType.SELL);
				orderList.add(sellOrder);
				return sellOrder;
				}
	}
		
	public void Buy(String name, String id, double value, int quantity, String motivo) {
		
		double totalDept = value * quantity;
		try {
			userFinance.removeIncome(totalDept);
			Item item = new Item(name, id, value);
			
			if(motivo == "") {
				userStock.enterItem(MakeOrderToStock(item, "buy", quantity));
			}else {
				userStock.enterItem(MakeOrderToStock(item, "buy", quantity), motivo);
			}
			userStock.showStock();
		}	catch(InsuficientFundsException e) {
			System.err.println("ERRO NA COMPRA: " + e.getMessage());
		}	catch(Exception e) {
			System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
		}
		
	
		
	
		
	}
	
	public void Sell(int quantity, Item item) {
		
		double income = quantity * 1.2;
		if(!userStock.checkItem(item)) {
			System.out.println("ERROR: No item available in stock");
		}else {
			;
			userStock.removeItem(MakeOrderToStock(item, "sell", quantity));
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
	
	
	public Stock getStock() {
		return userStock;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", activeStatus=" + activeStatus
				+ ", userFinance=" + userFinance + ", userStock=" + userStock + ", orderList=" + orderList + "]";
	}

	public void showLogs() {
		this.userFinance.showFinanceLogs();
		this.userStock.showStockLogs();
		
	}
	
	public void showReports() {
		this.userFinance.showReport();
		this.userStock.showStock();
	}
	
	public void createLogsReport() {
        System.out.println("Gerando relatório unificado...");

        LogRepository repo = new LogRepository();

        List<Logs> logsUnificados = new ArrayList<>();

        logsUnificados.addAll(this.userFinance.getLogs());
        logsUnificados.addAll(this.userStock.getLogs());


        String nomeArquivo = "relatorio_" + this.name + "_" + this.id + ".txt";

        repo.saveLogsToFile(nomeArquivo, logsUnificados);
    }
	
}
	
	
