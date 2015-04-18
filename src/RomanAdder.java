import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanAdder {
   private static final String[] NUMERALS = { "M", "D", "C", "L", "X", "V", "I" };
   private static Pattern p;

   public RomanAdder() {
      if (p == null)
         p = Pattern.compile("(?!$)(" + String.join("*)(", NUMERALS) + "*)");
   }

   public String add(String a, String b) {
      Matcher mA = p.matcher(a), mB = p.matcher(b);
      validate(mA, a);
      validate(mB, b);

      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= NUMERALS.length; i++) {
         sb.append(mA.group(i));
         sb.append(mB.group(i));
      }

      try {
         String res = reduce(sb.toString());
         validate(res);
         return res;
      } catch (NumberOutOfRangeException e) {
         throw new ResultOutOfRangeException();
      }
   }

   private void validate(Matcher m, String s) {
      if (!m.matches())
         throw new NumberFormatException("Invalid Roman number: '" + s + "'");
      validate(s);
   }

   private void validate(String s) {
      if (s.matches("M{5}.*"))
         throw new NumberOutOfRangeException(s);
   }

   private String reduce(String s) {
      for (int i = NUMERALS.length - 1; i > 0; i--) {
         s = s.replaceFirst(
                 NUMERALS[i] + "{" + (i % 2 == 0 ? 5 : 2) + "}",
                 NUMERALS[i - 1]);
      }
      return s;
   }
}
