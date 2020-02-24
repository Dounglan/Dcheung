import java.util.Scanner;
import java.util.ArrayList;
//import java.util.StringTokenizer;

public class PlantArrayListExample {

  // TODO: Define a PrintArrayList method that prints an ArrayList of plant (or flower) objects                                                       
  public static void PrintArrayList(ArrayList<Plant> myGarden) {
    for (int i = 0; i < myGarden.size(); i++) {
      myGarden.get(i).printInfo();
    }
  }
  
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    String input;
    // TODO: Declare an ArrayList called myGarden that can hold object of type plant
    ArrayList<Plant> myGarden = new ArrayList<Plant>();
    // TODO: Declare variables - plantName, plantCost, colorOfFlowers, isAnnual
    String plantName;
    String plantCost;
    String colorOfFlowers;
    boolean isAnnual;
    
    input = scnr.next();
    while(!input.equals("-1")){
      // TODO: Check if input is a plant or flower
      //       Store as a plant object or flower object
      //       Add to the ArrayList myGarden
      plantName = scnr.next();
      plantCost = scnr.next();
      
      if(input.equals("plant")) {
        Plant plant = new Plant(); //gets plant object
        plant.setPlantName(plantName); //sets plant name
        plant.setPlantCost(plantCost); //sets plant cost
        myGarden.add(plant);
      }
      else if(input.equals("flower")) {
        Flower flower = new Flower(); //gets new flower object
        flower.setPlantName(plantName); //set flower name
        flower.setPlantCost(plantCost); //sets flower cost
        
        isAnnual = scnr.nextBoolean(); //asks for input for if annual
        colorOfFlowers = scnr.next(); //asks input for color of flower
        
        flower.setPlantType(isAnnual); //sets is annual
        flower.setColorOfFlowers(colorOfFlowers); //sets the color of flowers
        myGarden.add(flower);        
      }
      
      input = scnr.next();
    }
    // TODO: Call the method PrintArrayList to print myGarden
    PrintArrayList(myGarden);
  }
}