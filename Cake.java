/**Class that contains functions for Cake and extends BakedItem.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 4, 2022
*/
public class Cake extends BakedItem {
   /**Constant.*/
   public static final double BASE_RATE = 8.0;
   protected int layers;
   /**
   *
   *Constructor for Cake. 
   *
   *@param nameIn - String to update name
   *@param flavorIn - String to update flavor
   *@param qIn - int to update quantity
   *@param layerIn - int to update layers
   *@param ingIn - String[] to update ingredients
   */
   public Cake(String nameIn, String flavorIn, int qIn, 
      int layerIn, String... ingIn) {
      super(nameIn, flavorIn, qIn, ingIn);
      layers = layerIn;
   }
   /**
   *Method to retrieve layers instance field.
   *@return layers - int instance field
   */
   public int getLayers() {
      return layers;
   }
   /**
   *Method to update layers instance field.
   *@param layerIn - int to update layers instance field
   */
   public void setLayers(int layerIn) {
      layers = layerIn;
   }
   /**
   *Method to return the unique price of Cakes.
   *Must be used due inheritance.
   *
   *@return price - the price of Cakes
   */
   public double price() {
      return BASE_RATE * layers * quantity;
   
   }
}