import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/** This program defines DodecahedronList objects. It will be used as tool
* for the DodecahedronListMenuApp. 
* @author Leticia Garcia
* @version 7.4.2020 */

public class DodecahedronList {
/** Uses constructor and methods (excluding main) that return the list name, 
* amount of Dodecahedron objects and their respective information.
* @param fileNameIn for fileName to read
* @return DodecahedronList
* @throws FileNotFoundException if the file cannot be opened.*/

   private String listName;
   private ArrayList<Dodecahedron> dList;

/** constructor.
* @param listNameIn string 
* @param dListIn ArrayList<Dodecahedron> */
   public DodecahedronList(String listNameIn, ArrayList<Dodecahedron> dListIn) {
   
      listName = listNameIn;
      dList = dListIn;
   }
   
/** gets list name.
* @return listName String */
   public String getName() {
   
      return listName;
   }
   
/** returns amount of objects.
* @return dList.size(). */
   public int numberOfDodecahedrons() {
   
      return dList.size();
   }
  
/** calculates total surface area.
* @return num double */ 
   public double totalSurfaceArea() {
   
      double num = 0.0; 
      int index = 0;
      while (index < dList.size()) {
         num += dList.get(index).surfaceArea();
         index++;  
      }  
      return num;
   }
   
/** calculates total volume.
* @return num double */
   public double totalVolume() {
   
      double num = 0.0; 
      int index = 0;
      while (index < dList.size()) {
         num += dList.get(index).volume();
         index++;
      }
      return num;
   }
    
/** calculates average surface area.
* @return num double */
   public double averageSurfaceArea() {
   
      double num = 0.0;
      int index = 0;
      if (index < dList.size()) {
         num = totalSurfaceArea() / dList.size();
      }
      return num;
   }
   
/** calculates average volume.
* @return num double */
   public double averageVolume() {
   
      double num = 0.0;
      int index = 0;
      if (index < dList.size()) {
         num = totalVolume() / dList.size();
      }
      return num;
   }
   
/** calculates average surface to volume ratio.
* @return num. */
   public double averageSurfaceToVolumeRatio() {
   
      double num = 0.0;
      int index = 0;
      while (index < dList.size()) {
         num += dList.get(index).surfaceToVolumeRatio();
         index++;
      }
      if (num == 0.0) {
         return num;
      } 
      else { 
         num = num / dList.size();
         return num;
      }
   }
     
/** gathers list name and objects.
* @return result String */
   public String toString() {
   
      String result = "";
      result += getName() + "\n\n";
      int index = 0;
      while (index < dList.size()) {
         result += dList.get(index) + "\n"; 
         index++;
      }
      return result;
   }
   
/** gathers and turns previous methods into string.
* @return result String */
   public String summaryInfo() {
   
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      String result = "";
      result += "----- Summary for " + getName() + " -----"; 
      result += "\nNumber of Dodecahedrons: " + dList.size();
      result += "\nTotal Surface Area: " + df.format(totalSurfaceArea());
      result += "\nTotal Volume: " + df.format(totalVolume());
      result += "\nAverage Surface Area: " + df.format(averageSurfaceArea());
      result += "\nAverage Volume: " + df.format(averageVolume());
      result += "\nAverage Surface/Volume Ratio: ";
      result += df.format(averageSurfaceToVolumeRatio()) + "\n";
      
      return result;
   }
 
/** gets list.
* @return dList.*/
   public ArrayList<Dodecahedron> getList() {
   
      return dList;
   }
 
/** reads in data from file, creates DodecahedronList object.
* @param fileNameIn for file to be read.
* @throws FileNotFoundException if the file cannot be opened.
* @return obj2 */
   public DodecahedronList readFile(String fileNameIn) 
                                   throws FileNotFoundException {
   
      Scanner scanFile = new Scanner(new File(fileNameIn));
      ArrayList<Dodecahedron> shapeList = new ArrayList<Dodecahedron>();
      listName = scanFile.nextLine(); 
           
      while (scanFile.hasNext()) {
         String label = scanFile.nextLine();
         String color = scanFile.nextLine();
         String edge = scanFile.nextLine();
         double edge2 = Double.parseDouble(edge);
      
         Dodecahedron d = new Dodecahedron(label, color, edge2);
         shapeList.add(d);
      }
      
      DodecahedronList obj2 = new DodecahedronList(listName, shapeList);
      return obj2;
   } 
 
/** creates new Dodecahedron object.
* @param labelIn string
* @param colorIn for string 
* @param edgeIn for double  */
   public void addDodecahedron(String labelIn, String colorIn, double edgeIn) {
   
      Dodecahedron obj1 = new Dodecahedron(labelIn, colorIn, edgeIn);
      dList.add(obj1); 
   }
   
/** finds and returns corresponding Dodecahedron object.
* @param labelIn String
* @return result. */
   public Dodecahedron findDodecahedron(String labelIn) {
   
      Dodecahedron result = null;
      int index = -1;
      for (Dodecahedron obj1 : dList) {
         if (obj1.getLabel().equalsIgnoreCase(labelIn)) {
            index = dList.indexOf(obj1);
            break;
         }
      }
      if (index >= 0) {
         result = dList.get(index);
      }
      return result;          
   }
   
/** deletes Dodecahedron object.
* @param labelIn String
* @return result Dodecahedron */
   public Dodecahedron deleteDodecahedron(String labelIn) {
   
      Dodecahedron result = null;
      int index = -1;
      for (Dodecahedron obj1 : dList) {
         if (obj1.getLabel().equalsIgnoreCase(labelIn)) {
            index = dList.indexOf(obj1);
         }
         break;
      }
      if (index >= 0) {
         result = dList.remove(index);
      }
      return result;
   }
  
/** edits parameters of corresponding object.
* @param labelIn for string 
* @param colorIn for string 
* @param edgeIn for double 
* @return update. */
   public boolean editDodecahedron(String labelIn, String colorIn, 
                                                               double edgeIn) {
   
      boolean update = false;
      int index = -1;
      for (Dodecahedron obj1 : dList) {
         if (obj1.getLabel().equalsIgnoreCase(labelIn)) {
            index = dList.indexOf(obj1);
         }
         break;
      }
      if (index >= 0) {
         dList.get(index).setLabel(labelIn);
         dList.get(index).setColor(colorIn);
         dList.get(index).setEdge(edgeIn);
         update = true;
      }
      return update;
   }  
}