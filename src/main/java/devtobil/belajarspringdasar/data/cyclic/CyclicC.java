package devtobil.belajarspringdasar.data.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data()
@AllArgsConstructor()
public class CyclicC {
  private CyclicA cyclicA;

  public CyclicC(CyclicA cyclicA) {
    this.cyclicA = cyclicA;
  }

}
