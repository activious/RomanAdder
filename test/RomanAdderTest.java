import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RomanAdderTest {
   RomanAdder adder;

   @Before
   public void setup() {
      adder = new RomanAdder();
   }

   @Test
   public void testIplusIisII() {
      String res = adder.add("I", "I");
      assertEquals("II", res);
   }

   @Test
   public void testIIIIplusIisV() {
      String res = adder.add("IIII", "I");
      assertEquals("V", res);
   }
}
