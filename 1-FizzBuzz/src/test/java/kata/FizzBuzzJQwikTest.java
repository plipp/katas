package kata;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unused")
@Disabled
class FizzBuzzJQwikTest implements AutoCloseable {

  private FizzBuzz fizzBuzz;

  // setup
  FizzBuzzJQwikTest() {
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
  void shouldStartWithFizzIfDivisibleBy5(@ForAll("divisibleBy5") int i) {
    final String result = fizzBuzz.convert(i);
    assertTrue(result.startsWith("fizz"), result+ " does not start with 'fizz'");
  }

  @Provide
  private Arbitrary<Integer> divisibleBy5() {
    return Arbitraries.integers().between(1, 100).filter(i -> i % 5 == 0);
  }

  // TODO EXERCISE
  // Write Properties and Provider for "shouldEndWithBuzzIfDivisibleBy7" and "shouldReturnTheNumberIfNotDivisibleBy5Or7"
  // and fix the bug

  @Override
  public void close() {
    // teardown
  }
}