import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PigLatinTranslator {

  String translate(String phrase) {
    return Arrays
        .stream(phrase.split(" "))
        .map(this::translateWord)
        .collect(Collectors.joining(" "));
  }

  private String translateWord(String word) {

    if (startsWithVowel(word)) {
      return word + "ay";
    } else if (startsWithVowel(word) && word.substring(1, 3).equals("qu")) {
      return word + "ay";
    } else if (word.endsWith("y") && word.length() == 2) {
      return "" + word.charAt(1) + word.charAt(0) + "ay";
    } else if (word.substring(1, 3).equals("qu")) {
      return word.substring(3) + word.substring(0, 3) + "ay";
    } else if (word.charAt(0) == 'q' && word.charAt(1) != 'u') {
      return word.substring(1) + "qay";
    } else if (word.startsWith("yt")) {
      return word + "ay";
    } else if (word.startsWith("xr")) {
      return word + "ay";
    } else if (word.startsWith("ch")) {
      return word.substring(2) + "chay";
    } else if (word.startsWith("qu")) {
      return word.substring(2) + "quay";
    } else if (word.startsWith("thr")) {
      return word.substring(3) + "thray";
    } else if (word.startsWith("th")) {
      return word.substring(2) + "thay";
    } else if (word.startsWith("sch")) {
      return word.substring(3) + "schay";
    } else if (word.startsWith("rh")) {
      return word.substring(2) + "rhay";
    } else if (word.startsWith("y")) {
      return word.substring(1) + "yay";
    }
    return word.substring(1) + word.charAt(0) + "ay";
  }

  private boolean startsWithVowel(String word) {
    var vowels = "aeiou".split("");
    return Stream.of(vowels).anyMatch(word::startsWith);
  }
}
