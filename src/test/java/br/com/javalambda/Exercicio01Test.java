package br.com.javalambda;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.javalambda.domain.Pessoa;
import br.com.javalambda.template.PessoaTemplateLoader.Templates;
import br.com.six2six.fixturefactory.Fixture;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.InjectMocks;

public class Exercicio01Test extends TestSupport {

  @InjectMocks
  private Exercicio01 exercicio01;

  @Test
  public void deveConverterParaListaNomes() {

    final List<Pessoa> pessoas =
        Fixture.from(Pessoa.class).gimme(10, Templates.VALID.name());

    final List<String> nomes = exercicio01.converterParaListaNomes(pessoas);

    assertThat(nomes)
        .isNotEmpty();

    assertThat(nomes)
        .containsAll(pessoas.stream().map(Pessoa::getNome).collect(toList()));
  }

  @Test
  public void deveConverterParaListaVaziaNomes() {

    final List<String> nomes = exercicio01.converterParaListaNomes(new ArrayList<>());

    assertThat(nomes)
        .isEmpty();
  }

  @Test(expected = NullPointerException.class)
  public void deveDarErroAoConverterListaNula() {
    exercicio01.converterParaListaNomes(null);
  }
}