package br.com.javalambda;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public abstract class TestSupport {

  @BeforeClass
  public static synchronized void setup() {
    FixtureFactoryLoader.loadTemplates("br.com.javalambda.template");
  }
}