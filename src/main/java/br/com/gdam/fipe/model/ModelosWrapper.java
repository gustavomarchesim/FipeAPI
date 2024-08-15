package br.com.gdam.fipe.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelosWrapper {

  @JsonProperty("modelos")
  private List<Modelos> modelos;
  @JsonProperty("anos")
  private List<Anos> anos;

  public ModelosWrapper(List<Modelos> modelos, List<Anos> anos) {
    this.modelos = modelos;
    this.anos = anos;
  }

  public ModelosWrapper() {
  }

  public List<Modelos> getModelos() {
    return modelos;
  }

  public void setModelos(List<Modelos> modelos) {
    this.modelos = modelos;
  }

  public List<Anos> getAnos() {
    return anos;
  }

  public void setAnos(List<Anos> anos) {
    this.anos = anos;
  }

  @Override
  public String toString() {
    return "ModelosWrapper [modelos=" + modelos + ", anos=" + anos + "]\n";
  }

}
