package br.com.javalambda;

import static br.com.six2six.fixturefactory.Fixture.from;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.javalambda.domain.Pessoa;
import br.com.javalambda.template.PessoaTemplateLoader.Templates;
import java.util.List;
import org.junit.Test;
import org.mockito.InjectMocks;

public class Exercicio03Test extends TestSupport {

  @InjectMocks
  private Exercicio03 exercicio03;

  @Test
  public void deveFiltrarPessoasPorCidade() {

    final Pessoa pessoaDeAsgard = from(Pessoa.class).gimme(Templates.VALID_ASGARD.name());

    final Pessoa pessoaDeLasVegas = from(Pessoa.class).gimme(Templates.VALID_LAS_VEGAS.name());

    final Pessoa pessoaDeNovaIorque = from(Pessoa.class).gimme(Templates.VALID_NOVA_IORQUE.name());

    final List<Pessoa> pessoasPorCidade = exercicio03
        .filtrarPessoasPorCidade(
            asList(pessoaDeAsgard, pessoaDeLasVegas, pessoaDeNovaIorque),
            pessoaDeAsgard.getCidadeOndeEstaFalando()
        );

    assertThat(pessoasPorCidade.size())
        .isEqualTo(1);

    assertThat(pessoasPorCidade.get(0))
        .isEqualTo(pessoaDeAsgard);
  }

  @Test
  public void deveRetornarUmaListaVaziaQuandoCidadeNaoEncontrada() {

    final List<Pessoa> pessoas =
        from(Pessoa.class).gimme(10, Templates.VALID.name());

    final List<Pessoa> pessoasPorCidade =
        exercicio03.filtrarPessoasPorCidade(pessoas, "nao encontrada.");

    assertThat(pessoasPorCidade)
        .isEmpty();
  }
}