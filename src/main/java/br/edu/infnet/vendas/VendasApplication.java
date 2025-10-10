package br.edu.infnet.vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.edu.infnet.venda.domain.model.Vendedor;


@SpringBootApplication
public class VendasApplication {

	public static void main(String[] args) {
		//SpringApplication.run(VendasApplication.class, args);
		
		Vendedor gustavo = new Vendedor();
		
		gustavo.nome = "Gustavo";
		gustavo.salario = 3000.00;
		System.out.println("Salário com a comissão:  " + gustavo.calcularComissao());
	}

}
