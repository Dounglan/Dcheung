/*Simple test driver for new BST methods.
 * @author Farzana
 * @version 11/2019*/
public class TestDriver {
  
  // Call desired tests here.
  public static void main(String[] args) {
    testMinElement();
    System.out.println();
    testMaxElement();
    System.out.println();
    testRecursiveSize();
    System.out.println();
    testMakeOrderedList();
    System.out.println();
    testIsBST();
  }
  
  //Test the minElement method.
  public static void testMinElement() {
    BST<Integer> bst = new BST<>();
    for (int num : new int[]{4, 5, 2, 8, 9, 1, 3}) {
      bst.insert(num);
      System.out.println("Min: " + bst.minElement());
    }
  }
  
  //Test the maxElement method.
  public static void testMaxElement() {
    BST<Integer> bst = new BST<>();
    for (int num : new int[]{4, 5, 2, 8, 9, 1, 3}) {
      bst.insert(num);
      System.out.println("Max: "+ bst.maxElement());
    }
  }
  
  //Test the recursiveSize method.
  public static void testRecursiveSize() {
    BST<Integer> bst = new BST<>();
    for (int num : new int[]{4, 5, 2, 8, 9, 1, 3}) {
      System.out.println("Size should be " + bst.size() + " it is: " + bst.recursiveSize());
      bst.insert(num); 
    }
  }
   
  //Test the makeOrderedList method.
  public static void testMakeOrderedList() {
    
    BST<Integer> bst = new BST<>();
    for (int num : new int[]{4, 5, 2, 8, 9, 1, 3}) {
      bst.insert(num);
    }
    
    System.out.println("ORDERED:");
    LList<Integer> list = bst.makeOrderedList();
    
    for (list.moveToPos(0); !list.isAtEnd(); list.next() ) {
      System.out.println(list.getValue());
    }
  }
  
  //Test the isBST method.
  public static void testIsBST() {
   
    BST<Integer> bstOK = new BST<>();
    bstOK.root = new BSTNode<>(10);
    bstOK.root.setLeft(new BSTNode<>(7));
    bstOK.root.setRight(new BSTNode<>(15));
    bstOK.root.left().setLeft(new BSTNode<>(2));
    bstOK.root.left().setRight(new BSTNode<>(8));
    bstOK.root.right().setLeft(new BSTNode<>(14));
    
    BST<Integer> bstEasyBroken = new BST<>();
    bstEasyBroken.root = new BSTNode<>(10);
    bstEasyBroken.root.setLeft(new BSTNode<>(7));
    bstEasyBroken.root.setRight(new BSTNode<>(3));
   
    BST<Integer> bstSneakyBroken = new BST<>();
    bstSneakyBroken.root = new BSTNode<>(10);
    bstSneakyBroken.root.setLeft(new BSTNode<>(7));
    bstSneakyBroken.root.setRight(new BSTNode<>(15));
    bstSneakyBroken.root.left().setLeft(new BSTNode<>(2));
    bstSneakyBroken.root.left().setRight(new BSTNode<>(11));
    bstSneakyBroken.root.right().setLeft(new BSTNode<>(14));
    
    System.out.println("Should be true: "+ bstOK.isValidBST());
    System.out.println("Should be false: "+ bstEasyBroken.isValidBST());
    System.out.println("Should be false: "+ bstSneakyBroken.isValidBST());
  }

}