package br.com.javalambda;

import br.com.javalambda.domain.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class Exercicio03 {

  public List<Pessoa> filtrarPessoasPorCidade(final List<Pessoa> pessoas, final String cidade) {

    final List<Pessoa> pessoasPorCidade = new ArrayList<>();

    for (Pessoa pessoa : pessoas) {
      if (cidade.equalsIgnoreCase(pessoa.getCidadeOndeEstaFalando())) {
        pessoasPorCidade.add(pessoa);
      }
    }

    return pessoasPorCidade;
  }
}