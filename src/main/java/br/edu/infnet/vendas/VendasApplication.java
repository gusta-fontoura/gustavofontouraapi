package br.edu.infnet.vendas;
import br.edu.infnet.venda.domain.model.*;
import br.edu.infnet.vendas.domain.services.UserService;

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
		String emailValido = "";
		
		if(password.length() < 8) {
			System.out.println("Senha precisa ter no mínimo 8 letras.");
		}
		
		System.out.println("Informe o e-mail do usuário: ");
		
		String email = in.next();
		int atIdx = email.indexOf("@");
		int dotComIdx = email.indexOf(".com");
		
		if(!email.contains("@") || !email.contains(".") && !email.contentEquals(".com")) {
			System.out.println("Email não é válido.");
		}else if(atIdx == 0) {
			System.out.println("Email não é válido: não contém letras antes do @");
		}
		else if(atIdx > dotComIdx) {
			System.out.println("Email não é válido: @ deve vim antes do .com ");
		}else if (dotComIdx == 1 + atIdx) {
			System.out.println("Email não é válido: deve conter elementos entre @ e .com");
		}
		else {
			System.out.println("Email válido.");
			emailValido = email;
		}
		
		System.out.println("Informe o local do usuário: ");
		String location = in.next();
	
		User gustavo = new User(1, name, password, emailValido, location);
		gustavo.registerConfirmation();
		
		in.close();
		
		// demonstração da classe servico do usuario
		
		UserService servico = new UserService();
		
		servico.createUser(gustavo);
		servico.getUserProfile(1);
		
	}
}