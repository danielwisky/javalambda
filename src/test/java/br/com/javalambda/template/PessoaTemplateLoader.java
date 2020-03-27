package br.com.javalambda.template;

import static br.com.javalambda.template.PessoaTemplateLoader.Templates.VALID;
import static br.com.javalambda.template.PessoaTemplateLoader.Templates.VALID_ASGARD;
import static br.com.javalambda.template.PessoaTemplateLoader.Templates.VALID_LAS_VEGAS;
import static br.com.javalambda.template.PessoaTemplateLoader.Templates.VALID_NOVA_IORQUE;

import br.com.javalambda.domain.Pessoa;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class PessoaTemplateLoader implements TemplateLoader {

  public enum Templates {
    VALID, VALID_NOVA_IORQUE, VALID_LAS_VEGAS, VALID_ASGARD
  }

  public void load() {
    Fixture.of(Pessoa.class).addTemplate(VALID.name(), new Rule() {{
      add("nome", random("Loki Laufeyson", "Tony Stark", "Peter Parker", "T'challa"));
      add("cidadeOndeEstaFalando", random("Nova Iorque", "Asgard", "Wakanda", "Las Vegas"));
      add("idade", random(Integer.class, range(20, 80)));
    }});

    Fixture.of(Pessoa.class).addTemplate(VALID_NOVA_IORQUE.name())
        .inherits(VALID.name(), new Rule() {{
          add("cidadeOndeEstaFalando", "Nova Iorque");
        }});

    Fixture.of(Pessoa.class).addTemplate(VALID_LAS_VEGAS.name())
        .inherits(VALID.name(), new Rule() {{
          add("cidadeOndeEstaFalando", "Las Vegas");
        }});

    Fixture.of(Pessoa.class).addTemplate(VALID_ASGARD.name())
        .inherits(VALID.name(), new Rule() {{
          add("cidadeOndeEstaFalando", "Asgard");
        }});
  }
}