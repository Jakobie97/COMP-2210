import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
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
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @param <T> for the thing 
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
     
     //check if both coll and comp are null
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
   
      T min = coll.iterator().next(); 
      
       //checks if collection is empty
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a"
            + " collection that is not empty");
      }
      
      T temp;
      for (Iterator<T> it = coll.iterator(); it.hasNext();) {
         temp = it.next();
         if (comp.compare(temp, min) < 0) {
         
            min = temp;
         
         }
          
      }
   
      return min;
   }


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @param <T> for the thing 
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
   
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
   
      T max = coll.iterator().next(); 
      
      if (coll.size() == 0) {
         throw new NoSuchElementException();
      }
      
      T temp;
      for (Iterator<T> it = coll.iterator(); it.hasNext();) {
         temp = it.next();
         if (comp.compare(temp, max) > 0) {
         
            max = temp;
         
         }
          
      }
   
      return max;
   }


   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value* 
    * @param <T> for the thing 
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      
       //checks if collection is empty
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a"
            + " collection that is not empty");
      }
      
      //creates copy of collection list 
      List<T> copyColl = new ArrayList<T>(coll);
      java.util.Collections.sort(copyColl, comp);
      
      //checks to see if k < 0 or k > than the length of Coll length 
      if (k < 0 || copyColl.size() == 0) {
      
         throw new NoSuchElementException();
         
      } 
      
      //vars checking for duplacates and uniques 
      int dup = 0;
      int uniq = 0;
      int original = copyColl.size();
      
      for (int i = 0; i < copyColl.size() - 1; i++) {
      
         while (copyColl.size() > 1 && i < copyColl.size() - 1 
            && copyColl.get(i) == copyColl.get(i + 1)) { 
            //checks the numbers side by side ^^
            
            copyColl.remove(i); //takes away the duplocates 
            dup++; 
         }
      }
      
      uniq = original - dup; //the count of how many unique numbers 
      
      //if k is greater than the number of unique values
      if (k > uniq) {
         throw new NoSuchElementException("k must be"
               + " less than the unique number count");
      }
      
      return copyColl.get(k - 1);
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param <T> for the thing 
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      
       //checks if collection is empty
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a"
            + " collection that is not empty");
      }
      
      //creates copy of collection list 
      List<T> copyColl = new ArrayList<T>(coll);
      java.util.Collections.sort(copyColl, comp);
      
      //checks to see if k < 0 or k > than the length of Coll length 
      if (k < 0 || copyColl.size() == 0) {
      
         throw new NoSuchElementException();
         
      } 
      
      //vars checking for duplacates and uniques 
      int dup = 0;
      int uniq = 0;
      int original = copyColl.size();
      
      for (int i = 0; i < copyColl.size() - 1; i++) {
      
         while (copyColl.size() > 1 && i < copyColl.size() - 1 
            && copyColl.get(i) == copyColl.get(i + 1)) { 
            //checks the numbers side by side ^^
            
            copyColl.remove(i); //takes away the duplocates 
            dup++; 
         }
      }
      
      uniq = original - dup; //the count of how many unique numbers 
      
      //if k is greater than the number of unique values
      if (k > uniq) {
         throw new NoSuchElementException("k must be"
               + " less than the unique number count");
      }
      
      return copyColl.get(uniq - k);
   }


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @param <T> for the thing 
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                         Comparator<T> comp) {
                                        
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      
       //checks if collection is empty
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a"
            + " collection that is not empty");
      }
      
      // makes a copy of the array 
      List<T> copyList = new ArrayList<T>(coll);
      List<T> range = new ArrayList<T>(coll);
      int j = 0;
      
      for (int i = 0; i < copyList.size(); i++) {  
         if ((comp.compare(copyList.get(i), low) >= 0
               && comp.compare(copyList.get(i), high) <= 0)) {
            
            range.set(j, copyList.get(i));
            j++;
            
         } 
         
         
        
      }
      
      //delete extra values on end of range
      for (int i = range.size() - 1; i > j - 1; i--) {
         range.remove(i);
      }
      
      if (j == 0) { // if the array is empty 
         throw new NoSuchElementException("the collection must"
            + " have values within the range");
      }
      
      return range;
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param <T> for the thing 
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
   
      
      
      //checks to see if coll and comp are empty 
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      
       //checks if collection is empty
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a"
            + " collection that is not empty");
      }
       
      //to finds the max value for the ceiling 
      Iterator<T> it = coll.iterator();
      
      T ceiling = it.next(); // moves to next spot in the list 
      
      if (it.hasNext()) {
      
         for (T temp : coll) {
         
            if (comp.compare(temp, ceiling) > 0) {
               ceiling = temp;
            }
         
          
         }
      
      }  
      
      int count = 0; 
      
      //finds the lowest value equal to or above the key
         
      for (T temp: coll) {
         
         
         if ((comp.compare(temp, key) >= 0)
            && (comp.compare(temp, ceiling) <= 0)) {
            
            ceiling = temp;
            count++;
               
         }
      }
      
      if (count == 0) {
         
         throw new NoSuchElementException();
      
      }
       
      
   
      return ceiling;
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param <T> for the thing 
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      
      //checks to see if coll and comp are empty 
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      
       //checks if collection is empty
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a"
            + " collection that is not empty");
      }
       
      //to foinds the max value for the ceiling 
      Iterator<T> it = coll.iterator();
      
      T floor = it.next(); // moves to next spot in the list 
      
      if (it.hasNext()) {
      
         for (T element : coll) {
         
            if (comp.compare(element, floor) > 0) {
               floor = element;
            }
         
          
         }
      
      }  
      
      int count = 0; 
      
      //finds the lowest value equal to or above the key
         
      for (T temp: coll) {
         
         
         if ((comp.compare(temp, key) >= 0)
            && (comp.compare(temp, floor) <= 0)) {
            
            floor = temp;
            count++;
               
         }
      }
      
      if (count == 0) {
         
         throw new NoSuchElementException();
      
      }
       
      
   
      return floor;
   }

}