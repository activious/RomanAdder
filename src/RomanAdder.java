import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanAdder {
   private static final String[] NUMERALS = { "M", "D", "C", "L", "X", "V", "I" };
   private static Pattern p;

   static {
      p = Pattern.compile("(" + String.join("*)(", NUMERALS) + "*)");
   }

   public String add(String a, String b) {
      Matcher mA = p.matcher(a), mB = p.matcher(b);
      if (!mA.matches() || !mB.matches())
         return null;

      String res = "";
      for (int i = 1; i <= NUMERALS.length; i++)
         res += mA.group(i) + mB.group(i);

      res = res.replaceFirst("I{5}", "V");
      res = res.replaceFirst("V{2}", "X");
      res = res.replaceFirst("X{5}", "L");
      res = res.replaceFirst("L{2}", "C");
      res = res.replaceFirst("C{5}", "D");
      res = res.replaceFirst("D{2}", "M");
      return res;
   }
}
