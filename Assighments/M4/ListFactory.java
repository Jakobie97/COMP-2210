/**
 * ListFactory.java.
 * Implements the factory method pattern (https://en.wikipedia.org/wiki/Factory_method_pattern)
 * for lists in this assignment.
 *
 * @author Jacob Stockwell (JTS0098@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 02/26/19
 */
public class ListFactory {

   /**
    * Return an instance of a class that implements RandomizedList.
    */
    @SuppressWarnings("unchecked")
   public static <T> RandomizedList<T> makeRandomizedList() {
      // Replace the following return statement with one that returns
      // an instance of the class you wrote to implement the
      // RandomizedList interface.
      return null;
   }

   /**
    * Return an instance of a class that implements DoubleEndedList.
    */
   @SuppressWarnings("unchecked")
   public static <T> DoubleEndedList<T> makeDoubleEndedList() {
      // Replace the following return statement with one that returns
      // an instance of the class you wrote to implement the
      // DoubleEndedList interface.
      return new DoubleEndList();
   }

}
