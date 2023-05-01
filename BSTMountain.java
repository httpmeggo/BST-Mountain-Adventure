/**
 * This class represents the mountain that this 
 * program is based on. It stores data items of 
 * the type RestStop, created in the RestStop class.
 * This class implements a binary search tree.
 * 
 * @author Megan Nicius
 * 
 * @version 24 April 2021
 */
package project5;

import java.util.Comparator;

public class BSTMountain {

	/**
	 * This private class is used to create nodes of type RestStop that
	 * are used in a binary search tree implementation.
	 * @author Megan Nicius
	 *
	 * @param <RestStop>
	 */
	private class BSTNode<RestStop>{
		
		private RestStop data;
		private BSTNode<RestStop> left;
		private BSTNode<RestStop> right;
		
		/**
		 * Constructs a BSTNode with data of type RestStop
		 * @param data contains information about the RestStop
		 */
		private BSTNode(RestStop data) {
			data = data;
			left = null;
			right = null;
		}
		
		/**
		 * Default constructor
		 */
		private BSTNode() {
			
		}

		/**
		 * Lexicographically compares data of type RestStop according to natural sorting of data
		 * @param rs
		 * @return 0 if data are equal, a value less than 0 if data is less than
		 * rs.data, and a value greater than 0 if data is greater than rs.data
		 */
		public int compareTo(BSTNode<RestStop> rs) {
			return ((BSTNode<RestStop>) data).compareTo((BSTNode<RestStop>) rs.data);
		}
	}
	
	//private variable that is used to reference the root node
	private BSTNode<RestStop> root;
	//private comparator variable that is used to create a new order for
	//the nodes of the BST
	private Comparator<RestStop> comparator;

	/**
	 * This constructor creates a new BST that is sorted by its
	 * natural order.
	 */
	public BSTMountain() { 
		comparator = null; 
		root = null;
	}
	
	/**
	 * This constructor creates a new BST that is sorted based
	 * on the comparator.
	 */
    public BSTMountain(Comparator<RestStop> comparator) {
        this.comparator = comparator;
    }
    
    /**
     * This method allows for the root to be accessed outside of this class.
     * @return root node of BST
     */
	public BSTNode getRoot() {
		return root;
	}

	/**
	 * This method allows for the root to be set outside of this class.
	 * @param root new root node that root will be set to.
	 */
	public void setRoot(BSTNode root) {
		this.root = root;
	}

	/**
	 * This method allows for the comparator to be accessed outside of
	 * this class.
	 * @return comparator of type Comparator<RestStop>
	 */
	public Comparator<RestStop> getComparator() {
		return comparator;
	}

	/**
	 * This method allows for the comparator to be set outside of
	 * this class.
	 * @param comparator another comparator of type Comparator<RestStop>
	 */
	public void setComparator(Comparator<RestStop> comparator) {
		this.comparator = comparator;
	}
	
	/**
	 * This method creates a new node using data of type RestStop.
	 * @param here data of type RestStop containing information about the
	 * specific rest stop that the node represents.
	 * @return myStop a newly created node that represents the current rest stop.
	 */
	public BSTNode<RestStop> newNode(RestStop here){
		//create new BSTNode object
		BSTNode<RestStop> myStop = new BSTNode();
		//set myStop data and child node pointers
		myStop.data = here;
		myStop.left = null;
		myStop.right = null;
		return myStop;
	}
	
	/**
	 * This method creates a new node using data of type RestStop. It invokes
	 * the method newNode() to create a new node.
	 * Notice: this method does not entirely work as intended.
	 * @param node the node representing the current rest stop
	 * @param stop the data of the current rest stop
	 * @return node node that is newly added to BST
	 */
	public BSTNode<RestStop> insert(BSTNode node, RestStop stop) {
		
		//check if given node is null
		if(node == null) {
			return newNode(stop);
		}
		//use compareTo to assign left and right child nodes
		if(node.compareTo(newNode(stop)) < 0) {
			node.left = insert(node.left, stop);
		}
		else if(node.compareTo(newNode(stop)) > 0) {
			node.right = insert(node.right, stop);
		}
		return node;
	}
	
	/**
	 * This method is used to convert the binary search tree to a String
	 * which can then be displayed.
	 * @return buff.toString() call to recursive helper method
	 * @author Joanna Klukowska
	 */
	public String toStringTree( ) {
		StringBuffer buff = new StringBuffer(); 
		toStringTree(buff, root, 0);
		return buff.toString();
	}


	/**
	 * This method uses preorder traversal to display the nodes
	 * of the tree as Strings, provided that the data in each node
	 * returns on one line when called with data.toString()
	 * @param buff StringBuffer that creates modified String objects
	 * which are appended to in order to properly format the display
	 * @param node used to get data from each node of the tree
	 * @param level used to keep track of each level of the tree
	 * in order so preorder traversal can be returned
	 * @author Joanna Klukowska
	 */
	private void toStringTree( StringBuffer buff, BSTNode node, int level ) {
		//display the node 
		if (level > 0 ) {
			for (int i = 0; i < level-1; i++) {
				buff.append(" ");
			}
			buff.append(" ");
		}
		if (node == null) {
			buff.append( "\n"); 
			return;
		}
		else {
			buff.append( node.data + "\n"); 
		}

		//display left subtree using recursive call 
		toStringTree(buff, node.left, level+1); 
		//display right subtree using recursive call
		toStringTree(buff, node.right, level+1); 
	}
}
