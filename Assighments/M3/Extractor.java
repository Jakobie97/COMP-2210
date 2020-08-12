import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  Jacob Stockwell (Jts098@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version TODAY
 *
 */
public class Extractor {
   
   /** raw data: all (x,y) points from source data. */
   private Point[] points;
   
   /** lines identified from raw data. */
   private SortedSet<Line> lines;
  
   /**
    * Builds an extractor based on the points in the file named by filename. 
    *@param filename for the param of the file name 
    */
   public Extractor(String filename) {
   
      try {  
         Scanner scanFile = new Scanner(new File(filename));
      
         int len = scanFile.nextInt();
         int a = 0;
      
         points = new Point[len];
      
         while (scanFile.hasNext()) {
         
            int x = scanFile.nextInt();
            int y = scanFile.nextInt(); 
         
            Point element = new Point(x, y); 
         
            points[a] = element; 
            a++;
         }
      
      }
      
      catch (Exception e) {
      
         System.out.println("FileNotFoundException resolved");
      }
   
   }
  
   /**
    * Builds an extractor based on the points in the Collection named by pcoll. 
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    *@param pcoll for the points in the collection 
    */
   public Extractor(Collection<Point> pcoll) {
      points = pcoll.toArray(new Point[]{});
   }
  
   /**
    * Returns a sorted set of all line segments of exactly four collinear
    * points. Uses a brute-force combinatorial strategy. Returns an empty set
    * if there are no qualifying line segments.
    @return lines for the lines 
    */
    
   public SortedSet<Line> getLinesBrute() {
      lines = new TreeSet<Line>();
   
      Iterator it = lines.iterator();
      
      Point [] result = Arrays.copyOf(points, points.length);
      
      for (int i = 3; i < result.length; i++) {
         
         for (int a = 2; a < i; a++) {
            
            for (int b = 1; b < a; b++) {
               
               for (int c = 0; c < b; c++) {
                  
                  double slope1 = result[i].slopeTo(result[a]);
                  double slope2 = result[i].slopeTo(result[b]);
                  double slope3 = result[i].slopeTo(result[c]);
                  
                  if (slope1 == slope2 && slope2 == slope3) {
                  
                     Line lineNew = new Line();
                     
                     lineNew.add(result[i]);
                     lineNew.add(result[a]);
                     lineNew.add(result[b]);
                     lineNew.add(result[c]);
                     
                     lines.add(lineNew);
                  }
                  
               }
            
            }
         }
      
        
      }
      return lines;
   }
  
   /**
    * Returns a sorted set of all line segments of at least four collinear
    * points. The line segments are maximal; that is, no sub-segments are
    * identified separately. A sort-and-scan strategy is used. Returns an empty
    * set if there are no qualifying line segments.
    *@return lines for tthe lines 
    */
   public SortedSet<Line> getLinesFast() {
      lines = new TreeSet<Line>();
      Iterator it = lines.iterator();
      
      Point [] result = Arrays.copyOf(points, points.length);
      
      
      
      for (int i = 0; i < points.length; i++) {
      
         Arrays.sort(result, points[i].slopeOrder);
         
         int sameSlopes = 0;
         for (int b = 0; b < points.length - 1; b++) {
            sameSlopes = 0;
         
            int a = 0; 
         
            Line lineNew = new Line();
            // lineNew.add(points[i]);
         
            while (b + a < points.length
               && points[i].slopeOrder.compare(result[b], result[b + a]) == 0) {
            
               lineNew.add(points[b + a]);
               
               a++;
               sameSlopes++;
               
            
            }
               
            if (lineNew.length() > 3) {
               
               lines.add(lineNew);
            }
         }
      }
      
      return lines;
   }
   
}
