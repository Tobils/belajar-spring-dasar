package devtobil.belajarspringdasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

  @Test()
  public void testSIngleton() {
    var database1 = Database.getInstance();
    var database2 = Database.getInstance();

    Assertions.assertSame(database1, database2);
  }
}
