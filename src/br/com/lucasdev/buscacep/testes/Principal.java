package br.com.lucasdev.buscacep.testes;

import br.com.lucasdev.buscacep.modelo.Endereco;
import br.com.lucasdev.buscacep.util.BuscaCep;
import br.com.lucasdev.buscacep.util.GeradorDeArquivo;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o seu CEP: ");
        String cep = scanner.nextLine();

        try {
            BuscaCep busca = new BuscaCep();
            Endereco endereco = busca.consultaCep(cep);
            System.out.println(endereco);

            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.gerarArquivoJson(endereco);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
