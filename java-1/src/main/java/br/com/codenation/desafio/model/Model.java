package br.com.codenation.desafio.model;

import java.util.Objects;

public abstract class Model implements Comparable<Long> {
  protected Long id;

  public Long getId() {
    return id;
  }

  public Model setId(Long id) {
    this.id = id;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Model)) return false;
    Model model = (Model) o;
    return id.equals(model.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
