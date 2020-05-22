package br.com.codenation.desafio.exceptions;

public class CapitaoNaoInformadoException extends RuntimeException {

  public CapitaoNaoInformadoException() {
    super("Informacoes do capitao nao foram informadass");
  }
}
