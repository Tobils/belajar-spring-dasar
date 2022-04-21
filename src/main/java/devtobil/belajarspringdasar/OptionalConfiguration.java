package devtobil.belajarspringdasar;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devtobil.belajarspringdasar.data.Bar;
import devtobil.belajarspringdasar.data.Foo;
import devtobil.belajarspringdasar.data.FooBar;

@Configuration
public class OptionalConfiguration {

  @Bean
  public Foo foo() {
    return new Foo();
  }

  @Bean
  public FooBar fooBar(Optional<Foo> foo, Optional<Bar> bar) {
    return new FooBar(foo.orElse(null), bar.orElse(null));
  }

}
