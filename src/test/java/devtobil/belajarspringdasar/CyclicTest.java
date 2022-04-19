package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CyclicTest {

  /**
   * spring akan memberikan error bahkan saat pembuatan aplication context
   */
  @Test
  public void testCyclic() {
    Assertions.assertThrows(Throwable.class, () -> {
      ApplicationContext context = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
    });
  }

}
