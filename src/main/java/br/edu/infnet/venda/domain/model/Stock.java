package br.edu.infnet.venda.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Stock implements IReport{
	
	private List<Item> itemList = new ArrayList<>();
	private List<Logs> stockLogs = new ArrayList<>();
	
	public void enterItem(Order order) {
		this.itemList.add(order.getItem());
		System.out.println("Add iten on stockpile.");
		
		registerLog("Compra de " + order.getItem().getName(), order.getId(), order.getItem().getName(), order.getQuantity(), "BUY");
	}
	
	//Overload
	public void enterItem(Order order, String motivo) {
        for(int i=0; i<order.getQuantity(); i++) {
            this.itemList.add(order.getItem());
        }
        
        registerLog(motivo, order.getId(), order.getItem().getName(), order.getQuantity(), "BUY");

	}
	
	protected void removeItem(Order order) {
		if (!this.itemList.contains(order.getItem())){
			System.out.println("ERROR: Impossible to remove - Item is not in stockpile");
		}
		this.itemList.remove(order.getItem());
		System.out.println("Item removido: " + order.getItem().getName());
		registerLog("Manual remove", 0, order.getItem().getName(), 1, "SELL");
	}
	
	@Override
	public void showReport() {
		System.out.println(" -- RELATÓRIO DE ESTOQUE --");
        System.out.println("Itens totais: " + itemList.size());
        showStock();
	}
	
	public Item getItemById(String id) {
	    for (Item i : itemList) {
	        if (i.getId() == id) {
	            return i;
	        }
	    }
	    return null;
	}
	
	public boolean checkItem(Item i) {
		if(this.itemList.contains(i)) {
			System.out.println("Item is not in stockpile!");
			return true;
		}
		System.out.println("Item is not in stockpile");
		return false;
	}
	
	protected void showItem(Item item) {
		int countItem = 0;
		double totalValue = 0.0;
		for (Item i : itemList) {
			
			if (i.getValue() <= 0) {
	            continue;
	        }
			
			if(i.equals(item)) {
				countItem++;
				totalValue += i.getValue();
			}
		}
		if (countItem > 0) {
            System.out.println("Resumo do Item: " + item.getName() + 
                               " | Quantidade: " + countItem + 
                               " | Valor Total: R$ " + totalValue);
        } else {
            System.out.println("Item não encontrado no estoque.");
        }
	}
	
	private void registerLog(String msg, int idOrdem, String nomeItem, int qtd, String operacao) {
        Logs newLog = new StockLogs(msg, idOrdem, nomeItem, qtd, operacao);
        this.stockLogs.add(newLog);
    }
	
	public void showStockLogs() {
        System.out.println("-- Histórico de Movimentações --");
        for (Logs log : stockLogs) {
            System.out.println(log.toString());
        }
    }
	
	@Override
	public String toString() {
		return "Stock [itemList=" + itemList + "]";
	}

	public void showStock() {
		System.out.println("--- Inventário Completo ---");
		for(int i = 0; i < itemList.size(); i++) {
			System.out.println("ID: " + itemList.get(i).getId() + "Item: " + itemList.get(i).name + "Valor: " + itemList.get(i).getValue());
		}
	}
	
	public List<Logs> getLogs() {
	    return new ArrayList<>(this.stockLogs);
	}
}
