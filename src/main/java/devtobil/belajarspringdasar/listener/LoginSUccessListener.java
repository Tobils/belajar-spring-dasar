package devtobil.belajarspringdasar.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import devtobil.belajarspringdasar.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginSUccessListener implements ApplicationListener<LoginSuccessEvent> {

  @Override
  public void onApplicationEvent(LoginSuccessEvent event) {
    // TODO Auto-generated method stub
    log.info("Success login for user {}", event.getUser());
  }

}
