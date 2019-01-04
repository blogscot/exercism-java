import java.util.ArrayList;

class TwelveDays {

  private static final String[] days = {
      "first",
      "second",
      "third",
      "fourth",
      "fifth",
      "sixth",
      "seventh",
      "eighth",
      "ninth",
      "tenth",
      "eleventh",
      "twelfth"};

  private static final String[] gifts = {
      "and a Partridge in a Pear Tree",
      "two Turtle Doves",
      "three French Hens",
      "four Calling Birds",
      "five Gold Rings",
      "six Geese-a-Laying",
      "seven Swans-a-Swimming",
      "eight Maids-a-Milking",
      "nine Ladies Dancing",
      "ten Lords-a-Leaping",
      "eleven Pipers Piping",
      "twelve Drummers Drumming"};

  private static String createVerse(String day, String gifts) {
    return String.format("On the %s day of Christmas my true love gave to me: %s.\n", day, gifts);
  }

  private static String getGifts(int numGifts) {
    if (numGifts == 0) return "a Partridge in a Pear Tree";

    var currentGifts = new ArrayList<String>();
    for (int i = numGifts; i >= 0; i--) {
      currentGifts.add(gifts[i]);
    }
    return String.join(", ", currentGifts);
  }

  String verse(int verseNumber) {
    var num = verseNumber - 1;
    return createVerse(days[num], getGifts(num));
  }

  String verses(int startVerse, int endVerse) {
    var verses = new ArrayList<String>();

    for (int i = startVerse; i <= endVerse; i++) {
      verses.add(verse(i));
    }
    return String.join("\n", verses);
  }

  String sing() {
    return verses(1, 12);
  }
}
