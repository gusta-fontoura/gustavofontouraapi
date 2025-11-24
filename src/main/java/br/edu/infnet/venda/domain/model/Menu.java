package br.edu.infnet.venda.domain.model;

public class Menu {
	
	//TODO: pensando em cirar cada modolo diferente aqui: Finance, Logistic, Human resource
	
	public void showMenu(){
		System.out.println("+---------------------------------+");
		System.out.println("|         MENU DE USUÁRIOS        |");
		System.out.println("+---------------------------------+");
		System.out.println("| 1 - Criar usuário               |");
		System.out.println("| 0 - Sair                        |");
		System.out.println("+---------------------------------+");
		System.out.print("Digite sua opção: ");
	}
	
	
	public void financeMenu() { // talvez nao seja mais necessario.
		System.out.println("+---------------------------------+");
		System.out.println("|         MENU DE FINANÇAS        |");
		System.out.println("+---------------------------------+");
		System.out.println("| 1 - Adicionar receita           |");
		System.out.println("| 2 - Comprar item                |");
		System.out.println("| 3 - Mostrar logs de finanças    |");
		System.out.println("| 0 - Voltar                      |");
		System.out.println("+---------------------------------+");
		System.out.print("Digite sua opção: ");
	}

}

