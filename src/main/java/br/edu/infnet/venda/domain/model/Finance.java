package br.edu.infnet.venda.domain.model;	
import java.util.ArrayList;
import java.util.List;

public class Finance {
	
	double totalIncome;
	List<Logs> ListLogs = new ArrayList<>();
	
	public Finance() {
		
		this.totalIncome = 0.0;
	}
	
	protected void addIncome(double value) {
		
		totalIncome += value;
		FinanceLogs log = new FinanceLogs("Adicionado receita", value, "ENTRADA");
		ListLogs.add(log);
		
	}
	
	protected void removeIncome(double value) {
		totalIncome -= value;
		FinanceLogs log = new FinanceLogs("Removendo receita", value, "SAÍDA");
		ListLogs.add(log);
	}
	
	public double showIncome() {
		return this.totalIncome;
	}
		
	
	public void showFinanceLogs() {
        System.out.println("-- Histórico Financeiro --");
        for (Logs log : ListLogs) {
            System.out.println(log.toString()); 
        }
	}
	
	@Override
	public String toString() {
		return "Finance [totalIncome=" + totalIncome + "]";
	}

}
	