/**Class that contains functions for Cookie and extends BakedItem.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 4, 2022
*/
public class Cookie extends BakedItem {
   /**Constant.*/
   public static final double BASE_RATE = 0.35;
   /**
   *
   *Constructor for Cookie. 
   *
   *@param nameIn - String to update name
   *@param flavorIn - String to update flavor
   *@param qIn - int to update quantity
   *@param ingIn - String[] to update ingredients
   */
   public Cookie(String nameIn, String flavorIn, int qIn, String... ingIn) {
      super(nameIn, flavorIn, qIn, ingIn);
   }
   /**
   *Method to return the unique price of Cookies.
   *Must be used do do inheritance.
   *
   *@return price - the price of Cookies
   */
   public double price() {
      return BASE_RATE * quantity;
   }
}