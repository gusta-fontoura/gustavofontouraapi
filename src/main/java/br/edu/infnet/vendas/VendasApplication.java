package br.edu.infnet.vendas;
import br.edu.infnet.venda.domain.model.*;
import br.edu.infnet.venda.domain.model.Menu;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
		
		Menu menu = new Menu();
		
		System.out.println("Aplicação iniciada!");
		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		menu.showMenu();
		while(true) {
			String menuOpt = in.next();
			switch (menuOpt) {
			case "1":
				
				System.out.println("Informe o nome do usuário: ");
				String name = in.next();
				
				System.out.println("Informe o senha do usuário: ");
				String password = in.next();
				
				while(password.length() < 8) {
					System.out.println("Senha precisa ter no mínimo 8 letras.");
					System.out.println("Informe o senha do usuário: ");
					password = in.next();
				}
				
				User gustavo = new User(name, password);
				gustavo.registerConfirmation();
				while(true) {
					menu.financeMenu();
					String menuOpt2 = in2.next();
					switch (menuOpt2) {
					case "1":
						System.out.println("Adicionando receita.. ");
						System.out.println("Quando deseja adicionar a conta: ");
						double income = in.nextDouble();
						gustavo.addIncome(income);
						gustavo.checkIncome();
					case "2":	
						System.out.println("Iniciando compra: ");
						System.out.println("Indique o item para comprar(nome): ");
						String nome = in.next();
						System.out.println("Indique o item para comprar(preço unitário): ");
						double unitPrice = in.nextDouble();
						System.out.println("Indique o item para comprar(quantidade): ");
						int quantity = in.nextInt();
						gustavo.Buy(nome, unitPrice, quantity);
						break;
					case "3":
						//gustavo.ShowFinanceLogs();
						System.out.println("TODO: implementar logs");
					case "0":
						in2.close();
						menu.showMenu();
						break;
					default:
						System.out.println("Opção inválida. Tente novamente.");
						menu.financeMenu();
						}
					}
			case "0":
				System.out.println("Saindo da aplicação...");
				in.close();
				break; 
			default:
				System.out.println("Opção inválida. Tente novamente.");
				menu.showMenu();
				}
			}
		}
	}