package br.edu.infnet.vendas.domain.infrastructure;

import br.edu.infnet.venda.domain.model.Logs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LogRepository {

    private static final String ARQUIVO_LOGS = "historico_sistema.txt";

    public void saveLogs(List<Logs> listaLogs) {
        BufferedWriter writer = null;

        try {
           
            writer = new BufferedWriter(new FileWriter(ARQUIVO_LOGS, true));

            for (Logs log : listaLogs) {
               
                writer.write(log.showLogFormatted());
                writer.newLine(); 
            }
            
            System.out.println("Logs salvos com sucesso no arquivo!");

        } catch (IOException e) {
            System.err.println("Falha ao escrever no arquivo: " + e.getMessage());
        
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Erro ao fechar o arquivo: " + e.getMessage());
            }
        }
    }
    
    public void ReadLogsFromFile() {
        System.out.println("-- LENDO HISTÓRICO DO ARQUIVO --");
        
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(ARQUIVO_LOGS));
            String linha;

            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nenhum histórico anterior encontrado. Criando um novo arquivo...");
        
        } catch (IOException e) {
            System.err.println("Erro de leitura: " + e.getMessage());
        
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void saveLogsToFile(String fileName, List<Logs> logs) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            
            writer.write("--- RELATÓRIO DO SISTEMA ---");
            writer.newLine();
            
            if (logs.isEmpty()) {
                writer.write("Nenhum registro encontrado.");
            } else {
                for (Logs log : logs) {
                    writer.write(log.showLogFormatted());
                    writer.newLine();
                }
            }
         
            System.out.println("Relatório gerado com sucesso: " + fileName);

        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo de log: " + e.getMessage());
        }
    }
   
}