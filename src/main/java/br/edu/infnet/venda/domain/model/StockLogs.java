package br.edu.infnet.venda.domain.model;

public class StockLogs extends Logs {
	private int ordemId;
    private String nomeProduto;
    private int quantidade;
    private String operacao; // "COMPRA" ou "VENDA"

    public StockLogs(String mensagem, int ordemId, String nomeProduto, int quantidade, String operacao) {
        super(mensagem);
        this.ordemId = ordemId;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.operacao = operacao;  
    }
    
    
    @Override
    public String showLogFormatted() {
        return "[Stock] " + getMensagem() + "| Nome: " + this.nomeProduto + "| ID: " + this.ordemId + "| Quntidade: " + quantidade;
    }

    @Override
    public String toString() {
        return super.toString() + " | Ordem #" + ordemId + " | Item: " + nomeProduto + " (" + quantidade + " un.) - " + operacao;
    }
}
