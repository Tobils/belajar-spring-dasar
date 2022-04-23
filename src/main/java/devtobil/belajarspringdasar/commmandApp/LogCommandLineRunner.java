package devtobil.belajarspringdasar.commmandApp;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LogCommandLineRunner implements CommandLineRunner {

  /**
   * secara otomatis akan di eksekusi dan parameter ini dikirim dari main method
   * contoh:
   * -- contoh input argument
   * ...CommandApplication ade suhada mantaf "diajar code"
   * -- output
   * Log Command Line Runner [ade, suhada, mantaf, diajar code]
   */
  @Override
  public void run(String... args) throws Exception {
    log.info("Log Command Line Runner {}", Arrays.toString(args));
  }

}
