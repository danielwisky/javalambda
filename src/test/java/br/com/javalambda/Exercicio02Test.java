package br.com.javalambda;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.javalambda.domain.Pessoa;
import br.com.javalambda.template.PessoaTemplateLoader.Templates;
import br.com.six2six.fixturefactory.Fixture;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.mockito.InjectMocks;

public class Exercicio02Test extends TestSupport {

  @InjectMocks
  private Exercicio02 exercicio02;

  @Test
  public void deveConcatenarListaNomes() {

    final List<Pessoa> pessoas =
        Fixture.from(Pessoa.class).gimme(10, Templates.VALID.name());

    final String nomesConcatenados = exercicio02.concatenarListaNomes(pessoas);

    assertThat(nomesConcatenados)
        .isEqualTo(pessoas.stream().map(Pessoa::getNome).collect(Collectors.joining(", ")));
  }

  @Test
  public void deveConcatenarListaVaziaNomes() {

    final String nomesConcatenados = exercicio02.concatenarListaNomes(new ArrayList<>());

    assertThat(nomesConcatenados)
        .isEqualTo("");
  }
}