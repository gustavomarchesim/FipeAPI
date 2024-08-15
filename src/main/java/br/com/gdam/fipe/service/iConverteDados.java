package br.com.gdam.fipe.service;

import java.util.List;

public interface iConverteDados {
  <T> T obterDados(String json, Class<T> classe);

  <T> List<T> obterListaDados(String json, Class<T> classe);
}
