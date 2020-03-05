/* Node class for a simple linked list of Strings.
 * @author Farzana Rahman*/
public class Node
{
    private Node next;
    private String value;

    public Node(Node next, String value)
    {
        this.next = next;
        this.value = value;
    }

    public Node(String value)
    {
        this(null, value);
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}