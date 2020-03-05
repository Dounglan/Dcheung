import java.util.*;
/**
 * A very simple Document class that can be used to explore
 * issues related to accessibility/visibility
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 2.0
 */
public class Document
{
  // Note that the attributes are protected
  private String       delimiters, text;
  
  /**
   * Explicit Value Constuctor
   *
   * @param text   The text of the document
   */
  public Document(String text)
  {
    this.text = text;
    delimiters = " ,.;:!?\t\n\r";
  }
  /**
   * Append additional text to the end of this Document
   *
   * @param addition   The text to append
   */
  public void append(String addition)
  {
    text = text + addition;
  }
  /**
   * Get a description of this Document that
   * includes a statistical summary
   *
   * @return  The description
   */
  public String getDescription(){
    int          count;
    String       result;
    
    count  = this.getWordCount();
    
    result = "This document has " + count;
    if (count == 1) result += " word ";
    else            result += " words ";
    
    count = this.getLineCount();
    result += "and " + count;
    if (count == 1) result += " line ";
    else            result += " lines ";
    
    return result;
  }
  
  /**
   * Get the text of this Document
   *
   * @return  The text
   */
  public String getText()
  {
    return text;
  }
  
  /**
   * Get the number of lines in this Document
   *
   * @return  The number of lines
   */
//  public int getLineCount() //original
//  {
//    char               character;
//    int                count, i;
//    
//    // Initialize the line counter
//    count = 1;
//    if (text.length() == 0) count = 0; // No words means no lines
//    // Count the number of newline characters
//    for (i=0; i < text.length(); i++) {
//      character = text.charAt(i);
//      if (character == '\n') count = count + 1;
//    }  
//    return count;
//  }
  
  public int getLineCount() //modified version of getLineCount
  {
    char               character;
    int                count, i;
    String             temp;
    
    temp = this.getText();
    // Initialize the line counter
    count = 1;
    if (temp.length() == 0) count = 0; // No words means no lines
    // Count the number of newline characters
    for (i=0; i < temp.length(); i++) 
    {
      character = temp.charAt(i);
      if (character == '\n') count = count + 1;
    }
    return count;
  }
  /**
   * Get the number of words in this Document
   *
   * @return  The number of words
   */
  public int getWordCount()
  {
    int                count;
    StringTokenizer    tokenizer;
    
    tokenizer = new StringTokenizer(text, delimiters);
    
    count = tokenizer.countTokens();
    
    return count;
  }
//overrides the equals method so a Document object can correctly compare another Document object
  public boolean equals(Document other){ //step 14
    return this.text.equals(other.text);
  }
//overrides the toString method so it returns the result of a call to getText()
  public String toString(){
    return this.getText();
  }
  
}