package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devtobil.belajarspringdasar.data.Car;
import devtobil.belajarspringdasar.processor.IdGeneratorBeanPostProccessor;

public class BeanProcessorTest {

  @Configuration
  @Import({
      Car.class,
      IdGeneratorBeanPostProccessor.class
  })
  public static class TestConfiguration {

  }

  private static ConfigurableApplicationContext applicationContext;

  @BeforeEach
  public void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
    applicationContext.registerShutdownHook();
  }

  /**
   * output uuid d6c6540e-c234-46b7-94ce-8b6b2c7abb64
   * 
   */
  @Test
  public void testBeanPostProcessor() {
    Car car = applicationContext.getBean(Car.class);

    System.out.println(car.getId());
    Assertions.assertNotNull(car.getId());
  }

}
