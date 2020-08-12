/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Jacob Stockwell (JTS0098@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  TODAY
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
 
   public static int min(int[] a) {
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
   
      int min = a[0]; 
      
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
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
   
      int max = a[0]; 
      
      for (int i = 0; i < a.length; i++) {
      
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
   
   public static int[] range(int[] a, int low, int high) {
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
   
      int[] b = new int[a.length];
      int j = 0; 
      
      for (int i = 0; i < a.length; i++) {  
         if (a[i] >= low && a[i] <= high) {
            
            b[j] = b[i];
            j++;
            
         } 
          
        
      }
       
      if (j == 0){
       
         int [] c = {};
         return c;
      }
       
      
      return b;
    
   }
   
   
   
}