package numbers;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by c246T on 20.10.2014.
 */
public class PrimeNumber {

   @Test
   public void isPrimeTest(){

       Assert.assertEquals(isPrime(3), true);
   }


    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
