package br.com.lucasdev.buscacep.modelo;

public record Endereco (
    String cep,
    String logradouro,
    String bairro,
    String localidade,
    String uf
) {}

