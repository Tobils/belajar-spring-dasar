package devtobil.belajarspringdasar.scope;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class DoubletonScope implements Scope {

  private static Logger log = LoggerFactory.getLogger(DoubletonScope.class);
  private List<Object> objects = new ArrayList<>(2);
  private Long counter = -1L;

  /** dimulai dari -1 karena list indexnya berawal dari 0 */

  @Override
  public Object get(String name, ObjectFactory<?> objectFactory) {
    // TODO Auto-generated method stub untuk mengambil data
    counter++;
    if (objects.size() == 2) {
      int index = (int) (counter % 2);
      log.info("counter ...");
      return objects.get(index);
    } else {
      log.info("add new object ...");
      Object object = objectFactory.getObject();
      objects.add(object);
      return object;
    }
  }

  @Override
  public Object remove(String name) {
    // TODO Auto-generated method stub untuk meremove objectnya
    if (!objects.isEmpty()) {
      return objects.remove(0);
    }
    return null;
  }

  @Override
  public void registerDestructionCallback(String name, Runnable callback) {
    // TODO Auto-generated method stub

  }

  @Override
  public Object resolveContextualObject(String key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getConversationId() {
    // TODO Auto-generated method stub
    return null;
  }

}
