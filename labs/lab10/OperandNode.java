
/**
 * Operand nodes form the leaves of expression trees. They store doubles.
 * 
 * @author Farzana Rahman
 * @version 10/2018
 *
 */
public class OperandNode extends ExpressionNode {

  private double number;

  public OperandNode(double number) {
    super();
    this.number = number;
  }

  @Override
  public double evaluate() {
    return number;
  }

  @Override
  public String toString() {
    return "" + number;
  }

  @Override
  public String postfixString() {
    return toString();
  }

  @Override
  public String prefixString() {
    return toString();
  }

  @Override
  public String infixString() {
    return toString();
  }

}
