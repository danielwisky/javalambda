package br.com.javalambda;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.javalambda.domain.Pessoa;
import br.com.javalambda.template.PessoaTemplateLoader.Templates;
import br.com.six2six.fixturefactory.Fixture;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.InjectMocks;

public class Exercicio04Test extends TestSupport {

  @InjectMocks
  private Exercicio04 exercicio04;

  @Test
  public void deveSomarIdade() {

    final List<Pessoa> pessoas =
        Fixture.from(Pessoa.class).gimme(10, Templates.VALID.name());

    final int idadeSomada = exercicio04.somarIdade(pessoas);

    assertThat(idadeSomada)
        .isEqualTo(pessoas.stream().mapToInt(Pessoa::getIdade).sum());
  }

  @Test
  public void deveRetornarZeroQuandoListaPessoasVazia() {

    final int idadeSomada = exercicio04.somarIdade(new ArrayList<>());

    assertThat(idadeSomada)
        .isEqualTo(0);
  }
}