package br.com.codenation.desafio.model;

import java.time.LocalDate;
import java.util.Objects;

public class Time extends Model {

  private String nome;
  private LocalDate dataCriacao;
  private String corUniformePrincipal;
  private String corUniformeSecundario;

  public Time() {
  }

  public Time(Long id) {
    this.id = id;
  }

  public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
    this.id = id;
    this.nome = nome;
    this.dataCriacao = dataCriacao;
    this.corUniformePrincipal = corUniformePrincipal;
    this.corUniformeSecundario = corUniformeSecundario;
  }

  public String getNome() {
    return nome;
  }

  public Time setNome(String nome) {
    this.nome = nome;
    return this;
  }

  public LocalDate getDataCriacao() {
    return dataCriacao;
  }

  public Time setDataCriacao(LocalDate dataCriacao) {
    this.dataCriacao = dataCriacao;
    return this;
  }

  public String getCorUniformePrincipal() {
    return corUniformePrincipal;
  }

  public Time setCorUniformePrincipal(String corUniformePrincipal) {
    this.corUniformePrincipal = corUniformePrincipal;
    return this;
  }

  public String getCorUniformeSecundario() {
    return corUniformeSecundario;
  }

  public Time setCorUniformeSecundario(String corUniformeSecundario) {
    this.corUniformeSecundario = corUniformeSecundario;
    return this;
  }

  @Override
  public int compareTo(Long o) {
    return o.compareTo(this.id);
  }
}
