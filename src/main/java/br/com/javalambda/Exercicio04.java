package br.com.javalambda;

import br.com.javalambda.domain.Pessoa;
import java.util.List;

public class Exercicio04 {

  public int somarIdade(final List<Pessoa> pessoas) {

    int soma = 0;

    for (Pessoa pessoa : pessoas) {
      soma = soma + pessoa.getIdade();
    }

    return soma;
  }
}