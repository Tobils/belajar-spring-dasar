package devtobil.belajarspringdasar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import devtobil.belajarspringdasar.data.Bar;
import devtobil.belajarspringdasar.data.Foo;
import devtobil.belajarspringdasar.scope.DoubletonScope;

@Configuration
public class ScopeConfiguration {

  private static Logger log = LoggerFactory.getLogger(ScopeConfiguration.class);

  @Bean
  @Scope("prototype")
  public Foo foo() {
    log.info("Create new Foo --- scope");
    return new Foo();
  }

  /**
   * register custom csope
   * 
   * @return
   */
  @Bean
  public CustomScopeConfigurer customScopeConfigurer() {
    CustomScopeConfigurer configurer = new CustomScopeConfigurer();
    configurer.addScope("doubleton", new DoubletonScope());
    return configurer;
  }

  @Bean
  @Scope("doubleton")
  public Bar bar() {
    log.info("create new Bar ...");
    return new Bar();
  }

}
