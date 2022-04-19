package devtobil.belajarspringdasar;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devtobil.belajarspringdasar.configuration.BarConfiguration;
import devtobil.belajarspringdasar.configuration.FooConfiguration;

@Configuration
@Import(value = {
    BarConfiguration.class,
    FooConfiguration.class
})
public class MainConfiguration {

}
