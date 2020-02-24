//Dounglan Cheung
//CIS 351 hw2
//PA1.java

import java.util.Scanner;

public class PA1 {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    
    String commonName;
    String scienceName;
    int circumf;
    int h;
    int largeSpread;
    int smallSpread;
    int avgSpread;
    int total;
    
    //Input for all of the local variables above
    System.out.print("Enter the Common Name: ");
    commonName = scnr.nextLine();
    
    System.out.print("Enter the Scientific Name: ");
    scienceName = scnr.nextLine();
    
    System.out.print("Enter the Circumfrence (in inches): ");
    circumf = scnr.nextInt();
    
    System.out.print("Enter the Height (in ft): ");
    h = scnr.nextInt();
    
    System.out.print("Enter the largest crown spread (in ft): ");
    largeSpread = scnr.nextInt();
  
    System.out.print("Enter the smallest crown spread (in ft): ");
    smallSpread = scnr.nextInt();
    
    //math
    avgSpread = (largeSpread + smallSpread)/2; //Calculating the average spread
    total = circumf + h + (avgSpread/4); //Calculating the total points
    
    //OUTPUT
    System.out.print("Big Tree Report: " + "\n");
    System.out.print("    Common Name: " + commonName +"\n");
    System.out.print("\n");
    System.out.print("Scientific Name: " + scienceName + "\n");
    System.out.print("\n");
    System.out.print("  Circumference: " + circumf + "\n");
    System.out.print("         Height: " + h + "\n");
    System.out.print("  Average Crown: " + avgSpread + "\n");
    System.out.print("\n");
    System.out.print("   Total Points: " + total + "\n");
  } 
}
