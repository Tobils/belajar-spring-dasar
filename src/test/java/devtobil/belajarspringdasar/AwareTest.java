package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devtobil.belajarspringdasar.service.AuthService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AwareTest {

  @Configuration
  @Import({
      AuthService.class
  })
  public static class TestConfiiguration {
  }

  private static ConfigurableApplicationContext applicationContext;

  @BeforeEach
  public void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(TestConfiiguration.class);
  }

  @Test
  public void testAware() {
    AuthService authService = applicationContext.getBean(AuthService.class);

    log.info(authService.getBeanName());
    Assertions.assertEquals("devtobil.belajarspringdasar.service.AuthService", authService.getBeanName());
    Assertions.assertSame(applicationContext, authService.getApplicationContext());
  }

}
