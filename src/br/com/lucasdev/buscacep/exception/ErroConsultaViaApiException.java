package br.com.lucasdev.buscacep.exception;

public class ErroConsultaViaApiException extends RuntimeException {
    public ErroConsultaViaApiException(String mensagem) {
        super(mensagem);
    }
}
