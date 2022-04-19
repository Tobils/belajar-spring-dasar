package devtobil.belajarspringdasar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.data.Connection;
import devtobil.belajarspringdasar.data.Server;

public class LiifeCycleTest {

  private static ConfigurableApplicationContext context;

  @BeforeEach
  public void setUp() {
    context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
  }

  @AfterEach
  public void tearDown() {
    context.close();
  }

  @Test
  public void testConnection() {
    Connection connection = context.getBean(Connection.class);
  }

  /**
   * test life cycle dengan annotation pada class Server
   */
  @Test
  public void testServer() {
    Server server = context.getBean(Server.class);
  }

}
