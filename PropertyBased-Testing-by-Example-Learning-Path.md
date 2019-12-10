# Property Based Testing by Example - Learning Path

If you want to learn more about [Property Based Testing](https://blogs.oracle.com/javamagazine/know-for-sure-with-property-based-testing)
using the [qwik library](https://jqwik.net/docs/current/user-guide.html)

* check out this repository (`master` branch)
* set it up (see `Setup in IntelliJ`)
* follow the `Property-Based-Testing Intro` below

## Setup in IntelliJ

1. If you use IntelliJ, create a new empty Java8 project and 

    * add [fizzBuzz](./1-FizzBuzz) 
    * add [cesarCipher](./2-CesarCipher)
      as modules to your project.

2. Run the existing tests in both modules (`./1-FizzBuzz/src/test/java/`, `./2-CesarCipher/src/test/java/kata/CaesarShiftCipherTest.java`) to get all libraries in place and to see, 
   that the initial setup works properly.<br>
   **Expected outcome**: All should build and tests should be green.

## Property-Based-Testing Intro

### fizzbuzz sample

1. Checkout the `01-fizzbuzz`-branch with a sample solution [kata.FizzBuzz](./1-FizzBuzz/src/main/java/kata/FizzBuzz.java) 
   and take a look in the corresponding [junit5-test](./1-FizzBuzz/src/test/java/kata/FizzBuzzTest.java)).<br>
   **Question**: All fine?

2. Now lets have a look in the corresponding [jqwik-test](./1-FizzBuzz/src/test/java/kata/FizzBuzzJQwikTest.java)):
  * Remove the @Disabled annotation at the `FizzBuzzJQwikTest` class the and run it
  * Note, 
    * that the `@Example`s correspond to `normal`junit-`@Test`s
    * how `@Properties` and generators (`@Provider, Arbitraries, @ForAll`) work.
  * Try the exercises (see `TODO EXERCISE`)  

### caesarshift-cipher sample

1. Checkout the `02-caesar`-branch with a sample solution [kata.CaesarShiftCipher](./2-CesarCipher/src/main/java/kata/CaesarShiftCipher.java) 
   and take a look in the corresponding [junit5-test](./2-CesarCipher/src/test/java/kata/CaesarShiftCipherTest.java).<br>

2. Now lets have a look in the corresponding [jqwik-test](./2-CesarCipher/src/test/java/kata/CaesarShiftCipherJQwikTest.java)):
  * Check for the `TODO EXERCISE` comments
  * Write tests corresponding to the junit5-`CaesarShiftCipherTest`s. Decide, whether you better use 
    * a single `@Example` or
    * a `@Property` and generators (`@Provider, Arbitraries, @ForAll`).
  Especially think about the shifts 1, 1+26, -1, -1-27... (see `@CsvSource`s)

## Links

- [Know for Sure with Property-Based Testing](https://blogs.oracle.com/javamagazine/know-for-sure-with-property-based-testing)
- [User Guide jqwik](https://jqwik.net/docs/current/user-guide.html)