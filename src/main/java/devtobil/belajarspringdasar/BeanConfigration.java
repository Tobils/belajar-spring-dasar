package devtobil.belajarspringdasar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devtobil.belajarspringdasar.data.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class BeanConfigration {

  private static Logger log = LoggerFactory.getLogger(BeanConfigration.class);

  @Bean
  public Foo foo() {
    Foo foo = new Foo();
    log.info("created foo class");
    return foo;
  }

}
