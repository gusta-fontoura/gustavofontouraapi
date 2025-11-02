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
		Menu menu = new Menu();
		
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
				String emailValido = "";
				
				if(password.length() < 8) {
					System.out.println("Senha precisa ter no mínimo 8 letras.");
					System.out.println("Aplicação encerrada.");
					break;
				}
				
				System.out.println("Informe o e-mail do usuário: ");
				
				String email = in.next();
				int atIdx = email.indexOf("@");
				int dotComIdx = email.indexOf(".com");
				
				
				if(!email.contains("@") || !email.contains(".") && !email.contentEquals(".com")) {
					System.out.println("Email não é válido.");
					System.out.println("Aplicação encerrada.");
					break;
				}else if(atIdx == 0) {
					System.out.println("Email não é válido: não contém letras antes do @");
					System.out.println("Aplicação encerrada.");
					break;
				}
				else if(atIdx > dotComIdx) {
					System.out.println("Email não é válido: @ deve vim antes do .com ");
					System.out.println("Aplicação encerrada.");
					break;
				}else if (dotComIdx == 1 + atIdx) {
					System.out.println("Email não é válido: deve conter elementos entre @ e .com");
					System.out.println("Aplicação encerrada.");
					break;
				}
				else {
					System.out.println("Email válido.");
					emailValido = email;
				}
				
				System.out.println("Informe o local do usuário: ");
				String location = in.next();
				
				User gustavo = new User(1, name, password, emailValido, location);
				gustavo.registerConfirmation();
			case "0":
				System.out.println("Saindo da aplicação...");
				break; 
			default:
				System.out.println("Opção inválida. Tente novamente.");
				menu.showMenu();
			
		}
			
		in.close();
	
		// demonstração da classe servico do usuario
		
		//UserService servico = new UserService();
		
		//servico.createUser(gustavo);
		//System.out.println(servico.getUserProfile(1));
		
	}
	}
	}