package br.com.javalambda;

import br.com.javalambda.domain.Pessoa;
import java.util.List;

public class Exercicio05 {

  public boolean contemMoradorNaCidade(final List<Pessoa> pessoas, final String cidade) {

    boolean achou = false;

    for (Pessoa pessoa : pessoas) {
      if (cidade.equalsIgnoreCase(pessoa.getCidadeOndeEstaFalando())) {
        achou = true;
        break;
      }
    }

    return achou;
  }
}