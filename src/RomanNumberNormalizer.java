public class RomanNumberNormalizer {
   private Validator<String> validator;

   public RomanNumberNormalizer(Validator<String> validator) {
      this.validator = validator;
   }

   public String normalize(String s) {
      // Bring to reduced format
      String res = s;
      RomanNumeral[] numerals = RomanNumeral.values();
      for (int i = numerals.length - 1; i > 0; i--) {
         res = res.replaceAll(
                 numerals[i] + "{" + (i % 2 == 0 ? 5 : 2) + "}",
                 numerals[i - 1].toString());
      }

      validator.validate(res);
      return res;
   }
}
