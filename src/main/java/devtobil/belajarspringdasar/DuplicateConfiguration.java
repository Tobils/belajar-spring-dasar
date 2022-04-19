package devtobil.belajarspringdasar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devtobil.belajarspringdasar.data.Foo;

@Configuration
public class DuplicateConfiguration {

  @Bean()
  public Foo foo1() {
    return new Foo();
  }

  @Bean()
  public Foo foo2() {
    return new Foo();
  }
}
