package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.service.MerchantService;
import devtobil.belajarspringdasar.service.MerchantServiceImpl;

public class InheritanceTest {
  private static ConfigurableApplicationContext applicationContext;

  @BeforeEach
  public void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
    applicationContext.registerShutdownHook();
  }

  /**
   * baik diakses dari parent nya atau dr child nya adalah sama
   * bisa langsung akses ke dalam inheritancenya
   */
  @Test
  public void testInheritance() {
    MerchantService merchantService = applicationContext.getBean(MerchantService.class);
    MerchantServiceImpl merchantServiceImpl = applicationContext.getBean(MerchantServiceImpl.class);

    Assertions.assertSame(merchantService, merchantServiceImpl);
  }

}
