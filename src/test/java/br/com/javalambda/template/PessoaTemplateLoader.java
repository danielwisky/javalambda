package br.com.javalambda.template;

import static br.com.javalambda.template.PessoaTemplateLoader.Templates.VALID;

import br.com.javalambda.domain.Pessoa;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

public class PessoaTemplateLoader implements TemplateLoader {

  public enum Templates {
    VALID
  }

  public void load() {
    Fixture.of(Pessoa.class).addTemplate(VALID.name(), new Rule() {{
      add("nome", random("Loki Laufeyson", "Tony Stark", "Peter Parker", "T'challa"));
      add("cidadeOndeEstaFalando", random("Nova Iorque", "Asgard", "Wakanda", "Las Vegas"));
      add("idade", random(Integer.class, range(20, 80)));
    }});
  }
}