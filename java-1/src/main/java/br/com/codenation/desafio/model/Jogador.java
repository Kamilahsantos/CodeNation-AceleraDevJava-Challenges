package br.com.codenation.desafio.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador extends Model {

  private Long idTime;
  private String nome;
  private LocalDate dataNascimento;
  private Integer nivelHabilidade;
  private BigDecimal salario;
  private boolean capitao;

  public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
    super();
    this.id = id;
    this.idTime = idTime;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.nivelHabilidade = nivelHabilidade;
    this.salario = salario;
  }

  public Long getIdTime() {
    return idTime;
  }

  public Jogador setIdTime(Long idTime) {
    this.idTime = idTime;
    return this;
  }

  public String getNome() {
    return nome;
  }

  public Jogador setNome(String nome) {
    this.nome = nome;
    return this;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public Jogador setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
    return this;
  }

  public Integer getNivelHabilidade() {
    return nivelHabilidade;
  }

  public Jogador setNivelHabilidade(Integer nivelHabilidade) {
    this.nivelHabilidade = nivelHabilidade;
    return this;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public Jogador setSalario(BigDecimal salario) {
    this.salario = salario;
    return this;
  }

  public boolean isCapitao() {
    return capitao;
  }

  public Jogador setCapitao(boolean capitao) {
    this.capitao = capitao;
    return this;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Jogador{");
    sb.append("id=").append(id);
    sb.append('}');
    return sb.toString();
  }

  @Override
  public int compareTo(Long o) {
    return o.compareTo(this.id);
  }
}
