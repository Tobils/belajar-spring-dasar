package devtobil.belajarspringdasar.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class AuthService implements ApplicationContextAware, BeanNameAware {

  @Getter
  private String beanName;

  @Getter
  private ApplicationContext applicationContext;

  @Override
  public void setBeanName(String name) {
    // TODO Auto-generated method stub
    this.beanName = name;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    // TODO Auto-generated method stub
    this.applicationContext = applicationContext;
  }

}
