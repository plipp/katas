package kata;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unused")
@Disabled
class FizzBuzzJKwiqTest implements AutoCloseable {

  private FizzBuzz fizzBuzz;

  // setup
  FizzBuzzJKwiqTest() {
    fizzBuzz = new FizzBuzz();
  }

  @Example
  void shouldReturnFizzIfDivisibleBy5() {
    assertEquals("fizz", fizzBuzz.convert(5));
  }

  @Example
  void shouldReturnBuzzIfDivisibleBy7() {
    assertEquals("buzz", fizzBuzz.convert(7));
  }

  @Example
  void shouldReturnFizzBuzzIfDivisibleBy5And7() {
    assertEquals("fizzbuzz", fizzBuzz.convert(7 * 5));
  }

  @Example
  void shouldReturnNumberIfNotDivisibleBy5And7() {
    assertEquals("36", fizzBuzz.convert(36));
  }

  @Property
  void shouldNotReturnNullForAllNumbers(@ForAll @IntRange(min = 1, max = 100) int i) {
    assertNotNull(fizzBuzz.convert(i));
  }

  @Property
  void shouldEndWithBuzzIfDivisibleBy7(@ForAll("divisibleBy7") int i) {
    final String result = fizzBuzz.convert(i);
    assertTrue(result.endsWith("buzz"), result);
  }

  @Provide
  private Arbitrary<Integer> divisibleBy7() {
    return Arbitraries.integers().between(1, 100).filter(i -> i % 7 == 0);
  }

  // TODO EXERCISE
  // Write Properties and Provider for "shouldStartWithBuzzIfDivisibleBy5" and "shouldReturnTheNumberIfNotDivisibleBy5Or7"
  // and fix the bug

  @Override
  public void close() {
    // teardown
  }
}