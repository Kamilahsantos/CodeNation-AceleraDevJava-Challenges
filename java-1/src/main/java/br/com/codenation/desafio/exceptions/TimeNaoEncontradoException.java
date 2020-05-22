package br.com.codenation.desafio.exceptions;

public class TimeNaoEncontradoException extends RuntimeException {

  public TimeNaoEncontradoException() {
    super("Time informado não foi encontrado.");
  }
}
