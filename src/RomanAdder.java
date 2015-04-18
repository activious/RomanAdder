import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanAdder {
   private static final String[] NUMERALS = {"M", "D", "C", "L", "X", "V", "I"};
   private static Pattern p;

   static {
      p = Pattern.compile("(" + String.join("*)(", NUMERALS) + "*)");
   }

   public String add(String a, String b) {
      Matcher mA = p.matcher(a), mB = p.matcher(b);
      if (!mA.matches() || !mB.matches())
         return null;

      StringBuilder res = new StringBuilder();
      for (int i = 1; i <= NUMERALS.length; i++) {
         res.append(mA.group(i));
         res.append(mB.group(i));
      }

      return reduce(res.toString());
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
