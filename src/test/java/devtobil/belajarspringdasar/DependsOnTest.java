package devtobil.belajarspringdasar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.data.Foo;

public class DependsOnTest {

  private static ApplicationContext context;

  @BeforeEach
  public void setUp() {
    context = new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
  }

  /**
   * karena bean foo memiliki annotation @Lazy maka bean foo hanya akan dibuat
   * saat di akses
   */
  @Test
  public void testDependsOn() {
    Foo foo = context.getBean(Foo.class);
  }

}
