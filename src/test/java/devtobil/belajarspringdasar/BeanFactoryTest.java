package devtobil.belajarspringdasar;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.data.Foo;

public class BeanFactoryTest {

  private static ConfigurableApplicationContext applicationContext;

  @BeforeEach
  public void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(ScanConfiguration.class);
    applicationContext.registerShutdownHook();
  }

  /**
   * test bean factory
   */
  @Test
  public void testFactoryBean() {
    ObjectProvider<Foo> fooObjectProvider = applicationContext.getBeanProvider(Foo.class);
    List<Foo> fooList = fooObjectProvider.stream().collect(Collectors.toList());

    /**
     * list object class foo sesuai dengan jumlah object bean pada class
     * ScanConfiguration -> FooConfiguration
     * [devtobil.belajarspringdasar.data.Foo@79dc5318,
     * devtobil.belajarspringdasar.data.Foo@8e50104,
     * devtobil.belajarspringdasar.data.Foo@37e4d7bb]
     */
    System.out.println(fooList);

    /**
     * output
     * {foo1=devtobil.belajarspringdasar.data.Foo@79dc5318,
     * foo2=devtobil.belajarspringdasar.data.Foo@8e50104,
     * foo3=devtobil.belajarspringdasar.data.Foo@37e4d7bb}
     * return nama objectbean=bean
     */
    Map<String, Foo> beans = applicationContext.getBeansOfType(Foo.class);
    System.out.println(beans);
  }

}
