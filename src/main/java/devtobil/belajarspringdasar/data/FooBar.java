package devtobil.belajarspringdasar.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FooBar {
  private Foo foo;
  private Bar bar;

  public FooBar(Foo foo, Bar bar) {
    this.foo = foo;
    this.bar = bar;
  }

  public Foo getFoo() {
    return foo;
  }

  public Bar getBar() {
    return bar;
  }
}
