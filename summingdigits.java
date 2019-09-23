/*
Summing Digits
by:Isabella Rolfe 09/22/19
 */
public class summingdigits {
    public static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        } else {
            int sum = 0;
            sum += sumOfDigits(n / 10);
            sum += n % 10;
            return sum;
        }
    }

        public static void main (String[]args){
            System.out.println(sumOfDigits(1234));
        }
}
