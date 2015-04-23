public class RomanNumberNormalizer {
   public String normalize(String s) {
      // Reduce
      RomanNumeral[] numerals = RomanNumeral.values();
      for (int i = numerals.length - 1; i > 0; i--) {
         s = s.replaceAll(
                 numerals[i] + "{" + (i % 2 == 0 ? 5 : 2) + "}",
                 numerals[i - 1].toString());
      }
      return s;
   }
}
