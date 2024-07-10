import java.util.Comparator;
/**
*Class that implements the Comparator interface for BakedItem class.
*Overrides the compare method by the price of BakedItems.

*@author Xander Siodlarz - COMP 1210 - 001
*@version November 11, 2022
*/
public class PriceComparator implements Comparator<BakedItem> {
   /**
   *Method inherited from Comparator interface, which is used to campare
   *two BakedItem objects in a specific scenario(price).
   *
   *@param b1 - BakedItem used to compare to the other parameter b2
   *@param b2 - BakedItem used to compare to the other parameter b1
   *@return 1 - int if the price of b1 is greater than b2 price,
   *-1, if b2 price > b1 price, and 0 if they are equal.
   */
   public int compare(BakedItem b1, BakedItem b2) {
      if (b1.price() > b2.price()) {
         return 1;
      }
      else if (b2.price() > b1.price()) {
         return -1;
      }
      else {
         return 0;
      }
   }
}