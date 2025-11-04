package br.edu.infnet.vendas;
import br.edu.infnet.venda.domain.model.*;
import br.edu.infnet.vendas.domain.services.UserService;
import br.edu.infnet.venda.domain.model.Menu;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
		
		/*Menu menu = new Menu();
		
		System.out.println("Aplicação iniciada!");
		Scanner in = new Scanner(System.in);
		menu.showMenu();
		while(true) {
			String menuOpt = in.next();
			switch (menuOpt) {
			case "1":
				
				System.out.println("Informe o nome do usuário: ");
				String name = in.next();
				
				System.out.println("Informe o senha do usuário: ");
				String password = in.next();
				
				if(password.length() < 8) {
					System.out.println("Senha precisa ter no mínimo 8 letras.");
					System.out.println("Aplicação encerrada.");
					break;
				}
				
				User gustavo = new User(1, name, password);
				gustavo.registerConfirmation();
			case "0":
				System.out.println("Saindo da aplicação...");
				break; 
			default:
				System.out.println("Opção inválida. Tente novamente.");
				menu.showMenu();
			
		}
			
		in.close();
		*/
		
		
		
		
	
		// demonstração da classe servico do usuario
		
		//UserService servico = new UserService();
		
		//servico.createUser(gustavo);
		//System.out.println(servico.getUserProfile(1));
		
	}
	}
	