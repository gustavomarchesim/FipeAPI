package br.com.gdam.fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Marcas {
  @JsonAlias("codigo")
  private String codigo;
  @JsonAlias("nome")
  private String nome;

  public Marcas(String codigo, String nome) {
    this.codigo = codigo;
    this.nome = nome;
  }

  public Marcas() {
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public String toString() {
    return "Marca: codigo " + codigo + ", nome: " + nome + "\n";
  }
}
