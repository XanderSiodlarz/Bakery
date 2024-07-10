/**Class that contains functions for Pie and extends BakedItem.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 4, 2022
*/
public class Pie extends BakedItem {
   private double crust;
   /**Constant.*/
   public static final double BASE_RATE = 12.0;
   /**
   *
   *Constructor for Pie. 
   *
   *@param nameIn - String to update name
   *@param flavorIn - String to update flavor
   *@param qIn - int to update quantity
   *@param crustIn - double to update crust
   *@param ingIn - String[] to update ingredients
   */
   public Pie(String nameIn, String flavorIn, 
      int qIn, double crustIn, String... ingIn) {
      super(nameIn, flavorIn, qIn, ingIn);
      crust = crustIn;
   }
   /**
   *Method to retrieve crust instance field.
   *@return crust - double instance field
   */
   public double getCrustCost() {
      return crust;
   }
   /**
   *Method to update crust instance field.
   *@param crustIn - double to update crust instance field
   */
   public void setCrustCost(double crustIn) {
      crust = crustIn;
   }
   /**
   *Method to return the unique price of Pies.
   *Must be used do do inheritance.
   *
   *@return price - the price of Pies
   */
   public double price() {
      return (BASE_RATE + crust) * quantity;
   }
}