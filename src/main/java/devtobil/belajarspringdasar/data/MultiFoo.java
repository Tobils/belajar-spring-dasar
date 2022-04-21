package devtobil.belajarspringdasar.data;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class MultiFoo {

  @Getter
  private List<Foo> foos;

  public MultiFoo(ObjectProvider<Foo> objectProvider) {
    /** ambil semua foo nya jika lebih dr 1 */
    foos = objectProvider.stream().collect(Collectors.toList());
  }

}
