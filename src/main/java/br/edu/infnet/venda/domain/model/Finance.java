package br.edu.infnet.venda.domain.model;	
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.vendas.domain.exception.InsuficientFundsException;

public class Finance implements IReport {
	
	double totalIncome;
	List<Logs> ListLogs = new ArrayList<>();
	
	public Finance() {
		
		this.totalIncome = 0.0;
	}
	
	protected void addIncome(double value) {
		
		totalIncome += value;
		Logs log = new FinanceLogs("Adicionado receita", value, "ENTRADA");
		ListLogs.add(log);
		
	}
	
	protected void removeIncome(double value) {
		if (value > this.totalIncome) {
	        throw new InsuficientFundsException("Operação negada: Saldo de R$ " + this.totalIncome + " é menor que o valor R$ " + value);
	    }
	    
	    this.totalIncome -= value;
		Logs log = new FinanceLogs("Removendo receita", value, "SAÍDA");
		ListLogs.add(log);
	}
	
	public double showIncome() {
		return this.totalIncome;
	}
	
	@Override
	public void showReport() {
		System.out.println(" -- FINANCE REPORT --");
        toString();
        showFinanceLogs();
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
	
	public List<Logs> getLogs() {
	    return new ArrayList<>(this.ListLogs); 
	}

}
	