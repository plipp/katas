package kata;

public class FizzBuzz {
  /**
   * Takes a number between 1 to 100 and converts it as follows:
   *
   * - If it's a multiple of 5, it should print "fizz".
   * - If it's a multiple of 7, it should print "buzz".
   * - If it's a multiple of 5 and 7, it should print "fizzbuzz".
   * - Else it shout return the number itself (as String)
   *
   * @param value number between 1 to 100 to convert
   * @return converted number
   */
  public String convert(int value) {
    if (value % 7 == 0) {
      if (value % 5 == 0) {
        return "fizzbuzz";
      }
      return "buzz";
    }
    if (value == 5) {
      return "fizz";
    } else return String.valueOf(value);
  }
}
