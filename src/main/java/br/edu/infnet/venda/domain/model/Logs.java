package br.edu.infnet.venda.domain.model;

import java.time.LocalDateTime;


public class Logs {
	

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
    
    public String showLogFormatted() {
        return "[GERAL] " + getMensagem();
    }

    @Override
    public String toString() {
        return logDate + " - " + mensagem;
    }
}
	
