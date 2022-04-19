
package devtobil.belajarspringdasar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.data.Bar;
import devtobil.belajarspringdasar.data.Foo;

public class ImportTest {

  private static ApplicationContext context;

  @BeforeEach
  public void setUp() {
    context = new AnnotationConfigApplicationContext(MainConfiguration.class);
  }

  @Test
  public void testImport() {
    Foo foo = context.getBean(Foo.class);
    Bar bar = context.getBean(Bar.class);
  }

}
