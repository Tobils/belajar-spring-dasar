package devtobil.belajarspringdasar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devtobil.belajarspringdasar.data.Connection;

@Configuration
public class LifeCycleConfiguration {

  @Bean
  public Connection connection() {
    return new Connection();
  }

}
