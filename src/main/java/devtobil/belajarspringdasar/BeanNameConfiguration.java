package devtobil.belajarspringdasar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import devtobil.belajarspringdasar.data.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class BeanNameConfiguration {
  private static Logger log = LoggerFactory.getLogger(BeanNameConfiguration.class);

  @Primary
  @Bean(value = "fooFirst")
  public Foo foo1() {
    log.info("foo-first class created !");
    return new Foo();
  }

  @Bean(value = "fooSecond")
  public Foo foo2() {
    log.info("foo-second class created !");
    return new Foo();
  }

}
