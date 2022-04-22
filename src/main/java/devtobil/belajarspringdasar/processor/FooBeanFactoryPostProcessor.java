package devtobil.belajarspringdasar.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import devtobil.belajarspringdasar.data.Foo;

@Component
public class FooBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    // TODO Auto-generated method stub

  }

  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    // TODO Auto-generated method stub
    GenericBeanDefinition definition = new GenericBeanDefinition();
    definition.setBeanClass(Foo.class);
    definition.setScope("singleton");

    registry.registerBeanDefinition("foo", definition);
  }

}
