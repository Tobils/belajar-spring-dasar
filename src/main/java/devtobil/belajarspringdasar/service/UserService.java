package devtobil.belajarspringdasar.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import devtobil.belajarspringdasar.data.User;
import devtobil.belajarspringdasar.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserService implements ApplicationEventPublisherAware {

  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    // TODO Auto-generated method stub
    log.info("set ApplicationEventPublisher");
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public boolean login(String username, String password) {
    if (isLoginSuccess(username, password)) {
      this.applicationEventPublisher.publishEvent(new LoginSuccessEvent(new User(username)));
      return true;
    } else {
      return false;
    }
  }

  public boolean isLoginSuccess(String username, String password) {
    return "tobils".equals(username) && "tobils".equals(password);
  }

}
