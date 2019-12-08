package kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CaesarShiftCipherTest {

  private CaesarShiftCipher cipher = new CaesarShiftCipher();

  @Test
  void shouldThrowIllegalArgumentExceptionForNullMessage() {
    assertThrows(IllegalArgumentException.class, () -> cipher.cipher(null,5));
  }

  @ParameterizedTest
  @CsvSource({
    "'Abc'",
    "'abcü'"
  })
  void shouldThrowIllegalArgumentExceptionForUnallowedMessageCharacters(String message) {
    assertThrows(IllegalArgumentException.class, () -> cipher.cipher(message,5));
  }

  @Test
  void shouldJustReturnEmptyMessage() {
    assertEquals("",cipher.cipher("",5));
  }

  @ParameterizedTest
  @CsvSource({
    "'abc', 0, 'abc'",
    "'abc', 26, 'abc'",
    "'abc', 1, 'bcd'",
    "'abc', 27, 'bcd'",
    "'a  bc', 27, 'b  cd'",
    "'xyz', 1, 'yza'"
  })
  void shouldShiftMessageInNullOrPositiveDirection(String message, int shift, String expected) {
    assertEquals(expected, cipher.cipher(message,shift));
  }

  @ParameterizedTest
  @CsvSource({
    "'abc', -1, 'bcd'",
    "'bcd', -26, 'bcd'",
    "'cde', -27, 'def'",
    "'c d e', -27, 'd e f'",
    "'cde', -54, 'efg'"
  })
  void shouldShiftMessageInNegativeDirection(String expected, int shift, String message) {
    assertEquals(expected, cipher.cipher(message,shift));
  }
}
