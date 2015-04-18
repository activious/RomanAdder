import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanAdder {
   public String add(String a, String b) {
      Pattern p = Pattern.compile("(X*)(V*)(I*)");
      Matcher mA = p.matcher(a), mB = p.matcher(b);
      String res = "";
      if (!mA.matches() || !mB.matches())
         return null;
      res += mA.group(1) + mB.group(1);
      res += mA.group(2) + mB.group(2);
      res += mA.group(3) + mB.group(3);
      res = res.replaceFirst("I{5}", "V");
      res = res.replaceFirst("V{2}", "X");
      return res;
   }
}
