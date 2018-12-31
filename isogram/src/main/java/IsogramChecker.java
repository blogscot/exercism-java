import java.util.HashSet;
import java.util.stream.Collectors;

class IsogramChecker {

  boolean isIsogram(String phrase) {
    var letters = phrase
        .chars()
        .mapToObj(c -> Character.toLowerCase((char) c))
        .filter(Character::isLetter)
        .collect(Collectors.toList());

    var lettersSet = new HashSet<>(letters);

    return letters.size() == lettersSet.size();
  }

}
