import org.junit.Assert;
import org.junit.Test;

/** 
 *@Author: Jacob Stockwell
 *@version: 01-16-19
**/

public class SelectorTest {

   
   /** Test to find the min in an array. **/
   
   @Test public void findMinTest() {
   
      int[] a = {5, 9, 1, 7, 3};
      int[] b = {2, 8, 7, 3, 4};
      
      int expected = 1;
      int expected2 = 2;
      
      int actual = Selector.min(a);
      int actual2 = Selector.min(b);
      
      Assert.assertEquals(expected, actual);
      Assert.assertEquals(expected2, actual2);
      
      
   
   
   }
   
   /** Test to find the max in an array. **/
   
   @Test public void findMaxTest() {
   
      int[] a = {5, 9, 1, 7, 3};
      int[] b = {2, 8, 7, 3, 4};
      
      int expected = 9;
      int expected2 = 8;
      
      int actual = Selector.max(a);
      int actual2 = Selector.max(b);
      
      Assert.assertEquals(expected, actual);
      Assert.assertEquals(expected2, actual2);
      
      
   
   
   }
   
   /** Test to find the range of the array**/
   
   @Test public void findRangeTest() {
   
      int[] a = {2, 8, 7, 3, 4};
      
      int low = 1;
      int high = 5;
      
      int [] expected = {2,3,4}; 
      int[] actual = Selector.range(a, 1, 5);
      
      Assert.assertEquals(expected, actual);
      
      
   
   
   }
   
   
   /** Test to find the ceiling in an array. **/
   
   @Test public void ceilingTest() {
   
      int[] a = {2,8,8,7,3,3,4};
      
      int expected = 7;
      int key = 5;
      
      int actual = Selector.ceiling(a, key);
      
      
      Assert.assertEquals(expected, actual);
      
      
      int[] b = {8, 7, 6, 5, 4};
      
      int expected2 = 4;
      int key2 = 0;
      
      int actual2 = Selector.ceiling(b, key2);
      
      Assert.assertEquals(expected2, actual2);
      
      
   
   
   }
   
   @Test public void floorTest () {
   
      int[] a = {8, 7, 6, 5, 4};
      
      int expected = 4;
      int key = 6;
      
      int actual = Selector.floor(a, key);
      
      Assert.assertEquals(expected, actual);
      
      
      int[] b = {5, 9, 1, 7, 3};
      
      int expected2 = 1;
      int key2 = 1;
      
      int actual2 = Selector.floor(b, key2);
      
      Assert.assertEquals(expected2, actual2);
   
   
   
   
   } 
   
   /** Test to find the kmin **/
   
   @Test public void kminTest () {
   
      int[] a = {2, 8, 7, 3, 4};
      int[] b = {8, 7, 6, 5, 4};
      
      int key = 1;
      int key2 = 5;
      
      int expected = 2;
      int expected2 = 8;
      
      int actual = Selector.kmin(a, key);
      int actual2 = Selector.kmin(b, key2);
      
      Assert.assertEquals(expected, actual);
      Assert.assertEquals(expected2, actual2);
      
   
   
   }
   
   /** Test to find the kmax **/
   
   @Test public void kmaxTest () {
   
      int[] a = {2, 8, 7, 3, 4};
      int[] b = {5, 9, 1, 7, 3};
      
      int key = 1;
      int key2 = 3;
      
      int expected = 8;
      int expected2 = 5;
      
      int actual = Selector.kmax(a, key);
      int actual2 = Selector.kmax(b, key2);
      
      Assert.assertEquals(expected, actual);
      Assert.assertEquals(expected2, actual2);
      
   
   
   }
   
}
