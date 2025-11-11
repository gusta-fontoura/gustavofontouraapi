package br.edu.infnet.venda.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	public List<Item> itemList = new ArrayList<>();
	
	
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
			if(i == item) {
				countItem++;
				totalValue += i.value;
			}
		System.out.println("Item: " + item.name);
		System.out.println("Quantitie:" + countItem);
		System.out.println("Value:" + totalValue);
		}
	}
	
	public void showStock() {
		for(int i = 0; i < this.itemList.size(); i++) {
			System.out.println("Item: " + this.itemList.get(i) );
		}
	}
}
