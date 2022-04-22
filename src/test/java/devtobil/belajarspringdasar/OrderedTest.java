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
import devtobil.belajarspringdasar.processor.PrefixGeneratorBeanPostProccessor;

public class OrderedTest {

  @Configuration
  @Import({
      Car.class,
      IdGeneratorBeanPostProccessor.class,
      PrefixGeneratorBeanPostProccessor.class
  })
  public static class TestConfiguration {
  }

  private static ConfigurableApplicationContext applicationContext;

  @BeforeEach
  public void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
  }

  @Test
  public void testCar() {
    Car car = applicationContext.getBean(Car.class);
    System.out.println(car.getId());

    Assertions.assertNotNull(car.getId());
    Assertions.assertTrue(car.getId().startsWith("PREFIX-"));
  }

}
