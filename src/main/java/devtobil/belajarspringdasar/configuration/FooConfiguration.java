package devtobil.belajarspringdasar.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devtobil.belajarspringdasar.data.Foo;

@Configuration
public class FooConfiguration {

  @Bean
  public Foo foo() {
    return new Foo();
  }

}
