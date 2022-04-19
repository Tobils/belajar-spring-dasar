package devtobil.belajarspringdasar.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Connection implements InitializingBean, DisposableBean {

  private static Logger logger = LoggerFactory.getLogger(Connection.class);

  @Override
  public void destroy() throws Exception {
    // TODO Auto-generated method stub
    logger.info("Connection is cloed ...");

  }

  @Override
  public void afterPropertiesSet() throws Exception {
    // TODO Auto-generated method stub
    logger.info("Connection is ready to used ...");
  }

}
