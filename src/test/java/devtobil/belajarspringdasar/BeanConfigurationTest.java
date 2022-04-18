package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.data.Foo;

public class BeanConfigurationTest {

  @Test
  public void testCreateBean() {
    ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigration.class);
    Assertions.assertNotNull(context);
  }

  @Test
  public void testGetBean() {
    ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigration.class);

    Foo foo1 = context.getBean(Foo.class);
    Foo foo2 = context.getBean(Foo.class);

    Assertions.assertSame(foo1, foo2);
  }

}
