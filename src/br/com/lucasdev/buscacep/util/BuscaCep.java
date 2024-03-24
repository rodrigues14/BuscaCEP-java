package br.com.lucasdev.buscacep.util;

import br.com.lucasdev.buscacep.exception.ErroConsultaViaApiException;
import br.com.lucasdev.buscacep.modelo.Endereco;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCep {

    public Endereco consultaCep(String cep) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 400) {
                throw new ErroConsultaViaApiException("CEP inválido.");
            }

            String json = response.body();
            Gson gson = new Gson();

            return gson.fromJson(json, Endereco.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
