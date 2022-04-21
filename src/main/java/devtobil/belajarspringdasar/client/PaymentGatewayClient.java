package devtobil.belajarspringdasar.client;

import lombok.Data;

/**
 * misal ini adalah class milik third party yg kita tidak ada akses untuk tambah
 * anotation @Bean maupun @Component
 */

@Data
public class PaymentGatewayClient {

  private String endpoint;
  private String publicKey;
  private String privateKey;

}
