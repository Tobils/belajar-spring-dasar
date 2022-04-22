package devtobil.belajarspringdasar.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import devtobil.belajarspringdasar.data.Foo;

@SpringBootApplication
public class FooApplication {

  public static void main(String[] args) {
    ApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);
    Foo foo = applicationContext.getBean(Foo.class);
  }

  @Bean
  public Foo foo() {
    return new Foo();
  }

}
