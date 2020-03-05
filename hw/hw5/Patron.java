/*Dounglan Cheung
 * 2.22.2020
 * CIS 351 Hw5
 */

//created by UML diagram
public class Patron  {

	private String name;
	private String email;
	private int idNumber;
	private double balance;

	public Patron(String name, String email, int idNumber, double balance) {
		this.name = name;
		this.email = email;
		this.idNumber = idNumber;
		this.balance = balance;

	}
//updates the current balance of the patron
	public double adjustBalance(double amount){
		this.balance = this.balance + amount;
		return this.balance;
	}
	
//equals method checks if two patrons have the same id number
	  public boolean equals(Object other){
		    if (other instanceof Patron) {
		      if (this.idNumber == (Integer) other){
		        return true;
		      }
		    }
		    else if (other instanceof Integer) {
		      return true;
		    }
		    return false;
		  }
	
	public String toString(){
		return String.format("Name: %s, Id: %d, Balance: $%.2f", this.name, this.email, this.idNumber, this.balance);
	}
}