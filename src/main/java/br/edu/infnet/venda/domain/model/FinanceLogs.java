package br.edu.infnet.venda.domain.model;

public class FinanceLogs extends Logs {
	private double value;
    private String type; // "ENTRADA" ou "SAIDA"

    public FinanceLogs(String mensagem, double value, String type) {
        super(mensagem);
        this.value = value;
        this.type = type;
    }


    @Override
    public String toString() {
        return super.toString() + " | Tipo: " + type + " | Valor: R$ " + String.format("%.2f", value);
    }
    
    @Override
    public String showLogFormatted() {
        return "[Finance] " + getMensagem() + "| Valor: " + this.value;
    }

}
