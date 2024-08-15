package br.com.gdam.fipe.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.gdam.fipe.model.AnosModelo;
import br.com.gdam.fipe.model.DadosVeiculo;
import br.com.gdam.fipe.model.Marcas;
import br.com.gdam.fipe.model.ModelosWrapper;
import br.com.gdam.fipe.service.ConsumoApi;
import br.com.gdam.fipe.service.ConverteDados;

public class Main {
  Scanner sc = new Scanner(System.in);

  private ConsumoApi consumoApi = new ConsumoApi();
  private ConverteDados converte = new ConverteDados();

  private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1";

  public void Menu() {

    System.out.println("Escolha uma das opções para consulta");
    System.out.println("1. Carro");
    System.out.println("2. Moto");
    System.out.println("3. Caminhão");
    System.out.println("0. Sair");
    System.out.print("Digite uma opção: ");
    var opcao = sc.nextInt();
    sc.nextLine();

    String tipoVeiculo = null;

    switch (opcao) {
      case 1:
        tipoVeiculo = "carros";
        break;
      case 2:
        tipoVeiculo = "motos";
        break;
      case 3:
        tipoVeiculo = "caminhoes";
        break;
      case 0:
        System.out.println("Saindo...");
        return;
      default:
        System.out.println("Opção inválida.");
        return;
    }

    String json = consumoApi.obterDados(ENDERECO + "/" + tipoVeiculo + "/marcas");
    List<Marcas> marcas = converte.obterListaDados(json, Marcas.class);

    if (json != null) {
      marcas.forEach(System.out::println);
      System.out.println();
      System.out.print("Informe o código da marca para consulta: ");
      var codigoMarca = sc.nextLine();

      json = consumoApi.obterDados(ENDERECO + "/" + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos");

      try {
        ModelosWrapper wrapper = converte.obterDados(json, ModelosWrapper.class);
        var modelos = wrapper.getModelos();
        modelos.forEach(System.out::println);

        System.out.print("Insira o código do modelo para consulta de valores: ");
        var codigoModelo = sc.nextInt();

        json = consumoApi
            .obterDados(ENDERECO + "/" + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos");
        List<AnosModelo> anosModelos = converte.obterListaDados(json, AnosModelo.class);
        List<DadosVeiculo> todosDadosVeiculos = new ArrayList<>();

        for (AnosModelo anosModelo : anosModelos) {
          var codigoAnoModelo = anosModelo.getCodigo();
          json = consumoApi.obterDados(ENDERECO + "/" + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/"
              + codigoModelo + "/anos/" + codigoAnoModelo);
          DadosVeiculo dadosVeiculo = converte.obterDados(json, DadosVeiculo.class);
          todosDadosVeiculos.add(dadosVeiculo);
        }

        System.out.println("Todos os veículos com os valores por ano: ");
        todosDadosVeiculos.forEach(System.out::println);
      } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
      }
    }
  }
}
