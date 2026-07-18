package br.edu.infnet.venda.domain.services;

import br.edu.infnet.venda.domain.model.Product;
import br.edu.infnet.venda.domain.model.Stock;

public class StockService {
	
	private Stock stock;
	
	public StockService() {
		this.stock = new Stock();
	}
	
	public Product getProduct(Product product) {
	    for(Product p : stock.getProducts()) {
	        if(p.getId().equals(product.getId())) {
	            return p;
	        }
	    }
	    return null; 
	}
	
	public void addProduct(Product product) {
		if (product != null) {
			stock.getProducts().add(product);
			System.out.println("Produto '" + product.getName() + "' adicionado com sucesso.");
		}
		
	}
	
	public void removeProduct(String id) {
		if (id != null) {
			for(Product p : stock.getProducts()) {
				if(p.getId() == id) {
					stock.getProducts().remove(stock.getProducts().indexOf(p));
					System.out.println("Produto '"+ p.getName() + "' removido com sucesso");
					break;
				}
			}
			System.out.println("Produto não encontrado.");		}
	}
	
	public boolean isAvailable(Product product, int quantity) {
		if (!(this.checkProduct(product) && quantity >= product.getQuantity())){
			System.out.println("Erro: Produto não encontrado ou estoque insuficiente.");
			return false;
		}
		return true;
	}
	
	public void decreaseStock(Product product, int quantity) {
		if(this.isAvailable(product, quantity)) {
			product.setQuantity(product.getQuantity() - quantity);
			System.out.println("Quantidade: " + quantity+" saiu do estoque.");
		}
	}
	
	public boolean checkProduct(Product product) {
		if(stock.getProducts().contains(product)) {
			System.out.println("Item is not in stockpile!");
			return true;
		}
		System.out.println("Item is not in stockpile");
		return false;
	}
	
	protected void showProduct(Product product) {
		if (this.checkProduct(product)) {
            System.out.println("Resumo do Item: " + product.getName() + 
                               " | Quantidade: " + product.getQuantity() + 
                               " | Valor Unitário: R$ " + product.getValue());
        } else {
            System.out.println("Item não encontrado no estoque.");
        }
	}
	
	public void showStock() {
		System.out.println("--- Inventário Completo ---");
		for(int i = 0; i < stock.getProducts().size(); i++) {
			System.out.println("ID: " + stock.getProducts().get(i).getId() + "Item: " + stock.getProducts().get(i).getName() + "Valor: " + stock.getProducts().get(i).getValue());
		}
	}
}
