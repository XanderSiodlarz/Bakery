import java.io.FileNotFoundException;
/**
*Class that contains a main method and used for command line readins of files.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 11, 2022
*/
public class BakeryPart2 {
   /**
   *Main method that uses command line to readin files as 
   *well use methods for BakedItemList.
   *
   *@param args - String[] either left empty or have a file name as input
   *@throws FileNotFoundException - Allows args to be empty in this scenario
   */
   public static void main(String[] args) throws FileNotFoundException {
      if (args.length == 0) {
         System.out.println("File name expected as command line argument."
            + "\nProgram ending.");
      }
      else {
         BakedItemList bIL = new BakedItemList();
         bIL.readItemFile(args[0]);
         System.out.println(bIL.generateReport());
         System.out.println(bIL.generateReportByClass());
         System.out.println(bIL.generateReportByPrice());
         System.out.println(bIL.generateReportByFlavor());
         System.out.println(bIL.generateExcludedRecordsReport());
      }  
   }
   
}