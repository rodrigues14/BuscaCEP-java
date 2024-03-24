package br.com.lucasdev.buscacep.util;

import br.com.lucasdev.buscacep.modelo.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    public void gerarArquivoJson(Endereco endereco) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter writer = new FileWriter("endereco.json");
            writer.write(gson.toJson(endereco));
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
