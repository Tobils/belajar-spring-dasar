package devtobil.belajarspringdasar;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "devtobil.belajarspringdasar.service",
    "devtobil.belajarspringdasar.repository",
    "devtobil.belajarspringdasar.configuration" })
public class ComponentConfiguration {

}
