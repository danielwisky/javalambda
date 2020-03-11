package br.com.javalambda;

import br.com.javalambda.domain.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class Exercicio01 {

  public List<String> converterParaListaNomes(final List<Pessoa> pessoas) {

    final List<String> nomes = new ArrayList<String>();

    for (Pessoa pessoa : pessoas) {
      nomes.add(pessoa.getNome());
    }

    return nomes;
  }
}