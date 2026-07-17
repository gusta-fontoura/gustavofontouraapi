package br.edu.infnet.venda.domain.services;

import br.edu.infnet.venda.domain.model.Product;

public class ProductService {
	
	public Product createProduct(Product product) throws Exception {
		//ESSA CLASSE VAI SER USADA PARA VALIDAR ENTRADA DO PRODUTO NO BANCO...
		if (product.getValue() <= 0) throw new Exception("Preço inválido.");
		if (product.getName() == null) throw new Exception("Nome obrigatório.");
		
		
		return product;
	}
	
	public void applyDiscount(double discount, Product product) throws Exception {
		if (discount > 50.0) throw new Exception("Desconto excessivo.");
		
		product.setValue(product.getValue() * (discount/100));
		
	}
	
}
