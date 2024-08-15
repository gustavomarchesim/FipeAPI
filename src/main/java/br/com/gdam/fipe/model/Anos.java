package br.com.gdam.fipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Anos {
  @JsonProperty("codigo")
  private String codigo;
  @JsonProperty("nome")
  private String nome;

  public Anos() {
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
    return "Anos [codigo=" + codigo + ", nome=" + nome + "]\n";
  }

}
