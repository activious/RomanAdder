import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanAdder {
   public String add(String a, String b) {
      Pattern p = Pattern.compile("(D*)(C*)(L*)(X*)(V*)(I*)");
      Matcher mA = p.matcher(a), mB = p.matcher(b);
      if (!mA.matches() || !mB.matches())
         return null;
      String res = "";
      res += mA.group(1) + mB.group(1);
      res += mA.group(2) + mB.group(2);
      res += mA.group(3) + mB.group(3);
      res += mA.group(4) + mB.group(4);
      res += mA.group(5) + mB.group(5);
      res += mA.group(6) + mB.group(6);
      res = res.replaceFirst("I{5}", "V");
      res = res.replaceFirst("V{2}", "X");
      res = res.replaceFirst("X{5}", "L");
      res = res.replaceFirst("L{2}", "C");
      res = res.replaceFirst("C{5}", "D");
      res = res.replaceFirst("D{2}", "M");
      return res;
   }
}
