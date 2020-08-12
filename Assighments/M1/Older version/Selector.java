//import java.util.Arrays;
/**
 *
 *@Author: Jacob Stockwell 
 *@version: 01-16-19
 *
 *Description: This program is designed to find
 * min, max, and range of an array.
 **/
 
public final class Selector {
 
 /** 
  *@return min for the minumum val
  *@param a for the array 
  *This method loops through the array and finds the min value 
 **/
 
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
    *@return max for the max val 
    *@param a for array 
    *This method goes through the array to fine max val
   **/
   
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
     *@return b for the range 
     *@param a for the array
     *@param low for the low val
     *@param high for the high val
   **/
   
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
    *@param a for the array 
    *@param key for the key 
    *@return ceiling for getting the ceiling 
    *
   **/ 
   
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
    *@param a for the array
    *@param key for the key 
    *@return floor for the floor 
    * this method returns the largest value comparied to key 
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
    *@return min
    *@param a for the array 
    *@param k for the key 
    
    
    
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
     *
     *@param a for the array 
     *@param k for the key 
     *@return max
    
    
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
   /** for debugging. 
     *@param args used 
    
   public static void main(String[] args) {
   
      int [] a = {9,7};
      System.out.println(ceiling(a, 11));
   
   }
   */
    
}