import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumberValidator {
   private static Pattern p;

   public RomanNumberValidator() {
      if (p == null) {
         StringBuilder sb = new StringBuilder("(?!$)");
         for (RomanNumeral numeral : RomanNumeral.values())
            sb.append("(" + numeral + "*)");
         p = Pattern.compile(sb.toString());
      }
   }

   public Matcher match(String s) {
      Matcher m = p.matcher(s);
      if (!m.matches())
         throw new NumberFormatException("Invalid Roman number: '" + s + "'");
      return m;
   }
}
