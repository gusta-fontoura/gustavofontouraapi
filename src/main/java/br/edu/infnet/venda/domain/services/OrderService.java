package br.edu.infnet.venda.domain.services;

import br.edu.infnet.venda.domain.model.SellOrder;
import br.edu.infnet.venda.domain.model.Product;

public class OrderService {
	
	public void createSellOrder(Product product, int quantity) {
		new SellOrder(product, quantity);
	}
	
public SellOrder processSellOrder(Product product, int quantity, StockService stockService) {
        
        if (!stockService.isAvailable(product, quantity)) {
            System.out.println("Erro: Produto não encontrado ou estoque insuficiente.");
            return null;
        }
        stockService.decreaseStock(product, quantity);
        
        SellOrder order = new SellOrder(product, quantity);
        System.out.println("Produto retirado do estoque - venda completa...");
        
        return order; 
    }
}
