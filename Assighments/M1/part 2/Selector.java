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
   
   public static int[] range(int[] a, int low, int high) {
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
   
      int[] b = new int[a.length]; //creates a new array 
      int j = 0; 
      
      for (int i = 0; i < a.length; i++) {  
         if (a[i] >= low && a[i] <= high) {
            
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
         
         if (a.length == 2) { // checks if the array is 2 special case
         
            if (key >= a[0] || key <= a[1]) { // compares key to nums in array
            
               
               if (key < a[0]) {
               
               
                  ceiling = a[1];
                  
               }
               else {
               
                  ceiling = a[0];
                  
               }
            }
            
            else {
            
               ceiling = a[0];
               
            }
            break;
         }
        
         
         if (a[i] >= key) {
         
            ceiling = a[i];
            
            if (a[i] > key) {
               ceiling = a[i];
               break;
            }
         
         
         }
          
      }
      
      if (ceiling < key) {
         throw new IllegalArgumentException();
      }
      
      else {
      
         return ceiling;
      }
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
      /*
      if (a.length == 1 && key > a[0]) {
         throw new IllegalArgumentException();
      }
     */
     
      for (int i = 0; i < a.length; i++) {
         
         
         
         if (a.length == 2) {
            
            
         
            if (key >= a[0] || key <= a[1]) {
               
               floor = a[i];
            
               if (key < a[0]) {
                  floor = a[1];
                  break;
               }
               if (key > a[0]) {
                  floor = a[0];
               }
            }
            
            else {
               floor = a[1];
            }
            break;
         }
         
         if (a[i] <= key) {
            
            if (floor == a[1]) {
               floor = a[i];
               break;
            }
         
            floor = a[i];
         
         }
         
         
          
      }
   
      return floor;
   
   
   }
   
   /*
   public static void main(String[] args) {
   
      int[] a = {7};
      System.out.print(floor(a, 11));
   }
   */
    
}