import java.text.DecimalFormat;
/**Class that contains functions for BakedItems and all subclasses.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 4, 2022
*/
public abstract class BakedItem implements Comparable<BakedItem> {
   
   protected String name;
   protected String flavor;
   protected int quantity;
   protected String[] ingredients;
   protected static int count = 0;
   /**
   *
   *Constructor for BakedItem. Increments count as well.
   *
   *@param nameIn - String to update name
   *@param flavorIn - String to update flavor
   *@param quantityIn - int to update quantity
   *@param ingredientsIn - String[] to update ingredients
   */
   public BakedItem(String nameIn, String flavorIn, 
      int quantityIn, String... ingredientsIn) {
      name = nameIn;
      flavor = flavorIn;
      quantity = quantityIn;
      ingredients = ingredientsIn;
      count++;
   }
   /**
   *Method to retrieve name instance field.
   *@return name - String instance field
   */
   public String getName() {
      return name;
   }
   /**
   *Setter method to update name instance field.
   *@param newName - String to update name instance field
   */
   public void setName(String newName) {
      name = newName;
   }
   /**
   *Method to retrieve flavor instance field.
   *@return flavor - String instance field
   */
   public String getFlavor() {
      return flavor;
   }
   /**
   *Setter method to update flavor instance field.
   *@param newFlavor - String to update flavor instance field
   */
   public void setFlavor(String newFlavor) {
      flavor = newFlavor;
   }
   /**
   *Method to retrieve quantity instance field.
   *@return quantity - int instance field
   */
   public int getQuantity() {
      return quantity;
   }
   /**
   *Setter method to update quantity instance field.
   *@param newQuantity - int to update quantity instance field
   */
   public void setQuantity(int newQuantity) {
      quantity = newQuantity;
   }
   /**
   *Method to retrieve ingredients instance field.
   *@return ingredients - String[] instance field
   */
   public String[] getIngredients() {
      return ingredients;
   }
   /**
   *Setter method to update ingredients instance field.
   *@param newIngredients - String[] to update ingredients instance field
   */
   public void setIngredients(String... newIngredients) {
      ingredients = newIngredients;
   }
   /**
   *Static method to retrieve count instance field.
   *@return count - int static instance field
   */
   public static int getCount() {
      return count;
   }
   /**
   *Static method to reset count instance field
   *back to 0.
   */
   public static void resetCount() {
      count = 0;
   }
   /**
   *Method to turn an object instantiation into something readable 
   *to the viewer.
   *
   *@return initString - String representing the object
   */
   public final String toString() {
      DecimalFormat df = new DecimalFormat("$#,##0.00");
      String initString = this.getClass().toString().substring(6) 
         + ": " + getName()
         + " - " + getFlavor() + "   Quantity: " + getQuantity() + "   Price: "
         + df.format(price()) + "\n(Ingredients: ";
      for (int i = 0; i < ingredients.length - 1; i++) {
         if (i == 4) {
            initString += ingredients[i] + ", \n";
            continue;
         }
         initString += ingredients[i] + ", ";
      }
      initString += ingredients[ingredients.length - 1] + ")";
      return initString;
   }
   /**
   *Absract method that is used in subclasses.
   *@return price - double 
   */
   public abstract double price();
   /**
   *Overrides method from the comparable interface. Compares
   *two BakedItem objects.
   *
   *@param compItem - BakedItem that is being compared to
   *@return int - -1, 0 , 1 - int depending on which object is greater than 
   *the other(alphabetically using toString()
   */
   public int compareTo(BakedItem compItem) {
      String firstUpper = toString().toLowerCase();
      String secondUpper = compItem.toString().toLowerCase();
      if (firstUpper.compareTo(secondUpper) < 0) {
         return -1;
      }
      else if (firstUpper.compareTo(secondUpper) > 0) {
         return 1;
      }
      else {
         return 0;
      }
   }
}