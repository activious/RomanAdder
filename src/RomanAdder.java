import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanAdder {
   private RomanNumberValidator validator;

   public RomanAdder() {
      validator = new RomanNumberValidator();
   }

   public String add(String a, String b) {
      Matcher mA = validator.match(a), mB = validator.match(b);

      validator.validate(a);
      validator.validate(b);

      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= RomanNumeral.values().length; i++) {
         sb.append(mA.group(i));
         sb.append(mB.group(i));
      }

      try {
         String res = reduce(sb.toString());
         validator.validate(res);
         return res;
      } catch (NumberOutOfRangeException e) {
         throw new ResultOutOfRangeException();
      }
   }

   private String reduce(String s) {
      RomanNumeral[] numerals = RomanNumeral.values();
      for (int i = numerals.length - 1; i > 0; i--) {
         s = s.replaceAll(
                 numerals[i] + "{" + (i % 2 == 0 ? 5 : 2) + "}",
                 numerals[i - 1].toString());
      }
      return s;
   }
}
