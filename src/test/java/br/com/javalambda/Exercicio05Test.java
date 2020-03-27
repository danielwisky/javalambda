package br.com.javalambda;

import static br.com.six2six.fixturefactory.Fixture.from;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.javalambda.domain.Pessoa;
import br.com.javalambda.template.PessoaTemplateLoader.Templates;
import java.util.ArrayList;
import org.junit.Test;
import org.mockito.InjectMocks;

public class Exercicio05Test extends TestSupport {

  @InjectMocks
  private Exercicio05 exercicio05;

  @Test
  public void deveContarMoradorNaCidade() {

    final Pessoa pessoaDeAsgard = from(Pessoa.class).gimme(Templates.VALID_ASGARD.name());

    final Pessoa pessoaDeLasVegas = from(Pessoa.class).gimme(Templates.VALID_LAS_VEGAS.name());

    final Pessoa pessoaDeNovaIorque = from(Pessoa.class).gimme(Templates.VALID_NOVA_IORQUE.name());

    final boolean contemMoradorNaCidade = exercicio05.contemMoradorNaCidade(
        asList(pessoaDeAsgard, pessoaDeLasVegas, pessoaDeNovaIorque),
        pessoaDeAsgard.getCidadeOndeEstaFalando()
    );

    assertThat(contemMoradorNaCidade)
        .isTrue();
  }

  @Test
  public void naoDeveConterMoradorNaCidade() {

    final Pessoa pessoaDeAsgard = from(Pessoa.class).gimme(Templates.VALID_ASGARD.name());

    final Pessoa pessoaDeLasVegas = from(Pessoa.class).gimme(Templates.VALID_LAS_VEGAS.name());

    final Pessoa pessoaDeNovaIorque = from(Pessoa.class).gimme(Templates.VALID_NOVA_IORQUE.name());

    final boolean contemMoradorNaCidade = exercicio05.contemMoradorNaCidade(
        asList(pessoaDeLasVegas, pessoaDeNovaIorque),
        pessoaDeAsgard.getCidadeOndeEstaFalando()
    );

    assertThat(contemMoradorNaCidade)
        .isFalse();
  }

  @Test
  public void naoDeveConterMoradorNaCidadeQuandoListaVazia() {

    final Pessoa pessoaDeAsgard = from(Pessoa.class).gimme(Templates.VALID_ASGARD.name());

    final boolean contemMoradorNaCidade = exercicio05.contemMoradorNaCidade(
        new ArrayList<>(), pessoaDeAsgard.getCidadeOndeEstaFalando());

    assertThat(contemMoradorNaCidade)
        .isFalse();
  }
}