import java.util.Arrays;
import java.util.Collections;
/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Jacob Stockwell (JTS0098@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  01-29-19
*
*/
 
public final class Selector {
 
 /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }
 
 /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @param a is an array of integers.
    * @return min is the minimum value of the array.
    */
 
   public static <T> T min(Collection<T> c, Comparator<T> comp) {
   
      if (collection == null || comparator == null) {
         throw new IllegalArgumentException();
      }
   
      int min = a[0]; 
      
      if (collection.size() == 0) {
         throw new NoSuchEllementException();
      }
      
      for (int i = 0; i < a.length; i++) {
      
         if (a[i] < min) {
         
            min = a[i];
         
         }
          
      }
   
      return min;
      
   }
   
   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @param a is an array of integers.
    * @return max is the maximum of the array.
    */
   
   public static int max(int[] a) {
   
      if (a == null || a.length == 0) { // checks to see if array length 
         throw new IllegalArgumentException();
      }
   
      int max = a[0]; 
      
      for (int i = 0; i < a.length; i++) { // goes through the array 
      
         if (a[i] > max) {
         
            max = a[i];
         
         }
          
      }
   
      return max;
      
   }
   
   /** 
    *
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    *@param a for the array
    *@param low for the low val
    *@param high for the high val
    *@return b for the range 
    *@throws IllegalArgumentException for thing
    */
   
   
   public static <T> Collection<T> range(Collection<T> c, T low, T high,
                     Comparator<T> comp) {
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
   
      int[] b = new int[a.length]; //creates a new array 
      int j = 0; 
      
      for (int i = 0; i < a.length; i++) {  
         if (c.compare(a, low) >= 0 && c.compare(a, high) <= 0) {
            
            b[j] = a[i]; // fills in the new array 
            j++;
            
         } 
         
         
        
      }
      
      if (j == 0) { // if the array is empty 
         int[] c = {};
         return c;
      }
      
      return b;
    
   }
   
   /** 
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    *@param a for the array 
    *@param key for the key 
    *@return ceiling for getting the ceiling 
    *@throws IllegalArgumentException for thing
    */ 
   
   public static int ceiling(int[] a, int key) {
   
      int ceiling = 0;
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
       
      
      for (int i = 0; i < a.length; i++) {
         
         if (a.length == 2) {
         
            if (a[0] < a[1]) {
               ceiling = a[1];
            }
            
            else {
               ceiling = a[0];
            }
            break;
         }
        
         
         if (a[i] >= key) {
         
         
            ceiling = a[i];
         
         }
          
      }
   
      return ceiling;
   
   
   }
   
    /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    *@param a for the array
    *@param key for the key 
    *@return floor for the floor 
    *@throws IllegalArgumentException for thing 
    */
   
   public static int floor(int[] a, int key) {
   
    int floor = 0;
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException("must be an"
            + " array of at least 1 integer");
      }
      
      if (key < 0) {
         throw new IllegalArgumentException();
      }
     
     
      for (int i = 0; i < a.length; i++) {
         
         if (a.length == 2) {
         
            if (a[0] < a[1]) {
               floor = a[1];
            }
            
            else {
               floor = a[0];
            }
            break;
         }
         
         if (a[i] <= key) {
         
         
            floor = a[i];
         
         }
          
      }
   
      return floor;
   
   }
   
   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    *@param a for the array 
    *@param k for the key 
    *@return min for the min
    *@throws IllegalArgumentException for thing
    */
    
    
   public static int kmin(int[] a, int k) {
    
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      //checks if k < 1 or k > the array length
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException("k - 1 must be"
            + " a value within the array set");
      
      }
      
       
      Arrays.sort(a);
      int min = a[0];
      int count = 1;
      
      
      for (int i = 0; i <= a.length - 1; i++) {
      
         if (i <= a.length - 2) { //check for duplocates
         
            if (a[1 + i] == a[i]) {
               k++;
            }
         }
      
         if (count == k) {
            min = a[i];
            return min;
         
         }
         count++;
          
      }
   
      throw new IllegalArgumentException();
      
    
   }
    
    /** 
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    *@param a for the array 
    *@param k for the key 
    *@return max
    */
    
   public static int kmax(int[] a, int k) {
    
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      //checks if k < 1 or k > the array length
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException("k - 1 must be"
            + " a value within the array set");
      
      }
      
       
      Arrays.sort(a);
      int max = a[0];
      int count = 1;
      
      
      for (int i = a.length - 1; i >= 0; i--) {
      
         if (i <= a.length - 2) { 
         
            if (a[1 + i] == a[i]) { //check dupolcate
               k++;
            }
         }
      
      
         if (count == k) {
            max = a[i];
            return max;
         }
         count++;
          
      }
   
      throw new IllegalArgumentException();
      
    
   }
   /*
   public static void main(String[] args) {
   
      int [] a = {-4, -4};
      System.out.println(kmin(a, 2));
   
   }
   */
    
}