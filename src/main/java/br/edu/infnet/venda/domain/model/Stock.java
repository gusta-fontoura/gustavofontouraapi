package br.edu.infnet.venda.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Stock implements IReport{
	
	private List<Product> products;
	private List<Logs> stockLogs = new ArrayList<>();
	
	public Stock(){
		this.products = new ArrayList<>();
	}
	
	public List<Product> getProducts(){
		return products;
	}
	
	
	@Override
	public void showReport() {
		System.out.println(" -- RELATÓRIO DE ESTOQUE --");
        System.out.println("Itens totais: " + products.size());
	}
	
	
	public void showStockLogs() {
        System.out.println("-- Histórico de Movimentações --");
        for (Logs log : stockLogs) {
            System.out.println(log.toString());
        }
    }
	
	@Override
	public String toString() {
		return "Stock [itemList=" + products + "]";
	}

	
	public List<Logs> getLogs() {
	    return new ArrayList<>(this.stockLogs);
	}
}
