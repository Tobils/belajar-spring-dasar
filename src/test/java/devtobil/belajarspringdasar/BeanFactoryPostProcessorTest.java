package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devtobil.belajarspringdasar.data.Foo;
import devtobil.belajarspringdasar.processor.FooBeanFactoryPostProcessor;

public class BeanFactoryPostProcessorTest {

  @Configuration
  @Import({
      FooBeanFactoryPostProcessor.class
  })
  private static class TestConfiguration {
  }

  private static ConfigurableApplicationContext applicationContext;

  @BeforeEach
  public void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
    applicationContext.registerShutdownHook();
  }

  @Test
  public void testBeanPostProcessor() {
    Foo foo = applicationContext.getBean(Foo.class);
    Assertions.assertNotNull(foo);
  }

}
