package kata;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("WeakerAccess")
public class CaesarShiftCipherJQwikTest {

  private final CaesarShiftCipher caesarShiftCipher;

  // setup
  public CaesarShiftCipherJQwikTest() {
    caesarShiftCipher = new CaesarShiftCipher();
  }

  @Example
  public boolean shouldReturnInputForShift0(){
    final String inputMessage = "a";
    return caesarShiftCipher.cipher(inputMessage,0).equals(inputMessage);

    // TODO EXERCISE : change the return statement to the following line and see, that jqwik also works with boolean-return-values
//    return caesarShiftCipher.cipher(inputMessage,0).equals("b");
  }

  // TODO EXERCISE : Write analogous tests to that one in kata.CaesarShiftCipherTest
  // Note: There already exist generators like @AlphaChars, @LowerChars...
}
