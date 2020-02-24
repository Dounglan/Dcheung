//Dounglan Cheung, decheun01@syr.edu
//2.11.2020
//hw4
import java.util.Scanner;
import java.util.ArrayList;

public class StatDriver {
  public static void main(String[] args) { 
    String mean; 
    String standDev; 
    
    Scanner scnr = new Scanner(System.in); //allows for input
    
    System.out.println("Enter as many numbers you want:(crtrl-d can close the prompts or any non-number character(A-Z) ");
    ArrayList<Double> data = new ArrayList<Double>();
    
    while (scnr.hasNextDouble()) { //keeps running this loop as long there is a double in the array list 
      data.add(scnr.nextDouble());//it will wait for input
    }
    
    if (args.length > 0 && args != null ) { //user should be able to provide a string on the command line indicating whether they want to calculate the mean ("mean") or the standard deviation ("std"). If no argument is provided, the mean should be calculated.
      if (args[0].equals("std")) { //if user enters std, then it will only compute std
        standDev = String.format("Standard Deviation: %.2f\n", Stats.stdDev(data));
        System.out.println(standDev); 
      }
      else if (args[0].equals("mean")) { //if user inputs mean, then it will compute mean
        mean = String.format("Mean: %.2f\n", Stats.mean(data));
        System.out.println(mean);
      }
    }
    else { //if user runs the program without any input, it will only compute the mean
      mean = String.format("Mean: %.2f\n", Stats.mean(data));
      System.out.println(mean);
    }
  }
}