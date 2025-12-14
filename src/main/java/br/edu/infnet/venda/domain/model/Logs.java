package br.edu.infnet.venda.domain.model;

import java.time.LocalDateTime;


public abstract class Logs {
	

    private LocalDateTime logDate; 
    private String mensagem;


    public Logs(String mensagem) {
        this.logDate = LocalDateTime.now(); 
        this.mensagem = mensagem;
    }

   
    public LocalDateTime getLogDate() {
        return logDate;
    }

    public String getMensagem() {
        return mensagem;
    }
    
    public abstract String showLogFormatted();
    
    @Override
    public String toString() {
        return logDate + " - " + mensagem;
    }
}
	
