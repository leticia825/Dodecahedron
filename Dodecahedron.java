import java.text.DecimalFormat;
/** This program defines Dodecahedron objects. It will be used as tool for the
* DodecahedronListMenuApp. 
* @author Leticia Garcia
* @version 7.4.2020 */

public class Dodecahedron {
/** Methods for evaluating user input. */
   private String label = "";
   private String color = "";
   private double edge = 0;
   
/** constructor -initializes a Dodecahedron object.
* @param labelIn string 
* @param colorIn string 
* @param edgeIn double  */
   public Dodecahedron(String labelIn, String colorIn, double edgeIn) {
   
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn);         
   } 
   
/** @return label. */
   public String getLabel() {
   
      return label;
   }

/** sets color.
* @param labelIn used to set label.
* @return isSetlabel. */
   public boolean setLabel(String labelIn) { 
   
      boolean isSetLabel = false; 
      if (labelIn != null) {
         label = labelIn.trim();
         isSetLabel = true;  
      }   
      return isSetLabel;        
   }
 
/** @return color. */
   public String getColor() {
   
      return color; 
   }
    
/** sets color.
* @param colorIn String
* @return isSetColor boolean */
   public boolean setColor(String colorIn) {
   
      boolean isSetColor = false;
      if (colorIn != null) {
         color = colorIn.trim();
         isSetColor = true;
      }
      return isSetColor;
   }
   
/** @return edge. */
   public double getEdge() {
   
      return edge; 
   }
   
/**sets edge.
* @param edgeIn to set edge.
* @return isSetEdge. */
   public boolean setEdge(double edgeIn) {
   
      boolean isSetEdge = false;
      if (edgeIn > 0) {
         edge = (double) edgeIn;    
         isSetEdge = true;   
      }
      return isSetEdge;
   }
   
/** calculates surface area.
* @return totalSurfaceArea. */
   public double surfaceArea() {
   
      double totalSurfaceArea = 3 * Math.sqrt(25 + 10 
         * Math.sqrt(5)) * Math.pow(getEdge(), 2); 
      return totalSurfaceArea;
   }
   
/** calculates volume.
* @return totalVolume double */
   public double volume() {
   
      double totalVolume = ((15 + 7 * Math.sqrt(5)) / 4) 
         * Math.pow(getEdge(), 3);
      return totalVolume;
   }   
      
/** Calculates surface to volume ratio.
* @return surfaceArea() / volume(). */
   public double surfaceToVolumeRatio() {
   
      return surfaceArea() / volume();
   }
   
/** gathers and turns previous methods into string.
* @return output. */
   public String toString() {
   
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String output = "Dodecahedron \"" + getLabel() + "\" is \"" + getColor() 
         + "\" with 30 edges of length " + getEdge() + " units." + "\n"
         + "\tsurface area = " + df.format(surfaceArea()) + " square units"
         + "\n" + "\tvolume = " + df.format(volume()) + " cubic units" + "\n"
         + "\tsurface/volume ratio = " + df.format(surfaceToVolumeRatio())
         + "\n";
      return output; 
   }
}