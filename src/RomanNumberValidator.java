import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumberValidator {
   private static Pattern p;

   private RomanNumberNormalizer normalizer;

   public RomanNumberValidator(RomanNumberNormalizer normalizer) {
      this.normalizer = normalizer;

      if (p == null)
         p = compilePattern();
   }

   private static Pattern compilePattern() {
      StringBuilder sb = new StringBuilder("(?!$)");
      for (RomanNumeral numeral : RomanNumeral.values()) {
         sb.append("(");
         sb.append(numeral);
         sb.append("*)");
      }
      return Pattern.compile(sb.toString());
   }

   public RomanNumberNormalizer getNormalizer() {
      return normalizer;
   }

   public void setNormalizer(RomanNumberNormalizer normalizer) {
      this.normalizer = normalizer;
   }

   public Matcher match(String s) {
      String orig = s;
      s = normalizer.normalize(s);

      Matcher m = p.matcher(s);
      if (!m.matches())
         throw new NumberFormatException("Invalid Roman number: '" + orig + "'");

      validate(s);
      return m;
   }

   public void validate(String s) {
      // Valid range is I..MMMMDCCCCLXXXXVIIII
      if (normalizer.reduce(s).matches("M{5}.*"))
         throw new NumberOutOfRangeException(s);
   }
}
