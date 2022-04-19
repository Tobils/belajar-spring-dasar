package devtobil.belajarspringdasar.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devtobil.belajarspringdasar.data.Bar;

@Configuration
public class BarConfiguration {

  @Bean
  public Bar bar() {
    return new Bar();
  }

}
