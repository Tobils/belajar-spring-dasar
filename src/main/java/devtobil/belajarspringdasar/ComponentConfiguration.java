package devtobil.belajarspringdasar;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devtobil.belajarspringdasar.data.MultiFoo;

@Configuration
@ComponentScan(basePackages = {
        "devtobil.belajarspringdasar.service",
        "devtobil.belajarspringdasar.repository",
        "devtobil.belajarspringdasar.configuration" })
@Import(MultiFoo.class)
public class ComponentConfiguration {

}
