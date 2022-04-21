package devtobil.belajarspringdasar.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import devtobil.belajarspringdasar.client.PaymentGatewayClient;

@Component("paymentGatewayClient")
public class PaymentGateewayClientFactoryBean implements FactoryBean<PaymentGatewayClient> {

  @Override
  public PaymentGatewayClient getObject() throws Exception {
    // TODO Auto-generated method stub
    PaymentGatewayClient paymentGatewayClient = new PaymentGatewayClient();
    paymentGatewayClient.setEndpoint("https://example.com");
    paymentGatewayClient.setPrivateKey("private");
    paymentGatewayClient.setPublicKey("public");
    return paymentGatewayClient;
  }

  @Override
  public Class<?> getObjectType() {
    // TODO Auto-generated method stub
    return PaymentGatewayClient.class;
  }

}
