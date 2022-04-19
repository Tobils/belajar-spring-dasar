package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.data.Bar;
import devtobil.belajarspringdasar.data.Foo;
import devtobil.belajarspringdasar.data.FooBar;

public class DependencyInjectionTest {

  private ApplicationContext applicationContext;

  @BeforeEach
  private void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
  }

  /**
   * test dependency injection secara manual
   */
  @Test
  public void manualDITest() {
    var foo = new Foo();
    var bar = new Bar();

    var foobar = new FooBar(foo, bar);
    Assertions.assertSame(foo, foobar.getFoo());
    Assertions.assertSame(bar, foobar.getBar());
  }

  /**
   * otomatis inject dependency dengan @Configuration dan @Bean pada method
   */
  @Test
  public void DITest() {
    Foo foo = applicationContext.getBean("fooSecond", Foo.class);
    Bar bar = applicationContext.getBean(Bar.class);
    FooBar fooBar = applicationContext.getBean(FooBar.class);

    Assertions.assertSame(foo, fooBar.getFoo());
    Assertions.assertSame(bar, fooBar.getBar());
  }
}
