import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumberValidator implements Validator<String> {
   private static Pattern p;

   private RomanNumberNormalizer normalizer;

   public RomanNumberValidator() {
      this(null);
   }

   public RomanNumberValidator(RomanNumberNormalizer normalizer) {
      this.normalizer = normalizer;

      if (p == null) {
         StringBuilder sb = new StringBuilder("(?!$)");
         for (RomanNumeral numeral : RomanNumeral.values()) {
            sb.append("(");
            sb.append(numeral);
            sb.append("*)");
         }
         p = Pattern.compile(sb.toString());
      }
   }

   public RomanNumberNormalizer getNormalizer() {
      return normalizer;
   }

   public void setNormalizer(RomanNumberNormalizer normalizer) {
      this.normalizer = normalizer;
   }

   public Matcher match(String s) {
      String orig = s;
      if (normalizer != null)
         s = normalizer.normalize(s);

      Matcher m = p.matcher(s);
      if (!m.matches())
         throw new NumberFormatException("Invalid Roman number: '" + orig + "'");

      if (normalizer != null)
         s = normalizer.reduce(s);

      validate(s);
      return m;
   }

   @Override
   public void validate(String s) {
      // Valid range is I..MMMMDCCCCLXXXXVIIII
      if (s.matches("M{5}.*"))
         throw new NumberOutOfRangeException(s);
   }
}
