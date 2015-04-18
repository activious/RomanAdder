public class RomanAdder {
   private enum Numeral {
      M, D, C, L, X, V, I
   }

   public String add(String a, String b) {
      String res = a + b;
      res = res.replaceFirst("I{5}", "V");
      return res;
   }
}
