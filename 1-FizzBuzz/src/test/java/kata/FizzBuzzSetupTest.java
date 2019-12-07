package kata;

import net.jqwik.api.Example;
import org.junit.jupiter.api.Test;

class FizzBuzzSetupTest {

  @Test
  void shouldNotThrowExceptionsJUnit5() {
    new FizzBuzz().convert(1);
  }

  @Example
  void shouldNotThrowExceptionsJQwik() {
    new FizzBuzz().convert(1);
  }
}