import java.util.regex.Matcher;

public class RomanAdder {
   private RomanNumberNormalizer normalizer;
   private RomanNumberValidator validator;

   public RomanAdder() {
      normalizer = new RomanNumberNormalizer();
      validator = new RomanNumberValidator(normalizer);
   }

   public String add(String a, String b) {
      Matcher mA = validator.match(a);
      Matcher mB = validator.match(b);

      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= RomanNumeral.values().length; i++) {
         sb.append(mA.group(i));
         sb.append(mB.group(i));
      }

      try {
         String res = normalizer.reduce(sb.toString());
         validator.validate(res);
         return res;
      } catch (NumberOutOfRangeException e) {
         throw new ResultOutOfRangeException();
      }
   }
}
