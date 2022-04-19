package devtobil.belajarspringdasar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

import devtobil.belajarspringdasar.data.Bar;
import devtobil.belajarspringdasar.data.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DependsOnConfiguration {

  private static Logger log = LoggerFactory.getLogger(DependsOnConfiguration.class);

  /**
   * bean foo dibuat setelah bean bar dibuat, karena bean foo tergantung dengan
   * bean bar
   * 
   * @Lazy membuat foo dibuat saat di akses
   * @return Foo
   */
  @Lazy
  @DependsOn("bar")
  @Bean
  public Foo foo() {
    log.info("Create New Foo");
    return new Foo();
  }

  @Bean
  public Bar bar() {
    log.info("Create New Bar");
    return new Bar();
  }

}
