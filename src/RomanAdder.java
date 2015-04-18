import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanAdder {
   private static final String[] NUMERALS = {"M", "D", "C", "L", "X", "V", "I"};
   private static Pattern p;

   public RomanAdder() {
      if (p == null)
         p = Pattern.compile("(" + String.join("*)(", NUMERALS) + "*)");
   }

   public String add(String a, String b) {
      Matcher mA = p.matcher(a), mB = p.matcher(b);
      if (!mA.matches() || !mB.matches())
         return null;

      if (a.matches("M{5,}"))
         throw new NumberOutOfRangeException(a);

      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= NUMERALS.length; i++) {
         sb.append(mA.group(i));
         sb.append(mB.group(i));
      }

      String res = reduce(sb.toString());
      if (res.matches("M{5,}"))
         throw new ResultOutOfRangeException();

      return res;
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
