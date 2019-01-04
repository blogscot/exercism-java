import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

  List<String> printToList(char chr) {
    var output = new ArrayList<String>();
    var lineWidth = getLineWidth(chr);

    int start = lineWidth / 2;
    var left = start;
    var right = start;
    var letter = 'A';

    while (left >= 0) {
      var newLine = getNewLine(lineWidth);
      newLine[left] = letter;
      newLine[right] = letter++;
      output.add(String.valueOf(newLine));
      left--;
      right++;
    }

    left++;
    right--;
    letter--;

    while (left < start) {
      left++;
      right--;
      var newLine = getNewLine(lineWidth);
      newLine[left] = --letter;
      newLine[right] = letter;
      output.add(String.valueOf(newLine));
    }

    return output;
  }

  private static int getLineWidth(char letter) {
    return 1 + 2 * (letter - 'A');
  }

  private static char[] getNewLine(int lineWidth) {
    var array = new char[lineWidth];
    for (int i = 0; i < lineWidth; i++) {
      array[i] = ' ';
    }
    return array;
  }


}
