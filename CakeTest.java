import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**Class to test the Cake class.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 4, 2022
*/
public class CakeTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that covers methods in the Cake class. **/
   @Test public void cakeTest() {
      String[] cakeArray = {"butter", "milk", "eggs"};
      Cake cake1 = new Cake("Single", "Layer", 1, 10, cakeArray);
      cake1.setLayers(1);
      Assert.assertEquals("Cake: Single - Layer   Quantity: 1   Price: $8.00"
         + "\n(Ingredients: butter, milk, eggs)", cake1.toString());
      Assert.assertEquals(1, cake1.getLayers());
   }
}
