/*This class is provide practice dealing with arrays
*@author - Doung Lan Cheung
*2.5.2020
*/

public class ArrayPlay {
  public static void main(String[] args) {
    
    int[] test1 = new int[6]; //initialize the array to 6 elements
    for (int i = 0; i < test1.length; i++) {
      test1[i] = -1;  //set each index to -1
    }
    for (int i = 0; i < test1.length; i++) {
      System.out.println(i+1 +" was rolled " + test1[i]+ " times.");
    }   
//part2    
    int[] test2 = new int [6]; //initialize the array to 6 elements
    for (int j = 0; j < test2.length; j++) { 
      test2[j] = j;  //set each index to the corresponding j 
    }
    for (int j = 0; j < test2.length; j++) {
      System.out.println(j+1 +" was rolled " + test2[j]+ " times."); //prints how many times the number of j is rolled
    }    
//given code
    int[] first = new int[6];
    for (int i = 0; i < first.length; i++)
    {
      first[i] = 0;
    }
    
    Die dice = new Die();
    int face;
    for (int ii = 0; ii < 100; ii++)
    {
      face = dice.roll();
      first[face-1] += 1;
    }
  
    for (int i = 0; i <first.length; i++)
    {
      System.out.println(i+1 +" was rolled " + first[i]+ " times.");
    }
//end of given code
    System.out.println("Part3");    
//part3
    Die diceMe = new Die(); //creates new Die object
    int faceMe;
    for (int iii = 0; iii < 100; iii++) { //loop iterating 100 times
      faceMe = diceMe.roll();  //rolls
      test2[faceMe-1] += 1; //takes result of roll, maps it to a location in the array, and increments that cell of the array
    }
//The value of each array element will be a count of the number of times that roll is made. So if 1 comes up three times, array[0] should have the value 3.
    for (int iii = 0; iii < test2.length; iii++) { 
      System.out.println(iii+1 +" was rolled " + test2[iii]+ " times.");
    }
    
//This is for Working with two arrays
    double[] one = {4.5, 11.2, 13.5, 19.2, 88.3, 68.1, 99.5,100.2,1771.4, 912312};
    double[] two = new double[10];
    
    System.out.println("Before:");
    for (int i = 0; i < one.length; i++)
    {
      System.out.println(one[i]+"    "+two[i]);
    }
    for (int i = 0; i < one.length; i++)
    {
      two[i] = one[i];
    }
    System.out.println("After:");
    for (int i = 0; i < one.length; i++)
    {
      System.out.println(one[i]+"    "+two[i]);
    }
    one[2] = 1921421321.1;
    two[5] = 56159312.4;
    System.out.println("After Change:");
    for (int i = 0; i < one.length; i++)
    {
      System.out.println(one[i]+"    "+two[i]);
    }
    
    System.out.println("Part4");
//part4
//Need two double arrays. Declare these and then use an initializer list to initialize one of the arrays to 10 double values (of your choice).
    double[] list1 = {1.2, 5.6, 6.6, 124.3, 1000, 999, 99.5, 10.1, 20.0, 456.7};
//Instantiate the other array to 10 elements, but do not initialize the contents.
    double[] list2 = new double[10];
//Print the contents of both arrays. Print them side by side on your screen. Label this output,Before.
    System.out.println("Before:");
    for (int i = 0; i < list1.length; i++)
    {
      System.out.println(list1[i] + "\t" + list2[i]);
    }
//Copy the contents of the first array to the second array and again print their contents side by side; After.
    for (int i = 0; i < list1.length; i++)
    {
      list2[i] = list1[i];
    }
    System.out.println("After:");
    
    for (int i = 0; i < list1.length; i++)
    {
      System.out.println(list1[i] + "\t" + list2[i]);
    }
//change the contents of one element of the first array and a different element of the second array. (assign a different number than before).
    list1[7] = 1.0;
    list2[2] = 12345;
    System.out.println("After Change:");
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i]+ "\t" + list2[i]);
    }
  }
}