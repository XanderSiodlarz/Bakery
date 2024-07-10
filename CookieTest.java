import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**Class to test the Cookie class.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 4, 2022
*/
public class CookieTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Test for the Cookie Class as well as setIngredients method.**/
   @Test public void cookieClassTest() {
      String[] cookieArray = {"butter", "milk", "eggs"};
      String[] wrongList = {"wrong"};
      Cookie cook1 = new Cookie("Choc Chip", "Double Choc", 12, wrongList);
      cook1.setIngredients(cookieArray);
      Assert.assertEquals("Cookie: Choc Chip - Double Choc"
         + "   Quantity: 12   Price: $4.20"
         + "\n(Ingredients: butter, milk, eggs)", cook1.toString());
   }
}
