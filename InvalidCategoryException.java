/**
*Class to create an exception when a category read is invalid.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 18, 2022
*/

public class InvalidCategoryException extends Exception {
   /**
   *Constructor for InvalidCategoryException.
   *Implements super() from Exception class to create
   *personalized message.
   *
   *@param category - String that is a part of the personalized
   *message in the super method
   */
   public InvalidCategoryException(String category) {
      super("For category: " + "\"" + category + "\"");
      
   }
}