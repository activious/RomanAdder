public class NumberOutOfRangeException extends RuntimeException {
   public NumberOutOfRangeException(String number) {
      super("Number is out of range: " + number);
   }
}
