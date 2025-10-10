package br.edu.infnet.venda.domain.model;

public class Vendedor {

	public String nome;
	public double salario;
	double comissao = 0.2;
	
	public double calcularComissao() {
		return salario * (1 + comissao); 
	}
}
