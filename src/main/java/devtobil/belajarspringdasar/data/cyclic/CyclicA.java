package devtobil.belajarspringdasar.data.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data()
@AllArgsConstructor()
public class CyclicA {
  private CyclicB cyclicB;

  public CyclicA(CyclicB cyclicB) {
    this.cyclicB = cyclicB;
  }

}
