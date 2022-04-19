package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.data.Bar;
import devtobil.belajarspringdasar.data.Foo;

public class ScopeTest {

  private static ApplicationContext context;

  @BeforeEach
  public void setUp() {
    context = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
  }

  /**
   * by default object foo adalah singleton jika tidak menggunakan scope prototype
   */
  @Test
  public void testScope() {
    Foo foo = context.getBean(Foo.class);
    Foo foo2 = context.getBean(Foo.class);
    Foo foo3 = context.getBean(Foo.class);

    Assertions.assertNotSame(foo, foo2);
    Assertions.assertNotSame(foo, foo3);
    Assertions.assertNotSame(foo2, foo3);
  }

  /**
   * Bar masuk ke dalam scope doubleton, dan hanya ada 2 object yg dizinkan untuk
   * dibuat
   */
  @Test
  public void testDoubletonScope() {
    Bar bar = context.getBean(Bar.class);
    Bar bar2 = context.getBean(Bar.class);
    Bar bar3 = context.getBean(Bar.class);
    Bar bar4 = context.getBean(Bar.class);

    Assertions.assertNotSame(bar, bar2);
    Assertions.assertSame(bar, bar3);
    Assertions.assertSame(bar2, bar4);
    Assertions.assertNotSame(bar3, bar4);

  }

}
