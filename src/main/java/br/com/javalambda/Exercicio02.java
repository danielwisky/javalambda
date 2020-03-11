package br.com.javalambda;

import br.com.javalambda.domain.Pessoa;
import java.util.List;

public class Exercicio02 {

  public String concatenarListaNomes(final List<Pessoa> pessoas) {

    final StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < pessoas.size(); i++) {
      if (i > 0) {
        stringBuilder.append(", ");
      }
      stringBuilder.append(pessoas.get(i).getNome());
    }

    return stringBuilder.toString();
  }
}