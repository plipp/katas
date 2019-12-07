package kata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

  private FizzBuzz fizzBuzz;

  @BeforeEach
  void setup() {
    fizzBuzz = new FizzBuzz();
  }

  @Test
  void shouldReturnFizzIfDivisibleBy5() {
    assertEquals("fizz", fizzBuzz.convert(5));
  }

  @Test
  void shouldReturnBuzzIfDivisibleBy7() {
    assertEquals("buzz", fizzBuzz.convert(7));
  }

  @Test
  void shouldReturnFizzBuzzIfDivisibleBy5And7() {
    assertEquals("fizzbuzz", fizzBuzz.convert(7 * 5));
  }

  @Test
  void shouldReturnNumberIfNotDivisibleBy5And7() {
    assertEquals("36", fizzBuzz.convert(36));
  }

  @AfterEach
  void teardown() {
    // nothing to do
  }
}