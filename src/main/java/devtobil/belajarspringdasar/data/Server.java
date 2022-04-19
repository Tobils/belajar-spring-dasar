package devtobil.belajarspringdasar.data;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {
  private static Logger logger = LoggerFactory.getLogger(Server.class);

  @PostConstruct()
  public void start() {
    logger.info("Start Server");
  }

  @PreDestroy()
  public void stop() {
    logger.info("Stop Server");
  }
}
