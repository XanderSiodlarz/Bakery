import java.io.FileNotFoundException;
/**
*Class that implements method from BaeryItemList
*and prints them out.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 18, 2022
*/
public class BakeryPart3 {
   /**
   *Main method to print out reports from BakedItemList
   *or raise and catch exceptions.
   *
   *@param args command line used to read in file name
   *@throws InvalidCategoryException - to catch exception 
   *when using readItemFile method
   */
   public static void main(String[] args) throws InvalidCategoryException {
      if (args.length == 0) {
         System.out.println("File name expected as command line argument."
            + "\nProgram ending.");
      }
      else {
         BakedItemList bIL = new BakedItemList();
         try {
            bIL.readItemFile(args[0]);
            System.out.println(bIL.generateReport());
            System.out.println(bIL.generateReportByClass());
            System.out.println(bIL.generateReportByPrice());
            System.out.println(bIL.generateReportByFlavor());
            System.out.println(bIL.generateExcludedRecordsReport());
         }
         catch (FileNotFoundException e) 
         {
            System.out.println("Attempted to read file: " 
               + args[0] + " (No such file or directory)\n" 
               + "Program ending.");
         }
         
      }
   }
}