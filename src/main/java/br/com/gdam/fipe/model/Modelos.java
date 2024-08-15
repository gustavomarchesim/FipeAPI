package br.com.gdam.fipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Modelos {
  @JsonProperty("codigo")
  private int codigo;
  @JsonProperty("nome")
  private String nome;

  public Modelos() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
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
    return "Modelo, " + nome + ", código: " + codigo + "\n";
  }

}
