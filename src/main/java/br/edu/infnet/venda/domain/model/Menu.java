package br.edu.infnet.venda.domain.model;

public class Menu {
	
	
	public void showMenu(){
		System.out.println("+---------------------------------+");
		System.out.println("|         MENU DE USUÁRIOS        |");
		System.out.println("+---------------------------------+");
		System.out.println("| 1 - Criar usuário               |");
		System.out.println("| 0 - Sair                        |");
		System.out.println("+---------------------------------+");
		System.out.print("Digite sua opção: ");
	}
	
	
	public void financeMenu() { 
		System.out.println("+---------------------------------+");
		System.out.println("|         MENU DE FINANÇAS        |");
		System.out.println("+---------------------------------+");
		System.out.println("| 1 - Adicionar receita           |");
		System.out.println("| 2 - Comprar item                |");
		System.out.println("| 3 - Vender item                 |");
		System.out.println("| 4 - Mostrar log                 |");
		System.out.println("| 5 - Relatórios                  |");
		System.out.println("| 6 - Gerar Relatórios            |");
		System.out.println("| 0 - Voltar                      |");
		System.out.println("+---------------------------------+");
		System.out.print("Digite sua opção: ");
	}

}

