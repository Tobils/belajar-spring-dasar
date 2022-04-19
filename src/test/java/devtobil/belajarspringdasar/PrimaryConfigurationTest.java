package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.data.Foo;

public class PrimaryConfigurationTest {

  private ApplicationContext applicationContext;

  @BeforeEach
  public void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(PrimaryConfiguration.class);
  }

  @Test
  public void getBean() {
    Foo foo = applicationContext.getBean(Foo.class);
    Foo foo1 = applicationContext.getBean("fooFirst", Foo.class);
    Foo foo2 = applicationContext.getBean("fooSecond", Foo.class);

    Assertions.assertSame(foo, foo1);
    Assertions.assertNotSame(foo, foo2);
    Assertions.assertNotSame(foo1, foo2);
  }

}
