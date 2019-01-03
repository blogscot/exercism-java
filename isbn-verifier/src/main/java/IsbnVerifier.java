import java.util.List;
import java.util.stream.Collectors;

class IsbnVerifier {

  boolean isValid(String stringToVerify) {
    if (stringToVerify.isEmpty()) return false;

    List<Integer> digits = stringToVerify
        .codePoints()
        .mapToObj(i -> (char) i)
        .filter(Character::isDigit)
        .map(Character::getNumericValue)
        .collect(Collectors.toList());

    var containsCheckDigit = stringToVerify.charAt(stringToVerify.length() - 1) == 'X';
    var digitsSize = digits.size();

    if (!(digitsSize == 10 && !containsCheckDigit ||
        digitsSize == 9 && containsCheckDigit)) return false;

    var total = containsCheckDigit ? 10 : 0;
    for (int i = 0; i < digitsSize; i++) {
      total += (10 - i) * digits.get(i);
    }

    return total % 11 == 0;
  }
}
