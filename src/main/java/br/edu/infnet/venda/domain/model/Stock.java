package br.edu.infnet.venda.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private List<Item> itemList = new ArrayList<>();
	
	
	public void enterItem(Item item) {
		System.out.println("Add iten on stockpile.");
		
		this.itemList.add(item);
	}
	
	public void removeItem(Item item) {
		if (!this.itemList.contains(item)){
			System.out.println("ERROR: Impossible to remove - Item is not in stockpile");
		}
		this.itemList.remove(item);
	}
	
	public boolean checkItem(Item item) {
		if (!this.itemList.contains(item)){
			System.out.println("ERROR: Item is not in stockpile");
			return false;
		}
		System.out.println("Item available");
		return true;
	}
	
	public void showItem(Item item) {
		int countItem = 0;
		int totalValue = 0;
		for (Item i : itemList) {
			
			if (i.getValue() <= 0) {
	            continue;
	        }
			
			if(i.equals(item)) {
				countItem++;
				totalValue += i.getValue();
			}
			
		System.out.println("Item: " + item.name + "| Quantitie:" + countItem + "| Value: " + totalValue);
		}
	}
	
	
	
	@Override
	public String toString() {
		return "Stock [itemList=" + itemList + "]";
	}

	public void showStock() {
		for(int i = 0; i < itemList.size(); i++) {
			System.out.println("Item: " + itemList.get(i).name + "Valor: " + itemList.get(i).getValue());
		}
	}
}
