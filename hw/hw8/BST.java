/* OpenDSA Project Distributed under the MIT License
 * Copyright (c) 2011-2016 - Ville Karavirta and Cliff Shaffer
 */

class BST<E extends Comparable<E>> {
	protected BSTNode<E> root; // Root of the BST
	protected int nodecount; // Number of nodes in the BST

	// constructor
	BST() {
		root = null;
		nodecount = 0;
	}

	// Reinitialize tree
	public void clear() {
		root = null;
		nodecount = 0;
	}

	// Insert a record into the tree.
	// Records can be anything, but they must be Comparable
	// e: The record to insert.
	public void insert(E e) {
		root = inserthelp(root, e);
		nodecount++;
	}

	private BSTNode<E> inserthelp(BSTNode<E> rt, E e) {
		if (rt == null)
			return new BSTNode<E>(e);
		if (rt.element().compareTo(e) >= 0)
			rt.setLeft(inserthelp(rt.left(), e));
		else
			rt.setRight(inserthelp(rt.right(), e));
		return rt;

	}

	// Return the record with key value k, null if none exists
	// key: The key value to find
	public E find(E key) {
		return findhelp(root, key);
	}

	private E findhelp(BSTNode<E> rt, E key) {
		if (rt == null)
			return null;
		if (rt.element().compareTo(key) > 0)
			return findhelp(rt.left(), key);
		if (rt.element().compareTo(key) == 0)
			return rt.element();
		else
			return findhelp(rt.right(), key);
	}

	// Return the number of records in the dictionary
	public int size() {
		return nodecount;
	}

	//Recursively calculate the number of nodes in this BST.   
	public int recursiveSize() {
		return sizeHelper(root);
	}
	
	//Size Helper
	public int sizeHelper(BSTNode<E> node) {
		if (node == null) {
			return 0;
		}
		else {
			return 1 + sizeHelper(node.left()) + sizeHelper(node.right());
		}
	}

	//Return the smallest element in the tree.
	//keep going to the left node until there's no more left node
	public E minElement() {
		return min(root);
	}
	
	//Min helper
	public E min(BSTNode<E> node) {
	    if (node.left() == null) 
	        return node.element();
	    else {
	    	return min(node.left()); 
	    }
	}
	
	//Return the largest element in the tree.
	//keep going to the right node until there's no more right node
	public E maxElement() {
		return max(root);
	}
	
	//Max helper 
	public E max(BSTNode<E> node) {
	    if (node.right() == null) 
	        return node.element();
	    else {
	    	return max(node.right()); 
	    }
	}
	//Return an ordered linked list containing all of the elements from the tree.
	public LList<E> makeOrderedList() {
		LList<E> orderList = new LList<E> (); //creates a new Linked List
		orderListHelper(root, orderList); 
		return orderList;
	}
	
	//Order List Helper
	public void orderListHelper(BSTNode <E> node, LList<E> orderList){
		if (node != null) {
			orderListHelper(node.left(), orderList);
			orderList.append(node.element());
			orderListHelper(node.right(), orderList);
		}
	}
	
	/* Return true if this BST actually has the BST property and false if it does not.
	 * (Note that this method would typically not be necessary. It a correctly
	 * coded BST there will be no possibility of violating the BST property.)*/
	/*Property:
	//left subtree of a node contains only nodes with keys lesser than the node's key.
	right subtree of a node contains only nodes with keys greater than the node's key.*/
	public boolean isValidBST() {
		return validHelper(root);
	}
	
	public boolean validHelper(BSTNode<E> node) {
		//base case
		if(node == null || node.isLeaf()) {
			return true;
		}
		//other cases
		if(node.left() != null && max(node.left()).compareTo(node.element()) > 0){
			return false;
		}
		if(node.right() != null && min(node.right()).compareTo(node.element()) < 0) {
			return false;
		}
		//recursive call
		else {
			return validHelper(node.left()) && validHelper(node.right());
		}
	}
//end of BST class
}