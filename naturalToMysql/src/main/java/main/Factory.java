package main;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.localai.LocalAiChatModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factory {


    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Factory(){
        this.LigatLm();
        this.turnOnModel();

    }

    public String getPrompt( )  {
        // cria um objeto

        ChatLanguageModel model = LocalAiChatModel.builder()
                .baseUrl("http://localhost:1234/v1")
                .modelName("TheBloke/nsql-llama-2-7B-GGUF")
                .temperature(0.9)
                .build(); // defini o servidor, o nome do modelo, a qualidade da resposta

        String languageSql = model.generate(this.getContent()); //envia a entrada do usuário e o esquema do banco de dados do usuário para gerar o SQL
        return languageSql; // retorna o SQL
    }



    public void turnOnModel( ){
        String nameModel = "TheBloke/nsql-llama-2-7B-GGUF";
        String command = "cmd.exe /c lms load " + nameModel;
        // Criação do ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder();

        // Configura o comando a ser executado pelo ProcessBuilder
        processBuilder.command(command.split(" "));

        try {
            // Iniciar o processo
            Process process = processBuilder.start();

            // Capturar a saída do processo
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Lê e imprime cada linha da saída do processo
            while ((line = reader.readLine()) != null) {

            }

            // Esperar o término do processo e obter o código de saída
            int exitCode = process.waitFor();


        } catch (IOException | InterruptedException e) {
            // Captura e imprime exceções que possam ocorrer durante a execução do comando
            e.printStackTrace();

        }
    }



    public void turnOffModel(){

        String command = "cmd.exe /c lms unload --all " ;
        // Criação do ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder();

        // Configura o comando a ser executado pelo ProcessBuilder
        processBuilder.command(command.split(" "));

        try {
            // Iniciar o processo
            Process process = processBuilder.start();

            // Capturar a saída do processo
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Lê e imprime cada linha da saída do processo
            while ((line = reader.readLine()) != null) {

            }

            // Esperar o término do processo e obter o código de saída
            int exitCode = process.waitFor();


        } catch (IOException | InterruptedException e) {
            // Captura e imprime exceções que possam ocorrer durante a execução do comando
            e.printStackTrace();

        }

    }


    public void LigatLm(){

        // Comando a ser executado
        String command = "cmd.exe /c lms server start";

        // Criação do ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder();

        // Configura o comando a ser executado pelo ProcessBuilder
        processBuilder.command(command.split(" "));

        try {
            // Iniciar o processo
            Process process = processBuilder.start();

            // Capturar a saída do processo
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Lê e imprime cada linha da saída do processo
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar o término do processo e obter o código de saída
            int exitCode = process.waitFor();
            System.out.println("\nComando finalizado com código: " + exitCode);

        } catch (IOException | InterruptedException e) {
            // Captura e imprime exceções que possam ocorrer durante a execução do comando
            e.printStackTrace();
        }

    }



    public void desligarServidor(){
        // Comando a ser executado
        String command = "cmd.exe /c lms server stop";

        // Criação do ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder();

        // Configura o comando a ser executado pelo ProcessBuilder
        processBuilder.command(command.split(" "));

        try {
            // Iniciar o processo
            Process process = processBuilder.start();

            // Capturar a saída do processo
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Lê e imprime cada linha da saída do processo
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar o término do processo e obter o código de saída
            int exitCode = process.waitFor();
            System.out.println("\nComando finalizado com código: " + exitCode);

        } catch (IOException | InterruptedException e) {
            // Captura e imprime exceções que possam ocorrer durante a execução do comando
            e.printStackTrace();
        }

    }




}
