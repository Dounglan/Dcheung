/* Operator nodes are the internal nodes of a binary expression tree.
 * Dounglan Cheung
 * 4.16.2020 */
public class OperatorNode extends ExpressionNode {
	private Operator op;

	public OperatorNode(Operator op) {
		super();
		this.op = op;
	}

	public OperatorNode(Operator op, ExpressionNode left, ExpressionNode right) {
		super(left, right);
		this.op = op;
	}

	//Evaluate the expression rooted at this node and return the result.
	@Override
	public double evaluate() {
		double value = 0;
		
		if(op.opString() == "*") {
			value = left().evaluate() * right().evaluate();
		}
		else if(op.opString() == "+") {
			value = left().evaluate() + right().evaluate();
		}
		else if(op.opString() == "-") {
			value = left().evaluate() - right().evaluate();
		}
		else if(op.opString() == "/") {
			value = left().evaluate() / right().evaluate();
		}
		return value;
	}

	@Override
	public String postfixString() {
		//Traverse in postorder
		String left = left().postfixString();
		String right = right().postfixString();
		return left + right + op.opString();
	}

	@Override
	public String prefixString() {
		String left = left().prefixString();
		String right = right().prefixString();
		return op.opString() + left + right;
	}

	@Override
	public String infixString() {
		//Traverese in inorder
		String left = left().infixString();
		String right = right().infixString();
		return left + op.opString() + right;
	}
}