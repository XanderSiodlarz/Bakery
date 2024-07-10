import java.util.Comparator;
/**
*Class that implements the Comparator interface for BakedItem class.
*Overrides the compare method by the flavor of BakedItems.

*@author Xander Siodlarz - COMP 1210 - 001
*@version November 11, 2022
*/
public class FlavorComparator implements Comparator<BakedItem> {
   /**
   *Method inherited from Comparator interface, which is used to campare
   *two BakedItem objects in a specific scenario(flavor).
   *
   *@param b1 - BakedItem used to compare to the other parameter b2
   *@param b2 - BakedItem used to compare to the other parameter b1
   *@return 1 - int if the flavor of b1 is greater(String wise) than b2 flavor,
   *-1, if b2 flavor > b1 flavor, and 0 if they are equal.
   */
   public int compare(BakedItem b1, BakedItem b2) {
      if (b1.getFlavor().compareToIgnoreCase(b2.getFlavor()) < 0) {
         return -1;
      }
      else if (b1.getFlavor().compareToIgnoreCase(b2.getFlavor()) > 0) {
         return 1;
      }
      else {
         return 0;
      }
   }
}
