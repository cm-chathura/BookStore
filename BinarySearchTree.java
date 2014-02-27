/*
This class is used to handle Binary Search Tree operations. According to the
assignment, I put three operation methods in this class file. They are Insert,Search and 
Delete operation. User can do search by Book title and ISBN number with overloaded method
'search' and do delete by book title and ISBN numer with overloaded method 'remove'.

Class: 	BinarySearchTree
Constructor: Default constructor
Methods:
	public void insert(Book book)
	public Node search(String title)
	public Node search(int ISBN)
	public boolean remove(String title)
	public boolean remove(int ISBN)
	
*/

public class BinarySearchTree
{
	Node root;	// This node is used for Root element
	
	/*Data insertion method to the Binary Search Tree. This method has one parameter 
	to get data of a book and insert it.*/
	public void insert(Book book)
	{	 
	    // Create a new Node and initialize it. Book reference pass to it	 
	    Node node = new Node(book);
	 
	    // If there is no root this node set as root	 
	    if (root == null)	
		{	 
	        root = node;	 
	    }	
		else	
		{	 
			// Start to find correct place for the note. It start from root.
			// Here I used reference 'pointed_node' to point node objects 
	        Node pointed_node = root;	 	        	 
	        Node parent;	// Parent to reffer parent node of a node		
			
			while (true)		
			{    	 
	            parent = pointed_node;	 	// First, I assigned pointed_node to parent. This is first and top node
	            
				// Here, It compare each node by book title which is inserted book title
				/* If book title is less than to the book title of pointed node, node should be 
				placed in a child of left side from parent */
	            if (book.title.compareTo(pointed_node.book.title) < 0)			
				{		 
	                pointed_node = pointed_node.left;	 
	                // Check if the left child is a leaf	 
	                if (pointed_node == null)				
					{	 
	                    // If true, then place the new node on the left of it	 
	                    parent.left = node;
	                    return; // finish
					}	                
				}			
				else			
				{ // If we get here put the node on the right
					pointed_node = pointed_node.right;	 
	                    // Check if the right child is a leaf	 
	                if (pointed_node == null) 
					{	 
	                    // If true, then place the new node on the right of it	 
	                    parent.right = node;
	                    return; // finish	 
	                }	 
	            }	 
	        }
	    }	 
	}
	
}
