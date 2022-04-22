package devtobil.belajarspringdasar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devtobil.belajarspringdasar.listener.LoginAgainSUccessListener;
import devtobil.belajarspringdasar.listener.LoginSUccessListener;
import devtobil.belajarspringdasar.listener.UserListener;
import devtobil.belajarspringdasar.service.UserService;

public class EventListenerTest {

  @Configuration
  @Import({
      UserService.class,
      LoginSUccessListener.class, /** listener */
      LoginAgainSUccessListener.class, /** listener */
      UserListener.class
  })
  public static class TestConfiguration {
  }

  private static ConfigurableApplicationContext applicationContext;

  @BeforeEach
  public void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
  }

  @Test
  public void testEventListener() {
    UserService userService = applicationContext.getBean(UserService.class);
    userService.login("tobils", "tobils");
    userService.login("tobils", "123");
    userService.login("tobils", "aja");
  }

}
