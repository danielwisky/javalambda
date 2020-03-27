package br.com.javalambda;

import static br.com.six2six.fixturefactory.Fixture.from;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.javalambda.domain.Pessoa;
import br.com.javalambda.template.PessoaTemplateLoader.Templates;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.mockito.InjectMocks;

public class Exercicio06Test extends TestSupport {

  @InjectMocks
  private Exercicio06 exercicio06;

  @Test
  public void deveAgruparPessoasPorCidade() {

    final Pessoa pessoaDeAsgard = from(Pessoa.class).gimme(Templates.VALID_ASGARD.name());

    final Pessoa pessoaDeLasVegas = from(Pessoa.class).gimme(Templates.VALID_LAS_VEGAS.name());

    final Map<String, List<Pessoa>> mapaPessoasPorCidade =
        exercicio06.agruparPessoasPorCidade(asList(pessoaDeAsgard));

    assertThat(mapaPessoasPorCidade)
        .isNotNull();

    assertThat(mapaPessoasPorCidade.size())
        .isEqualTo(1);

    assertThat(mapaPessoasPorCidade.get(pessoaDeAsgard.getCidadeOndeEstaFalando()).size())
        .isEqualTo(1);

    assertThat(mapaPessoasPorCidade.get(pessoaDeAsgard.getCidadeOndeEstaFalando()).get(0))
        .isEqualTo(pessoaDeAsgard);

    assertThat(mapaPessoasPorCidade.get(pessoaDeLasVegas.getCidadeOndeEstaFalando()))
        .isNull();
  }

  @Test
  public void deveRetornarUmMapaVazioQuandoListaPessoasVazia() {

    final Map<String, List<Pessoa>> mapaPessoasPorCidade = exercicio06.agruparPessoasPorCidade(
        new ArrayList<>());

    assertThat(mapaPessoasPorCidade)
        .isNotNull();

    assertThat(mapaPessoasPorCidade.size())
        .isEqualTo(0);
  }
}