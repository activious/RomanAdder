import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RomanAdderTest {
   RomanAdder adder;

   @Rule
   public ExpectedException thrown = ExpectedException.none();

   @Before
   public void setup() {
      adder = new RomanAdder();
   }

   @Test // TC1
   public void testIplusIisII() {
      String res = adder.add("I", "I");
      assertEquals("II", res);
   }

   @Test // TC2
   public void testIIIIplusIisV() {
      String res = adder.add("IIII", "I");
      assertEquals("V", res);
   }

   @Test // TC3
   public void testVplusIisVI() {
      String res = adder.add("V", "I");
      assertEquals("VI", res);
   }

   @Test // TC4
   public void testIplusVisVI() {
      String res = adder.add("I", "V");
      assertEquals("VI", res);
   }

   @Test // TC5
   public void testVIIIIplusIisX() {
      String res = adder.add("VIIII", "I");
      assertEquals("X", res);
   }

   @Test // TC6
   public void testXplusIisXI() {
      String res = adder.add("X", "I");
      assertEquals("XI", res);
   }

   @Test // TC7
   public void testXXXXVIIIIplusIisL() {
      String res = adder.add("XXXXVIIII", "I");
      assertEquals("L", res);
   }

   @Test // TC8
   public void testLplusIisLI() {
      String res = adder.add("L", "I");
      assertEquals("LI", res);
   }

   @Test // TC9
   public void testLXXXXVIIIIplusIisC() {
      String res = adder.add("LXXXXVIIII", "I");
      assertEquals("C", res);
   }

   @Test // TC10
   public void testCplusIisCI() {
      String res = adder.add("C", "I");
      assertEquals("CI", res);
   }

   @Test // TC11
   public void testCCCCLXXXXVIIIIplusIisD() {
      String res = adder.add("CCCCLXXXXVIIII", "I");
      assertEquals("D", res);
   }

   @Test // TC12
   public void testDplusIisCI() {
      String res = adder.add("D", "I");
      assertEquals("DI", res);
   }

   @Test // TC13
   public void testDCCCCLXXXXVIIIIplusIisM() {
      String res = adder.add("DCCCCLXXXXVIIII", "I");
      assertEquals("M", res);
   }

   @Test // TC14
   public void testMplusIisMI() {
      String res = adder.add("M", "I");
      assertEquals("MI", res);
   }

   @Test // TC15
   public void testMMMMDCCCCLXXXXVIIIIplusIisOutOfRange() {
      thrown.expect(ResultOutOfRangeException.class);
      adder.add("MMMMDCCCCLXXXXVIIII", "I");
   }

   @Test // TC16
   public void testMMMMMplusIisOutOfRange() {
      thrown.expect(NumberOutOfRangeException.class);
      adder.add("MMMMM", "I");
   }

   @Test // TC17
   public void testIplusMMMMMisOutOfRange() {
      thrown.expect(NumberOutOfRangeException.class);
      adder.add("I", "MMMMM");
   }

   @Test // TC18
   public void testMMMMplusMIisOutOfRange() {
      thrown.expect(ResultOutOfRangeException.class);
      adder.add("MMMM", "MI");
   }

   @Test // TC19
   public void testIVplusIisInvalid() {
      thrown.expect(NumberFormatException.class);
      adder.add("IV", "I");
   }
}
