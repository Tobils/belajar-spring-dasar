package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.data.Foo;

public class DuplicateConfigurationTest {

  @Test
  public void testDuplicate() {
    ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);

    /**
     * jika ditempatkan disini maka akan error
     */
    // Foo foo = context.getBean(Foo.class);

    Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
      Foo foo = context.getBean(Foo.class);
    });
  }

  /**
   * cara akses bean yang benar
   * dengan menambahkan naming pada bean yang di akses, meskipun mengakses object
   * yang sama tapi tidak akan duplicate
   */
  @Test
  public void getBean() {
    ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);

    Foo foo1 = context.getBean("foo1", Foo.class);
    Foo foo2 = context.getBean("foo2", Foo.class);

    Assertions.assertNotSame(foo1, foo2);
  }
}
