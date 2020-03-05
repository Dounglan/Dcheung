public class Driver5
{
    /**
     * The entry point of the application
     *
     * @param args   The command line arguments
     */
  public static void main(String[] args)
  {
//    Document a; //, b;
    FormattedDocument a; //step 28
    String text;
    
    text = "George is a little monkey, "+
      "and all monkeys are curious.\n"+
      "But no monkey is as curious "+
      "as George.";
    
//    a = new Document(new String(text));
    a = new FormattedDocument(new String(text), 20); //step 28
//        b = new Document(new String(text));
    
//        System.out.println(a == b); //starting code
//        System.out.println(a.equals(b)); //step 7
       System.out.println(a.toString()); //step 17
  }
}