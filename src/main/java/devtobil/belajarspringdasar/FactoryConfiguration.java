package devtobil.belajarspringdasar;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devtobil.belajarspringdasar.factory.PaymentGateewayClientFactoryBean;

@Configuration
@Import(PaymentGateewayClientFactoryBean.class)
public class FactoryConfiguration {

}
