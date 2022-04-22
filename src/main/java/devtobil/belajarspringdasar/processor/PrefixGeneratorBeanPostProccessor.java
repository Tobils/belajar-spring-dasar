package devtobil.belajarspringdasar.processor;

import java.util.UUID;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import devtobil.belajarspringdasar.aware.IdAware;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PrefixGeneratorBeanPostProccessor implements BeanPostProcessor, Ordered {

  /**
   * return urutan antrian secara asc, dr kecil ke besar
   * 
   * @return
   */
  @Override
  public int getOrder() {
    return 2;
  }

  /**
   * override bean field condition here ...
   * mirip dengan transformer pada nestjs
   */
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    log.info("Prefix generator processor for Bean {}", beanName);
    if (bean instanceof IdAware) {
      log.info("Prefix Set id generator for Bean {}", beanName);
      IdAware idAware = (IdAware) bean;
      idAware.setId("PREFIX-" + UUID.randomUUID().toString());
    }
    return bean;
  }

}
