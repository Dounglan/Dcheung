//Dounglan Cheung, decheun01@syr.edu
//2.11.2020
//hw4
import java.util.ArrayList;

public class Stats {
//calculates the mean of the ArrayList
  public static double mean(ArrayList<Double> data) { 
    double tot = 0; //sets the total to 0
    
    if (!(data.isEmpty() && data.size() > 0)) { //if the data is empty and the length of the data is greater than 0, then it will get negated
      for (int i = 0; i < data.size(); i++) { //adds the value within the array to total until the list is complete
        tot += data.get(i);
      }
      double avg = tot/data.size(); //divides the total with the number of items in the array to get the mean
      return avg;
    }
    else{
      return Double.NaN; //if it is empty, then it'll return Not a Number
    }
  }
//calculates the standard deviation of the ArrayList 
  public static double stdDev(ArrayList<Double> data) {
    double sd = 0; //sets the standard deviation to 0
    
    if (!(data.isEmpty() && data.size() > 0)) { ////if the data is empty and the length of the data is greater than 0, then it will get negated
      
      for (int j = 0; j < data.size(); j++) {
        sd = sd + Math.pow( (data.get(j) - mean(data) ), 2) / data.size(); //part of standard deviation formula
      }
      double standDev = Math.sqrt(sd); //this squares the portion of the standard deviation formula which completes the formula
      
      return standDev;
    }
    else{
      return Double.NaN; //if its empty, return NaN
    }
  }
}