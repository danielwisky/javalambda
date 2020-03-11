package br.com.javalambda;

import br.com.javalambda.domain.Pessoa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercicio06 {

  public Map<String, List<Pessoa>> agruparPessoasPorCidade(final List<Pessoa> pessoas) {

    final Map<String, List<Pessoa>> map = new HashMap<String, List<Pessoa>>();

    for (Pessoa pessoa : pessoas) {

      if (!map.containsKey(pessoa.getCidadeOndeEstaFalando())) {
        map.put(pessoa.getCidadeOndeEstaFalando(), new ArrayList<Pessoa>());
      }

      map.get(pessoa.getCidadeOndeEstaFalando()).add(pessoa);
    }

    return map;
  }
}