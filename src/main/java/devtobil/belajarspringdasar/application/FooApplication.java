package devtobil.belajarspringdasar.application;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import devtobil.belajarspringdasar.data.Bar;
import devtobil.belajarspringdasar.data.Foo;
import devtobil.belajarspringdasar.listener.AppStartingListener;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
public class FooApplication {

  // public static void main(String[] args) {
  // ApplicationContext applicationContext =
  // SpringApplication.run(FooApplication.class, args);
  // Foo foo = applicationContext.getBean(Foo.class);
  // }

  @Bean
  public Foo foo() {
    return new Foo();
  }

  /**
   * running aplikai spring boot secara manual dan dapat melakukan config2
   * tambahan seperti mematikan banner
   * 
   * @param args
   */
  // public static void main(String[] args) {
  // // SpringApplication application = new
  // SpringApplication(FooApplication.class);
  // // application.setBannerMode(Mode.OFF);

  // /**
  // * bisa set banyak listener
  // */
  // // application.setListeners(List.of(new AppStartingListener()));
  // // ConfigurableApplicationContext applicationContext = application.run(args);

  // // Foo foo = applicationContext.getBean(Foo.class);
  // System.out.println(foo);
  // }

}
