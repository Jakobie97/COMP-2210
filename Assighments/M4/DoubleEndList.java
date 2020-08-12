import java.util.Iterator;
import java.util.NoSuchElementException;
/** 
 *
 *
 *@author: Jacob Stockwell 
 *@version 03/05/19
 *
 *
 *Description: 
 *
**/

/**
 * @param <T> This describes my type parameter
 */

public class DoubleEndList<T> implements DoubleEndedList<T> {

//varaibles to get started 
   private Node front;
   private Node end;
   private int size; 
   
   

//constructor 

/** **/

   public DoubleEndList() {
   
      front = null;
      size = 0; 
      end = null;
      
   }
   
   /** **/
   
   private class Node {
      
      //some vars to get started creating our node 
      private T element;
      private Node next; 
      private Node prev;
      
      //creates the node 
      
      public Node (T t) {
         
         element = t; 
         next = null;
         prev = null;
         
      }
      
      
      public Node(T t, Node n) {
      
      
         element = t; 
         next = n;
      } 
      
      public int length(Node n) {
         Node p = n;
         int len = 0;
         while (p != null) {
            len++;
            p = p.next;
         }
         return len;
      }
      
   
   }

   

//methods 



/**
 * Adds element to the front of the list. If element is null,
 * this method throws an IllegalArgumentException.
 *@param element for the elements
 */
   public void addFirst(T element) {
   
      if (element == null) {
         throw new IllegalArgumentException();
      }
      
      Node n = new Node(element);         
      if (front == null) {
      
         front = n; 
         end = n;
      } 
      
      
      
      n.next = front;
      front = n; 
      front.prev = n;
      
      
      
      size++;
   
   }
   
    /**
    * Adds element to the end of the list. If element is null,
    * this method throws an IllegalArgumentException.
    *@param element for the elements
    */
   public void addLast(T element) {
   
      if (element == null) {
         throw new IllegalArgumentException();
      }
      
      Node n = new Node(element);
      n.element = element;
      
      if (size == 0) {
         
         front = n;
         end= n;
      }
      
      else {
      
         n.prev = end;
         end.next = n;
         end = n;
      }
      
      size++;
   }
   
   /**
    * Delete and return the element at the front of the list.
    * If the list is empty, this method returns null.
    *@return delete for the deleted elements
    */
   
   public T removeFirst() {
   
      if (size == 0) {
         return null;
      }
      
      T delete = front.element;
      
      if (size == 1) {
         front = null;
         end = null;
      }
      
      else {
         front = front.next;
         front.prev = null;
      }
      
      size--;
      
      return delete; 
   
   }
   
   /**
    * Delete and return the element at the end of the list.
    * If the list is empty, this method returns null.
    *@return delete for the deleted elements
    */
   
   public T removeLast() {
   
      if (size == 0) {
         return null;
      } 
      
      
      
      T delete = front.element;
         
      if (size == 1) {
         front = null;
         end = null;
      }
      else {
         end = end.prev;
         end.next = null;
      }
      
      size--;
      return delete;
         
   }
   
   /** 
    *gets the size of how many elements. 
    *@return size for the size
   **/
   
   public int size() {
   
      return size;
   }
   
   /** 
    *creates an iteration for the iterator.
    *@return Iteration for the thing 
   **/
   
   public Iterator<T> iterator() {
   
      return new Iteration();
   }
   
   /** 
    *@return size when this is empty 
   **/
   
   public boolean isEmpty() {
   
      return size == 0; 
   
   } 
   
   
   /** **/

   private class Iteration implements Iterator<T> {
   
      private Node current = front; 
      
      public T next() {
      
         if (!hasNext()) {
         
            throw new NoSuchElementException();
            
         }
         
         T target = current.element;
         
         current = current.next;
         return target;
      }
      
      public boolean hasNext() {
         
         return current != null;
      
      }
      
      public void remove() {
      
         throw new UnsupportedOperationException();
      
      }
   
   }
}