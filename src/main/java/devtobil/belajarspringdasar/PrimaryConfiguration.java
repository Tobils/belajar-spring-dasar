package devtobil.belajarspringdasar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import devtobil.belajarspringdasar.data.Foo;

@Configuration
public class PrimaryConfiguration {

  @Primary()
  @Bean()
  public Foo fooSatu() {
    return new Foo();
  }

  @Bean()
  public Foo fooDua() {
    return new Foo();
  }
}
