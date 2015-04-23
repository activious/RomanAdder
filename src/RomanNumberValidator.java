import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumberValidator implements Validator<String> {
   private static Pattern p;

   public RomanNumberValidator() {
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

   public Matcher match(String s) {
      Matcher m = p.matcher(s);
      if (!m.matches())
         throw new NumberFormatException("Invalid Roman number: '" + s + "'");
      return m;
   }

   @Override
   public void validate(String s) {
      // Valid range is I..MMMMDCCCCLXXXXVIIII
      if (s.matches("M{5}.*"))
         throw new NumberOutOfRangeException(s);
   }
}
