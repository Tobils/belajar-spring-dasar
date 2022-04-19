package devtobil.belajarspringdasar;

public class Database {

  /**
   * constructor in java
   */
  private static Database database;

  public static Database getInstance() {
    if (database == null) {
      database = new Database();
    }

    return database;
  }

}
