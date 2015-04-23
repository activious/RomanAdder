import java.util.regex.Matcher;

public class RomanAdder {
   private RomanNumberValidator validator;
   private RomanNumberNormalizer normalizer;

   public RomanAdder() {
      validator = new RomanNumberValidator();
      normalizer = new RomanNumberNormalizer(validator);
   }

   public String add(String a, String b) {
      Matcher mA = validator.match(a), mB = validator.match(b);
      // Make sure operands normalize without issues
      normalizer.reduce(a);
      normalizer.reduce(b);

      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= RomanNumeral.values().length; i++) {
         sb.append(mA.group(i));
         sb.append(mB.group(i));
      }

      try {
         return normalizer.reduce(sb.toString());
      } catch (NumberOutOfRangeException e) {
         throw new ResultOutOfRangeException();
      }
   }
}
