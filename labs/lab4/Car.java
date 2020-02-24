//Dounglan Cheung, dcheun01@syr.edu
//2.12.2020
//lab4
//create a car class

//pt2
/*Create three instance variables within the class: an int that holds the car's model year,
a String that holds the car's make, an double that holds the car's speed. These should be
listed as private*/
public class Car {
  private String make;
  private int year;
  private double speed;
/*Create a constructor that accepts the model year and make and sets the speed to 0. Note
that either you should make the constructor's parameters a different name than the instance
variables or use the " this " qualifier when placing the parameter's value into the instance
variable*/  
  public Car(String make, int year) {
    this.make = make;
    this.year = year;
    this.speed = 0;
  }
  public String toString() {
    return String.format("A %d %s that is going %.1f mph", year, make, speed);
  }
//pt4
//create Accessor methods that let you access each individual element of the Car.
  public double getSpeed(){
    return speed;
  }
  public String getMake() {
    return make;
  }
  public int getYear(){
    return year;
  }
//create 2 mutator methods, they are void methods and take no parameters
  public void accelerate(){
    speed = speed + 5;
  }
  public void brake(){
    speed = speed - 5;
  }
} 