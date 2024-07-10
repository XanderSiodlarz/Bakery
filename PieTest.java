import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**Class to test the Pie class.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 4, 2022
*/
public class PieTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** test for the methods that the Pie class covers.*/
   @Test public void pieTest() {
      String[] pieArray = {"butter", "milk", "eggs"};
      Pie pie1 = new Pie("Apple", "Baked", 1, 9.00, pieArray);
      pie1.setCrustCost(0);
      Assert.assertEquals("Pie: Apple - Baked   Quantity: 1   Price: $12.00"
         + "\n(Ingredients: butter, milk, eggs)", pie1.toString());
      Assert.assertEquals(0, pie1.getCrustCost(), 0.00001);
   }
}
