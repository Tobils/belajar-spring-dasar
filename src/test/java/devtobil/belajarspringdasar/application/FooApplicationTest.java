package devtobil.belajarspringdasar.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import devtobil.belajarspringdasar.application.FooApplication;
import devtobil.belajarspringdasar.data.Foo;

@SpringBootTest(classes = FooApplication.class)
public class FooApplicationTest {

  /**
   * ambil bean secara otomatis tidak perlu manual dengan application context
   */
  @Autowired
  Foo foo;

  @Test
  public void testFoo() {
    Assertions.assertNotNull(foo);
  }

}
