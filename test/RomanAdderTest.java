import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by khk on 18-Apr-15.
 */
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
}
