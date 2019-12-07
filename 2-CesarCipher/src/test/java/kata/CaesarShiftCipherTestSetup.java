package kata;

import net.jqwik.api.Example;
import org.junit.jupiter.api.Test;

class CaesarShiftCipherTestSetup {
  @Test
  void shouldNotThrowExceptionsJUnit5() {
    new CaesarShiftCipher().cipher("", 1);
  }

  @Example
  void shouldNotThrowExceptionsJQwik() {
    new CaesarShiftCipher().cipher("", 1);
  }
}
