import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

public class BakeryPart2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void defaultTest() throws FileNotFoundException{
      BakedItemList.resetListCount();
      String[] args1 = {"baked_item_data.csv"};
      BakeryPart2.main(args1);
      Assert.assertEquals("Baked Item List should be 1. ", 1, BakedItemList.getListCount());
      }
}
