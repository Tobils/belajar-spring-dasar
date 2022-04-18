package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

  @Test
  void testlicationContext() {
    ApplicationContext context = new AnnotationConfigApplicationContext(HelloworldConfigration.class);
    Assertions.assertNotNull(context);
  }
}
