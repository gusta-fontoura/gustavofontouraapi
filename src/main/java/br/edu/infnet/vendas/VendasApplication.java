package br.edu.infnet.vendas;
import br.edu.infnet.venda.domain.model.*;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class VendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
		
		Scanner in = new Scanner(System.in);
		
		
		System.out.println("Informe o nome do usuário: ");
		String name = in.next();
		System.out.println("Informe o senha do usuário: ");
		String password = in.next();
		System.out.println("Informe o e-mail do usuário: ");
		String email = in.next();
		System.out.println("Informe o local do usuário: ");
		String location = in.next();
	
		User gustavo = new User(1, name, password, email, location);
		gustavo.registerConfirmation();
		
		in.close();
	}

}