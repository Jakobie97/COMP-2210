import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;


/**
 *
 *@author: Jacob Stockwell
 *
 *@version: 03/28/19
 *
 * Description: Defines the methods needed.
 * to play a word search game.
 */
 
public class WordyWordGame implements WordSearchGame {

// Varrables to work with 
   private boolean lexiconLoaded;
   private TreeSet<String> lexicon; 
   private SortedSet<String>  validWords;
   private List<Integer> path; 
   private List<Integer> actualPath; 
   private int length; 
   private String [][] board; 
   private int minLength; 
   private boolean [][] visited;  
   


   
   /** 
    * constructor.
    */ 
   public WordyWordGame() {
   
      actualPath = new ArrayList<Integer>();
      path = new ArrayList<Integer>();
      lexicon = new TreeSet<String>();
      validWords = new TreeSet<String>();
     
   } 
   
   //methods 
   
   /**
    * Reads text files.
    * @param fileName for the file title that is loaded.
    * @throws IllegalArgumentException if the file is null
    **/
   
   public void loadLexicon(String fileName) {
   
      if (fileName == null) {
         throw new IllegalArgumentException("There must be a txt file");
      }
      
      
     //vars for the scanner 
      String eachLine;
      Scanner fileScan;
      Scanner lineScanner;
      
      try {
         fileScan = new Scanner(new FileReader(fileName));
      
         while (fileScan.hasNext()) { //goes through the file 
         
            eachLine = fileScan.nextLine(); // checks each line 
            //lineScanner = new Scanner(eachLine); //checks for space 
            //lineScanner.useDelimiter(" ");
            lexicon.add(eachLine.split(" ")[0].toLowerCase());
         
         
            /*while (lineScanner.hasNext()) {
               lexicon.add(lineScanner.next().toLowerCase());
            }*/ 
         
         }
      
      }
      
      catch (Exception e) {
         throw new IllegalArgumentException("Incorrect entry");
      }
      
   
      lexiconLoaded = true; 
   }
   
   /** 
    * Sets the board for the game.
    * @param letterArray is the letter of the board.
    * @throws IllegalArgumentException letterArray null if not a square.
   **/
   
   public void setBoard(String[] letterArray) {
   
      if (letterArray == null) {
         throw new IllegalArgumentException("This is an incorrect entry");
      }
      double dimensions = Math.sqrt(letterArray.length);
      
      if (dimensions % 1 > 0) {
         throw new IllegalArgumentException("Incorrect entry" 
                                    + "must be perfect square");
      } 
      
      else {
         
         length = (int) dimensions; 
         board = new String[length][length]; 
         visited = new boolean[length][length]; 
         
         int count = 0;
         
         for (int a = 0; a < length; a++) {
            for (int b = 0; b < length; b++) {
               visited[a][b] = false;
               board[a][b] = letterArray[count].toLowerCase();
               count++;
               
            }
         }
      }
   
   }
   
   /** 
    * prints the board.
    *@return reuslt is the board 
   **/ 
   
   public String getBoard() {
   
      String result = "";
   
      for (String[] str: board) {
      
         for (String string: str) {
            result += string; 
         }
      } 
   
      return result;
   }
   
   /** 
    *Finds all the words to see if they are valid.
    * and are in the lixcon.
    *@param minimumWordLength fo the min length of words.
    *@return validWords is the list of all the words on the board.
    *@throws IllegalArgumentException if the minimuim is < 1.
   **/
   
   //@SuppressWarnings("unchecked")
   public SortedSet<String> getAllValidWords(int minimumWordLength) {
   
      minLength = minimumWordLength; 
      validWords.clear();
   
      if (!lexiconLoaded) {
         throw new IllegalStateException("you ned to load lexicon");
      }
      
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException("invalid number." 
                                          + "needs to be valid");
      }  
      
      for (int a = 0; a < length; a++) {
      
         for (int b = 0; b < length; b++) {
         
            locateWord(board[a][b], a, b);
         }
      }
   
      return validWords; 
   }
   
   /** 
    *gets all the scores for the words on the board.
    *@param words is the set of that are scored.
    *@param minimumWordLength is the minimuim length a word can be.
    *@return score for the score. 
   **/
   
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
   
      if (!lexiconLoaded) {
         throw new IllegalStateException("you ned to load lexicon");
      }
      
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException("the length must " 
                                       + "be greater than 1");
      }  
      
      int score = 0;
      
      for (String word: words) {
      
         int size = word.length();
         score += 1 + (size - minimumWordLength); 
         
      }
   
      return score;
   }
   
   /** 
    *finds if the word is in lexicon.
    * @param wordToCheck The word to check.
    * @return true if wordToCheck is in lexicon, false if not.
    * @throws IllegalArgumentException wordToCheck null, lexiconLoaded false.
   **/
   
   public boolean isValidWord(String wordToCheck) {
   
      if (!lexiconLoaded) {
         throw new IllegalStateException("must load lexicon");
      }
   
      if (wordToCheck == null) {
         throw new IllegalArgumentException("Invalid word must be valid");
      }
    
      return lexicon.contains(wordToCheck.toLowerCase()); 
   }
    
    
    /** 
     * checks to see if that word is on the board. 
     *@param wordToCheck chesks word 
     *@return path gives the path of the word on the board. 
     *@throws IllegalArgumentException wordToCheck null andlixicon is false.
    **/
    
   public List<Integer> isOnBoard(String wordToCheck) {
   
      if (!lexiconLoaded) {
         throw new IllegalStateException("must load lexicon");
      }
   
      if (wordToCheck == null) {
         throw new IllegalArgumentException("Invalid word must be valid");
      }
      
      path.clear();
      actualPath.clear(); 
      
      for (int a = 0; a < (int) length; a++) {
         for (int b = 0; b < length; b++) {
         
            if (board[a][b].toUpperCase().equals(wordToCheck.toUpperCase())) {
               
               int value = b + (a * length); 
               path.add(value);
               
               recursion(wordToCheck, board[a][b], a, b);
               
               if (!actualPath.isEmpty()) {
                  return actualPath;
               } 
               
               path.clear();
               actualPath.clear();
               
            }
         }
      }
    
      return path;
   }
   
   /** 
    * This method is for finding words that have a prefix.
    ** @param prefixToCheck The prefix to check
    * @return true if prefixToCheck is in lexicon, false if not.
    * @throws IllegalArgumentException, prefix null, lexiconLoaded false. 
   **/
   
   public boolean isValidPrefix(String prefixToCheck) {
   
      if (!lexiconLoaded) {
         throw new IllegalStateException("must load lexicon");
      }
      
      if (prefixToCheck == null) {
         throw new IllegalArgumentException("Invalid word must" 
                                             + "be a valid word");
      }
      
      return lexicon.ceiling(prefixToCheck).startsWith(prefixToCheck);
      
   
   }
   
   /**  
    *this finds the word in a previeous method.
    *@param word is word 
    *@param a is the a value of the word on board 
    *@param b is the b value of the word on board 
    *
   **/
   
   public void locateWord(String word, int a, int b) {
      
      if (!isValidPrefix(word)) {
         return; 
      } 
      
      visited[a][b] = true; 
      
      for (int x = -1; x <= 1; x++) {
         
         for (int y = -1; y <= 1; y++) {
            
            if ((a + x) <= ((int) length - 1) 
               && (b + y) <= ((int) length - 1)
               && (a + x) >= 0 && (b + y) >= 0 
               && !visited[a + x][b + y]) {
               
               visited[a + x][b + y] = true;
               locateWord(word + board[a + x][b + y], a + x, b + y);
               visited[a + x][b + y] = false;
                  
            }
         }
      }
      visited[a][b] = false; 
   }
   
   /** 
    *this method is the for isOnboard method.
    * @param wordToCheck is the word to check.
    * @param current is the current word your're using.
    * @param a is the current a value.
    * @param b is the current b value.
   **/
   
   public void recursion(String wordToCheck, String current, int a, int b) {
   
      visited[a][b] = true; 
      
      if (!(isValidPrefix(current))) {
         return;
      } 
      
      for (int i = -1; i <= 1; i++) {
         
         for (int j = -1; j <= 1; j++) {
            
            if (current.equals(wordToCheck)) {
               return;
            }
            if (((a + i) <= ((int) length - 1) 
               && (b + j) <= ((int) length - 1)
               && (a + i) >= 0 && (b + j) >= 0 
               && !visited[a + i][b + j])) {
               
               visited[a + i][b + j] = true;
               int value = (a + i) * length + b + j;
               
               path.add(value); 
               recursion(wordToCheck, current 
                  + board [a + i][b + j], a + i, b + j);
               visited[a + i][b + j] = false;
               
               path.remove(path.size() - 1);
            }
         }
      }
      
      visited[a][b] = false;
      return;
   }
}