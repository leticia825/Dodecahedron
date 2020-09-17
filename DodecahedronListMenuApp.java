import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/** This program presents and implements a menu with 8 options to user.
* @author Leticia Garcia
* @version 7.4.2020 */

public class DodecahedronListMenuApp {
/** User can choose 1 of 8 actions.
* @param args - is not used.
* @throws FileNotFoundException if the file cannot be opened. */
   public static void main(String[] args) throws FileNotFoundException {
   /** Give user 8 options for executing.*/
   
      String dListName = "*** no list name assigned ***";
      ArrayList<Dodecahedron> shapeList = new ArrayList<Dodecahedron>();
      DodecahedronList formList = new DodecahedronList(dListName, shapeList);
      String fileName = "no file name";
   
      System.out.print("Dodecahedron List System Menu"
         + "\nR - Read File and Create Dodecahedron List"
         + "\nP - Print Dodecahedron List"
         + "\nS - Print Summary"
         + "\nA - Add Dodecahedron"
         + "\nD - Delete Dodecahedron"
         + "\nF - Find Dodecahedron"
         + "\nE - Edit Dodecahedron"
         + "\nQ - Quit\n");
       
      String label, color;
      double edge;
      String code = "";
      
      Scanner userInput = new Scanner(System.in);
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = userInput.nextLine();
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch(codeChar) {
            case 'R': 
               System.out.print("\tFile name: ");
               fileName = userInput.nextLine();
               formList = formList.readFile(fileName);
               System.out.println("\tFile read in and Dodecahedron"
                                             + " List created\n");
               break;
                
            case 'P':
               System.out.println(formList);
               break;
               
            case 'S':
               System.out.println();
               System.out.println(formList.summaryInfo());
               break;
               
            case 'A':
               System.out.print("\tLabel: ");
               label = userInput.nextLine();
               System.out.print("\tColor: ");
               color = userInput.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(userInput.nextLine());
               formList.addDodecahedron(label, color, edge);
               System.out.println("\t*** Dodecahedron added ***\n");
               break;
               
            case 'D':
               System.out.print("\tLabel: ");
               label = userInput.nextLine();
               if (formList.deleteDodecahedron(label) != null) {
                  System.out.println("\t\"" + label + "\" deleted\n"); 
               }
               else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
                  
            case 'F':
               System.out.print("\tLabel: ");
               label = userInput.nextLine();
               formList.findDodecahedron(label);
               if (formList.findDodecahedron(label) != null) {
                  System.out.print(formList.findDodecahedron(label).toString()
                      + "\n");
               }
               else {
                  System.out.print("\t\"" + label + "\" not found" + "\n\n");
               }
               break;
               
            case 'E':
               System.out.print("Label: ");
               label = userInput.nextLine();
               System.out.print("Color: ");
               color = userInput.nextLine();
               System.out.print("Edge: ");
               edge = Double.parseDouble(userInput.nextLine());
               if (formList.editDodecahedron(label, color, edge)) {
                  System.out.println("\t\"" + label 
                                       + "\" successfully edited\n"); 
               }
               else {
                  System.out.println("\"" + label + "\" not found\n");
               }
               break;
               
            case 'Q':
               break;
               
            default:
               System.out.print("\t*** invalid code ***\n\n");
               break;
         }
      } while (!code.equalsIgnoreCase("Q"));
   }
}