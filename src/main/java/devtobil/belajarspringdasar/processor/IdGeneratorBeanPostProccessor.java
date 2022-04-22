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
public class IdGeneratorBeanPostProccessor implements BeanPostProcessor, Ordered {

  /**
   * return urutan antrian secara asc, dr kecil ke besar
   * 
   * @return
   */
  @Override
  public int getOrder() {
    return 1;
  }

  /**
   * override bean field condition here ...
   * mirip dengan transformer pada nestjs
   */
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    log.info("Id generator processor for Bean {}", beanName);
    if (bean instanceof IdAware) {
      log.info("Set id generator for Bean {}", beanName);
      IdAware idAware = (IdAware) bean;
      idAware.setId(UUID.randomUUID().toString());
    }
    return bean;
  }

}
