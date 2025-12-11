package br.edu.infnet.venda.domain.model;

public class Finance {
	
	double totalIncome;
	
	public Finance() {
		this.totalIncome = 0.0;
	}
	
	public void addIncome(double newIncome) {
		
		totalIncome = totalIncome + newIncome;
	}
	
	public void removeIncome(double newIncome) {
		totalIncome = totalIncome - newIncome;
	}
	
	public double showIncome() {
		return this.totalIncome;
	}
		
	@Override
	public String toString() {
		return "Finance [totalIncome=" + totalIncome + "]";
	}

	public void financeLogs() {
		System.out.println("Ainda não defini as ordens para criar uma lista de logs.");
	}
}
	