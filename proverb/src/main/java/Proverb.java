import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Proverb {
  private List<String> causes;
  private String lastCause;
  private String proverb = "";

  Proverb(String[] words) {
    if (words.length > 0) {
      this.causes = Arrays.stream(words).skip(1).collect(Collectors.toList());
      this.lastCause = words[0];

      var builder = new StringBuilder();
      var previous = this.lastCause;

      for (String cause : causes) {
        builder.append(String.format("For want of a %s the %s was lost.\n", previous, cause));
        previous = cause;
      }

      builder.append(String.format("And all for the want of a %s.", this.lastCause));
      proverb = builder.toString();
    }
  }

  String recite() {
    return proverb;
  }

}
