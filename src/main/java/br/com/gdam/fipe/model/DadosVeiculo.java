package br.com.gdam.fipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosVeiculo {

  @JsonProperty("Valor")
  private String valor;
  @JsonProperty("Marca")
  private String marca;
  @JsonProperty("Modelo")
  private String modelo;
  @JsonProperty("AnoModelo")
  private Integer anoModelo;
  @JsonProperty("Combustivel")
  private String combustivel;

  public DadosVeiculo() {
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public Integer getAnoModelo() {
    return anoModelo;
  }

  public void setAnoModelo(Integer anoModelo) {
    this.anoModelo = anoModelo;
  }

  public String getCombustivel() {
    return combustivel;
  }

  public void setCombustivel(String combustivel) {
    this.combustivel = combustivel;
  }

  @Override
  public String toString() {
    return "Veiculo: " + "valor=" + valor + ", marca=" + marca + ", modelo=" + modelo
        + ", ano=" + anoModelo + ", combustivel=" + combustivel;
  }

}
