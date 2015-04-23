import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanAdder {
   private RomanNumberValidator validator;
   private RomanNumberNormalizer normalizer;

   public RomanAdder() {
      validator = new RomanNumberValidator();
      normalizer = new RomanNumberNormalizer(validator);
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
         return normalizer.normalize(sb.toString());
      } catch (NumberOutOfRangeException e) {
         throw new ResultOutOfRangeException();
      }
   }
}
