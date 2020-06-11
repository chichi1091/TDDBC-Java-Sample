

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SampleTest2 {
  @Test
  void test() {
   assertThat(1 + 1, is(2));
  }

  @Test
  public void テスト名を日本語() {
       assertThat(1 + 1, is(3));
  }
}