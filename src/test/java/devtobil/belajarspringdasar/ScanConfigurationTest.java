package devtobil.belajarspringdasar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.data.Bar;
import devtobil.belajarspringdasar.data.Foo;

public class ScanConfigurationTest {

  private static ConfigurableApplicationContext context;

  @BeforeEach
  public void setUp() {
    context = new AnnotationConfigApplicationContext(ScanConfiguration.class);
    context.registerShutdownHook();
  }

  /**
   * @ComponentScan test
   */
  @Test
  public void testScan() {
    Foo foo = context.getBean(Foo.class);
    Bar bar = context.getBean(Bar.class);
  }

}
