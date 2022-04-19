package devtobil.belajarspringdasar.data.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data()
@AllArgsConstructor()
public class CyclicB {
  private CyclicC cyclicC;

  public CyclicB(CyclicC cyclicC) {
    this.cyclicC = cyclicC;
  }

}
