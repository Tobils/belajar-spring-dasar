package devtobil.belajarspringdasar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devtobil.belajarspringdasar.data.Connection;
import devtobil.belajarspringdasar.data.Server;

@Configuration
public class LifeCycleConfiguration {

  @Bean
  public Connection connection() {
    return new Connection();
  }

  // @Bean(initMethod = "start", destroyMethod = "stop")
  @Bean
  public Server server() {
    return new Server();
  }

}
