package devtobil.belajarspringdasar.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import devtobil.belajarspringdasar.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserListener {

  @EventListener(classes = LoginSuccessEvent.class)
  public void onLoginSuccessEvent(LoginSuccessEvent event) {
    log.info("[@EventListener] Login success for user {}", event.getUser());
  }

}
