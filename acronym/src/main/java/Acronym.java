import java.util.regex.Pattern;

class Acronym {
  private String acronym;

  Acronym(String phrase) {
    Pattern pattern = Pattern.compile("(\\b\\w|[A-Z][a-z])");
    StringBuilder builder = new StringBuilder();
    var matches = pattern.matcher(phrase.replace("'", ""));

    while (matches.find()) {
      String group = matches.group();
      builder.append(group.toUpperCase());
    }
    acronym = builder.toString();
  }

  String getAcronym() {
    return acronym;
  }

}
