import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;
/**
*Class that read files and creates a list of Baked Item objects.
*
*@author Xander Siodlarz - COMP 1210 - 001
*@version November 11, 2022
*/
public class BakedItemList {
   private String listName;
   private BakedItem[] itemList;
   private int itemCount;
   private String[] excludedRecords;
   private int excludedCount;
   private static int listCount = 0;
   /**
   *Constructor for BakedItemList. Initializes instance fields
   *and increments listCount.
   */
   public BakedItemList() {
      listName = "";
      itemList = new BakedItem[100];
      itemCount = 0;
      excludedRecords = new String[30];
      excludedCount = 0;
      listCount++;
   }
   /**
   *Getter method to retrieve listName instance field.
   *@return listName - String instance field
   */
   public String getListName() {
      return listName;
   }
   /**
   *Setter method to update listName instance field.
   *@param newLN - String to update listName
   */
   public void setListName(String newLN) {
      listName = newLN;
   }
   /**
   *Getter method to retrieve itemList instance field.
   *@return itemList - BakedItem[] instance field
   */
   public BakedItem[] getItemList() {
      return itemList;
   }
   /**
   *Setter method to update itemList instance field.
   *@param newArray - String to update itemList
   */
   public void setItemList(BakedItem[] newArray) {
      itemList = newArray;
   }
   /**
   *Getter method to retrieve itemCount instance field.
   *@return itemCount - int instance field
   */
   public int getItemCount() {
      return itemCount;
   }
   /**
   *Setter method to update itemCount instance field.
   *@param updateIC - String to update itemCount
   */
   public void setItemCount(int updateIC) {
      itemCount = updateIC;
   }
   /**
   *Getter method to retrieve excludedRecords instance field.
   *@return excludedRecords - String[] instance field
   */
   public String[] getExcludedRecords() {
      return excludedRecords;
   }
   /**
   *Setter method to update excludedRecords instance field.
   *@param newArray - String to update excludedRecords
   */
   public void setExcludedRecords(String[] newArray) {
      excludedRecords = newArray;
   }
   /**
   *Getter method to retrieve excludedCount instance field.
   *@return excludedCount - int instance field
   */
   public int getExcludedCount() {
      return excludedCount;
   }
   /**
   *Setter method to update excludedCount instance field.
   *@param updateEC - String to update excludedCount
   */
   public void setExcludedCount(int updateEC) {
      excludedCount = updateEC;
   }
   /**
   *Getter method to retrieve listCount instance field.
   *@return listCount - int instance field
   */
   public static int getListCount() {
      return listCount;
   }
   /**
   *method to reset listCount by setting its value back to 0.
   */
   public static void resetListCount() {
      listCount = 0;
   }
   /**
   *Method that takes in a file and reads it, extracting a BakedItemList
   *name as well as reading/creating BakedItem objects and adding them to 
   *the BakedItemList.
   *
   *@param fileName - String representing the name of the file being read
   *@throws FileNotFoundException - Makes method cover all possibilties
   */
   public void readItemFile(String fileName) 
      throws FileNotFoundException {
      Scanner readIn = new Scanner(new File(fileName));
      setListName(readIn.nextLine());
      String bakedItemLine;
      while (readIn.hasNext()) {
         bakedItemLine = readIn.nextLine();
         try 
         {
            Scanner readBakedItem = new Scanner(bakedItemLine);
            readBakedItem.useDelimiter(",");
            String type = readBakedItem.next();
            String name = readBakedItem.next();
            String flavor = readBakedItem.next();
            int quantity = Integer.parseInt(readBakedItem.next());
            double crustCost = 0.0;
            int layers = 0;
            int tiers = 0;
            if (type.equals("P")) {
               crustCost = Double.parseDouble(readBakedItem.next());
            }
            else if (type.equals("K")) {
               layers = Integer.parseInt(readBakedItem.next());
            }
            else if (type.equals("W")) {
               layers = Integer.parseInt(readBakedItem.next());
               tiers = Integer.parseInt(readBakedItem.next());
            }
            else if (type.equals("C")) {
               int x = 0;
            }
            else {
               throw new InvalidCategoryException(type); 
            }
            int tempCount = 0;
            String[] tempArray = new String[50];
            for (int i = 0; i < 50; i++) {
               if (readBakedItem.hasNext()) {
                  tempArray[i] = readBakedItem.next();
                  tempCount++;
               }
               else {
                  break;
               }
            }
            String[] ingArray = Arrays.copyOf(tempArray, tempCount);
            if (type.equals("C")) {
               Cookie validItem = new Cookie(name, flavor, quantity, ingArray);
               for (int i = 0; i < itemList.length; i++) {
                  if (itemList[i] == null) { 
                     itemList[i] = validItem;
                     itemCount++;
                     break;
                  }
               }
            }
            else if (type.equals("P")) {
               Pie validItem = new Pie(name, flavor, quantity, 
                  crustCost, ingArray);
               for (int i = 0; i < itemList.length; i++) {
                  if (itemList[i] == null) { 
                     itemList[i] = validItem;
                     itemCount++;
                     break;
                  }
               }
            }
            else if (type.equals("K")) {
               Cake validItem = new Cake(name, flavor, quantity, 
                  layers, ingArray);
               for (int i = 0; i < itemList.length; i++) {
                  if (itemList[i] == null) { 
                     itemList[i] = validItem;
                     itemCount++;
                     break;
                  }
               }
            }
            else if (type.equals("W")) {
               WeddingCake validItem = new WeddingCake(name, flavor, quantity, 
                  layers, tiers, ingArray);
               for (int i = 0; i < itemList.length; i++) {
                  if (itemList[i] == null) { 
                     itemList[i] = validItem;
                     itemCount++;
                     break;
                  }
               }
            }
         }
         catch (InvalidCategoryException e) { 
            for (int i = 0; i < excludedRecords.length; i++) {
               if (excludedRecords[i] == null) { 
                  excludedRecords[i] = "*** " + e + " in:\n" + bakedItemLine;
                  break;
               }
            } 
            excludedCount++;
         }
         catch (NumberFormatException e)
         {
            String obj = "*** " + e + " in:\n" + bakedItemLine;
            for (int i = 0; i < excludedRecords.length; i++) {
               if (excludedRecords[i] == null) { 
                  excludedRecords[i] = obj;
                  break;
               }
            }
            excludedCount++;
         }
         catch (NoSuchElementException e)
         { 
            String obj = "*** " + e + " in:\n" + bakedItemLine;
            for (int i = 0; i < excludedRecords.length; i++) {
               if (excludedRecords[i] == null) { 
                  excludedRecords[i] = obj;
                  break;
               }
            }
            excludedCount++;
         }  
      }
   }
   /**
   *Method that generates a readable string report for BakedItemList
   *based on the order that it was in the file.
   *
   *@return output - String representing the report
   */
   public String generateReport() { 
      String output = "\n---------------------------------------\n"
         + "Report for " + listName
         + "\n---------------------------------------\n";
      for (int i = 0; i < itemList.length; i++) {
         if (itemList[i] != null) {
            output += "\n" + itemList[i].toString() + "\n";
         }
      }
      return output;
   }
   /**
   *Method that generates a readable string report for BakedItemList
   *based on the order of the specific class(alphabetical).
   *
   *@return output - String representing the report
   */
   public String generateReportByClass() { 
      String output = "\n---------------------------------------\n"
         + "Report for " + listName
         + " (by Class)\n---------------------------------------\n";
      BakedItem[] bList = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(bList);
      for (int i = 0; i < bList.length; i++) {
         if (bList[i] != null) {
            output += "\n" + bList[i].toString() + "\n";
         }
      }
      return output;
   }
   /**
   *Method that generates a readable string report for BakedItemList
   *based on the order of the price of each BakedItem.
   *
   *@return output - String representing the report
   */
   public String generateReportByPrice() { 
      String output = "\n---------------------------------------\n"
         + "Report for " + listName
         + " (by Price)\n---------------------------------------\n";
      BakedItem[] bList = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(bList, new PriceComparator());
      for (int i = 0; i < bList.length; i++) {
         if (bList[i] != null) {
            output += "\n" + bList[i].toString() + "\n";
         }
      }
      return output;
   }
   /**
   *Method that generates a readable string report for BakedItemList
   *based on the order of the flavor of each BakedItem(alphabetical).
   *
   *@return output - String representing the report
   */
   public String generateReportByFlavor() { 
      String output = "\n---------------------------------------\n"
         + "Report for " + listName
         + " (by Flavor)\n---------------------------------------\n";
      BakedItem[] bList = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(bList, new FlavorComparator());
      for (int i = 0; i < bList.length; i++) {
         if (bList[i] != null) {
            output += "\n" + bList[i].toString() + "\n";
         }
      }
      return output;
   }
   /**
   *Method that generates a readable string report for excludedRecords.
   *
   *@return output - String representing the report
   */
   public String generateExcludedRecordsReport() { 
      String output = "\n---------------------------------------\n"
         + "Excluded Records Report"
         + "\n---------------------------------------\n";
      for (int i = 0; i < excludedRecords.length; i++) {
         if (excludedRecords[i] != null) {
            output += "\n" + excludedRecords[i].toString();
         }
      }
      return output;
   }
}