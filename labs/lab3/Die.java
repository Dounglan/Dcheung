/**
  * Die class simulates a six-sided gaming die.
  *
  * @author Dounglan Cheung
  * @version - 2.5.2020
  */
public class Die
{

  private int face;

  /**
    * Constructs a new die object, initializing face to a random value
    */
  public Die()
  {
    roll();
  }

  /**
    * Simulates the roll of the die.
    *
    * @return The new face value of the die
    */
  public int roll()
  {
    face = (int) (Math.random() * 6) + 1;
    return face;
  }

  /**
    * Gets the current face value of the die
    *
    * @return The current face value of the die
    */
  public int getFace()
  {
    return face;
  }
}
