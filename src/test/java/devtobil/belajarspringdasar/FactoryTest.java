package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devtobil.belajarspringdasar.client.PaymentGatewayClient;

public class FactoryTest {

  private static ConfigurableApplicationContext applicationContext;

  @BeforeEach
  public void setUp() {
    applicationContext = new AnnotationConfigApplicationContext(FactoryConfiguration.class);
    applicationContext.registerShutdownHook();
  }

  @Test
  public void testFactoryBean() {
    PaymentGatewayClient paymentGatewayClient = applicationContext.getBean(PaymentGatewayClient.class);
    Assertions.assertSame(paymentGatewayClient.getEndpoint(), "https://example.com");
    Assertions.assertSame(paymentGatewayClient.getPrivateKey(), "private");
    Assertions.assertSame(paymentGatewayClient.getPublicKey(), "public");
  }

}
