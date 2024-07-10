/**Class that contains functions for WeddingCake and extends BakedItem.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 4, 2022
*/
public class WeddingCake extends Cake {
   private int tiers;
   /**Constant.*/
   public static final double BASE_RATE = 15.0;
   /**
   *
   *Constructor for WeddingCake. 
   *
   *@param nameIn - String to update name
   *@param flavorIn - String to update flavor
   *@param qIn - int to update quantity
   *@param layerIn - int to update layers
   *@param tierIn - int to update tiers
   *@param ingIn - String[] to update ingredients
   */
   public WeddingCake(String nameIn, String flavorIn, 
      int qIn, int layerIn, int tierIn, String... ingIn) {
      super(nameIn, flavorIn, qIn, layerIn, ingIn);
      tiers = tierIn;
   }
   /**
   *Method to retrieve tiers insstance field.
   *@return tiers - int instance field
   */
   public int getTiers() {
      return tiers;
   }
   /**
   *Method to update tiers instance field.
   *@param tierIn - int to update tiers
   */
   public void setTiers(int tierIn) {
      tiers = tierIn;
   }
   /**
   *Method to return the unique price of Wedding Cakes.
   *Must be used do do inheritance.
   *
   *@return price - the price of Wedding Cakes
   */
   public double price() {
      return BASE_RATE * layers * tiers * quantity;
   }
   
}