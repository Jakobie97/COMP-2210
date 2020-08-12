import java.util.Iterator;
import java.util.NoSuchElementException; 
import java.util.Random;

/** 
 *
 *@author Jacob Stockwell 
 *@version 02/26/19
 *
 *Decription: 
 *
 **/
 
/**
 * @param <T> This describes my type parameter
 */
public class RandomList<T> implements RandomizedList<T> {



//varaibles to get started 
   private T[] elements; 
   private int size;
   private static final int BASE_LENGTH = 1;
   
   

/**
 *constructor to build a random object.
 *
 */
   @SuppressWarnings("unchecked")
   public RandomList() {
   
      size = 0; 
      elements = (T[]) new Object[BASE_LENGTH]; 
   }
  
    /** 
     *@return it for creating the iterator 
    **/
   
   public Iterator<T> iterator() {
     
      Iteration it = new Iteration(elements, size());
     
      return it; 
     
   }
   
   
   //mesthods 
   
   /**
    *Adds the specified element to this list. 
    *If the element is null, this
    *method throws an IllegalArgumentException.
    *@param element for a generic element
   **/
   
   public void add(T element) {
     
      if (elements == null) {
         throw new IllegalArgumentException("There must be elements" 
               + "it cannot be null");
      }
      
      if (size == elements.length) {
         resize(elements.length * 2);
      }
      
      elements[size()] = element; 
      
      size++;
      
      
   } 
   
   /** 
    *Selects and removes an element selected uniformly at random from the
    *elements currently in the list. If the list is empty this method returns
    *null.
    *@return null if size is 0
    **/
   
   public T remove() {
   
      if (size == 0) {
         return null;
      }
      
      int randomNum = new Random().nextInt(size());
      
      T delete = elements[randomNum];
      
      elements[randomNum] = elements[size() - 1];
      elements[size() - 1] = null;
      
      size--;
      
      return delete; 
   }
   
   /**
    * Selects but does not remove an element selected uniformly at random from
    * the elements currently in the list. If the list is empty this method
    * return null.
    *@return null if size is 0
    */
   
   public T sample() {
   
      if (size == 0) {
      
         return null;
      }
   
      int randomNum = new Random().nextInt(size());
   
      return elements[randomNum];
   
   }
   
   /** 
    *@return size to get the size 
   */
   
   public int size() {
      
      return size;
   }
   
   /** 
    *@return size when it is empty 
   */
   
   public boolean isEmpty() {
   
      return size == 0;
   }
   
   @SuppressWarnings("unchecked")
   private void resize(int cap) {
   
      T[] tArray = (T[]) new Object[cap];
      
      for (int i = 0; i < size(); i++) {
      
         tArray[i]  = elements[i];
      }
      elements = tArray;
   }
   
   //-------------------End of Startercode------------------
  
  /**
   * Makes the behavior of the iterator of RandomList class.
   */
   
   private class Iteration implements Iterator<T> {
   
   //variables for the private constructor
   
      private T[] items; 
      private int count;
      private int currentNum; 
   
    /**
     * creates special iterator, "Iteration," for this program.
     */
    
      Iteration(T[] tArray, int amount) {
      
         count = amount; 
         items = tArray;
         currentNum = 0;
      
      
      }
      
      /** 
       *Checks to see if there is another element.
       *@return true if it is and false if not 
       */
      
      public boolean hasNext() {
      
         return (currentNum < size());
      }
      
      /** 
       *@returns the next element in the generic array
       */
      public T next() {
      
         if (!hasNext()) {
         
            throw new NoSuchElementException();
            
         }
           
         else {
         
            return items[currentNum++];
            
         }
      }
   }
}