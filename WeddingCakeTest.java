import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**Class to test the WeddingCake class.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 4, 2022
*/
public class WeddingCakeTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that includes the methods of the WeddingCake class. **/
   @Test public void weddingCakeTest() {
      String[] wCakeArray = {"butter", "milk", "eggs"};
      WeddingCake wCake1 = new WeddingCake("Single", "Layer", 1, 1,
          10, wCakeArray);
      wCake1.setTiers(1);
      Assert.assertEquals("WeddingCake: Single - Layer   Quantity: 1   "
         + "Price: $15.00"
         + "\n(Ingredients: butter, milk, eggs)", wCake1.toString());
      Assert.assertEquals(1, wCake1.getTiers());
   }
}
