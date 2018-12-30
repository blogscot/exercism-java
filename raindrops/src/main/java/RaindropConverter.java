import java.util.function.Predicate;

class RaindropConverter {

  String convert(int number) {

    Predicate<Integer> isDivisibleBy = (var i) -> number % i == 0;

    var sb = new StringBuilder();
    var isDivBy3 = isDivisibleBy.test(3);
    var isDivBy5 = isDivisibleBy.test(5);
    var isDivBy7 = isDivisibleBy.test(7);

    if (isDivBy3) sb.append("Pling");
    if (isDivBy5) sb.append("Plang");
    if (isDivBy7) sb.append("Plong");
    if (!(isDivBy3 || isDivBy5 || isDivBy7)) sb.append(number);

    return sb.toString();
  }

}
