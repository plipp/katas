package kata;

import java.util.Objects;

public class CaesarShiftCipher {

  private static final int NUMBER_OF_LOWERCASE_CHARS = 'z' - 'a' + 1;

  /**
   * A Caesar Cipher is a simply way to encrypt messages.
   * There are two inputs: A message and a shift.
   * <p>
   * The message can be any string containing lower case letters between 'a' and 'z' and spaces,
   * any other characters will throw an IllegalArgumentException.
   * <p></p>
   * The shift can be any positive or negative integer.
   * Each letter of the message is then shifted by the specified amount
   * (if shift is '3' then 'abc' becomes 'def' and 'xyz' becomes 'abc').
   *
   * @param message message to be encrypted
   * @param shift shift
   * @return the encrypted message
   */
  public String cipher(String message, int shift) {
    check(message);
    int[] codepoints = message.chars()
      .map(i -> shiftCharacter(shift, i))
      .toArray();

    return new String(codepoints,0,codepoints.length);
  }

  private static int shiftCharacter(int shift, int c) {
    if (Character.isSpaceChar(c)) {
      return c;
    }
    assert c>='a';

    int newChar = c + normalizedShift(shift);
    return newChar>'z' ? (char)(newChar-NUMBER_OF_LOWERCASE_CHARS):(char)newChar;
  }

  /**
   * normalize shift to be in [0,26)
   *
   * @param shift given number of shifts
   * @return normalized shift
   */
  private static int normalizedShift(int shift) {
    int actualShift = shift % NUMBER_OF_LOWERCASE_CHARS;
    if (actualShift<0) {
      actualShift = NUMBER_OF_LOWERCASE_CHARS + actualShift;
    }
    return actualShift;
  }

  private static void check(String message) {
    if (Objects.isNull(message)) {
      throw new IllegalArgumentException("message must not be null");
    }
    if (message.chars().anyMatch(c -> !((c>='a' && c<='z') || Character.isSpaceChar(c)))){
      throw new IllegalArgumentException("message contains not-lowercase or space chars:"+ message);
    }
  }
}
