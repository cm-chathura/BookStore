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
	
	/* Data searching method of Binary Search Tree. This method has one parameter to
	get title of a book for searching */
	public Node search(String title) 
	{	 
	    // Begins from the root node. So root node assigned to the pointed_node reference. 
	    Node pointed_node = root;	 
	    
		// Check, more nodes of Binary Search Tree
	    while (pointed_node.book.title != title) 
		{	 
	        // If we should search to the left	 
	        if (title.compareTo(pointed_node.book.title) < 0) 	
			{	 
	            // Shift the pointed Node to the left child	node 
	            pointed_node = pointed_node.left;	 
	        } 	
			else 	
			{	 
	            // Shift the pointed Node to the right child node 
	            pointed_node = pointed_node.right;	 
	        }	 
	        
			// If the node was not found, return null	 
	        if (pointed_node == null)
	            return null;	 
	    }
	    return pointed_node;	 
	}
	
	/* Data searching method of Binary Search Tree. This method has one parameter to
	get isbn number of a book for searching. This is overloaded method to accept ISBN number*/
	public Node search(int isbn) 
	{	 
	    // Begins from the root node. So root node assigned to the pointed_node reference. 
	    Node pointed_node = root;	 
	    // Check, more nodes of Binary Search Tree	 
	    while (pointed_node.book.isbn != isbn) 
		{	 
	        // If we should search to the left	 
	        if (isbn < pointed_node.book.isbn) 	
			{	 
	            // Shift the pointed Node to the left child	node	 
	            pointed_node = pointed_node.left;	 
	        } 	
			else 	
			{	 
	            // Shift the pointed Node to the right child node 
	            pointed_node = pointed_node.right;	 
	        }	 
	        // If the node was not found, return null 
	        if (pointed_node == null)
	            return null;	 
	    }
	    return pointed_node;	 
	}
	
	
	/* Data removing from Binary Search Tree. This method has one parameter get title
	of a book for removing. */
	public boolean remove(String title) 
	{
        Node parent = null;			// create parent reference to point parent node of a node	
		Node pointednode = root;	// create reference to point nodes	
		Node parentnode = root;		// create reference to get parent node temporarly
		char child = 'X';			// put status of child node as it is left or right. 'l' - Left and 'r' - Right
		boolean isRoot = true;		// to identify root node status. If some value passed the root node, isRoot will be false.
	    
		// Check node by title and go through the Binary Search Tree	until meets the node which should be delete
	    while (pointednode.book.title != title) 
		{	 
	        // If we should search to the left	
			isRoot = false;				// If it enters into find more, isRoot should be false. because counter passed the root
			parentnode = pointednode;
	        if (title.compareTo(pointednode.book.title) < 0) 	
			{	 
	            // Shift the pointed Node to the left child	node  
	            pointednode = pointednode.left;	
				child = 'l';	// set child status to 'l' - left
	        } 	
			else 	
			{	 
	            // Shift the pointed Node to the right child node 
	            pointednode = pointednode.right;
				child = 'r';	// set child status to 'r' - right
	        }		        
	    }
	    
		// If the node was not found, return false 
		if (pointednode == null) 
		{
            return false;
        }
		
		/* With this code,remove the node which should be deleted, if it is only a leaf node.
		The node set to null directly. */		
		if ((pointednode.left == null) && (pointednode.right == null)) // Check the pointed node has not any child nodes
		{
			if(isRoot == true) // If isRoot is true, it is root. Then it will be set to null and remove
			{
				root = null;
			}
			else
			{
				/* Check if the node which should be deleted is from left or right node from its parent node.
				We set it to null from it's parent node. This method is used to delete unreferenced objects
				from the scope */
				if(child == 'l')		
				parentnode.left = null;		// If child is left, set left child of parent node to left
				else
				parentnode.right = null;	// If child is right, set right child of parent node to left
				System.gc();				// Activate garbage collection to delete null referenced objects
			}			
			return true; // Return to the caller with successfull true value
        }
		
		/* With this code,remove the node which should be deleted, if it is with both left and right children.
		The node set to null with procedure. */
		if ((pointednode.left != null) && (pointednode.right != null)) // Check the pointed node has both child nodes
		{            
			if(isRoot == true)	// If isRoot is true, it is root. Then ,
			{				
				//Here I used a special method to get node with minimum value and to delete current node
				root.book = getMinimum(root.right).book; 	// remove root node with putting appropriate node in that place
			}
			else
			{
				/* Check if the node which should be deleted is from left or right node from its parent node. 
				Again I use getMinimum value(Node) method to find node with minimum value and to return it with 
				deleting current node. Here the node will not be deleted physically. It will restore with returning book values*/
				if(child == 'l')
				parentnode.left.book = getMinimum(pointednode.right).book; 
				else
				parentnode.right.book = getMinimum(pointednode.right).book;
				System.gc();	// Activate garbage collection to delete null referenced objects				
			}			
            return true;		// Return to the caller with successfull true value
        }
		
		/* With this code,remove the node which should be deleted, if it is with left child.
		The node set to null with combining left child of pointed node. */
        if (pointednode.left != null) 
		{
			if(isRoot == true)	// If isRoot is true, it is root. Then it will be set to null and remove
			{
				root = pointednode.left;
			}
			else
			{
				/* Check if the node which should be deleted is from left or right node from its parent node. 
				Node will restore with next left child node book values*/
				if(child == 'l')
				parentnode.left = pointednode.left;
				else
				parentnode.right = pointednode.left;
				System.gc();	// Activate garbage collection to delete null referenced objects
				pointednode.left = null;	// Left child node of pointed node set to null after get its values. 
			}
            return true;	// Return to the caller with successfull true value
        }

		/* With this code,remove the node which should be deleted, if it is with right child.
		The node set to null with combining right child of pointed node. */
        if (pointednode.right != null) 
		{
			if(isRoot == true)	// If isRoot is true, it is root. Then it will be set to null and remove
			{
				root = pointednode.right;
			}
			else
			{
				/* Check if the node which should be deleted is from left or right node from its parent node. 
				Node will restore with next right child node book values*/
				if(child == 'l')
				parentnode.left = pointednode.right;
				else
				parentnode.right = pointednode.right;
				System.gc();	// Activate garbage collection to delete null referenced objects
				pointednode.right = null;	// Right child node of pointed node set to null after get its values.
			}		
            return true;	// Return to the caller with successfull true value
        }
		
		parent = pointednode;        
		return remove(title);
    }
	
	/* Data removing from Binary Search Tree. This method has one parameter get title
	of a book for removing. This is a overloaded method to accept isbn number to removing node*/
	public boolean remove(int isbn) 
	{
        Node parent = null;			// create parent reference to point parent node of a node
		Node pointednode = root;	// create reference to point nodes
		Node parentnode = root;		// create reference to get parent node temporarly
		char child = 'X';			// put status of child node as it is left or right. 'l' - Left and 'r' - Right
		boolean isRoot = true;		// to identify root node status. If some value passed the root node, isRoot will be false.
	    	
		// Check node by ISBN number and go through the Binary Search Tree	until meets the node which should be delete
	    while (pointednode.book.isbn != isbn) 
		{	 
	        // If we should search to the left
			isRoot = false;		// If it enters into find more, isRoot should be false. because counter passed the root
			parentnode = pointednode;
	        if (isbn > pointednode.book.isbn) 	
			{	 
	            // Shift the pointed Node to the left child	node
	            pointednode = pointednode.left;	
				child = 'l';		// set child status to 'l' - left
	        } 	
			else 	
			{	 
	            // Shift the pointed Node to the right child node 	 
	            pointednode = pointednode.right;
				child = 'r';		// set child status to 'r' - right
	        }		        	
	    }
	    
		// If the node was not found, return false
		if (pointednode == null) 
		{
            return false;
        }
		
		/* With this code,remove the node which should be deleted, if it is only a leaf node.
		The node set to null directly. */
		if ((pointednode.left == null) && (pointednode.right == null)) 	// Check the pointed node has not any child nodes
		{
			if(isRoot == true)	// If isRoot is true, it is root. Then it will be set to null and remove
			{
				root = null;
			}
			else
			{
				/* Check if the node which should be deleted is from left or right node from its parent node.
				We set it to null from it's parent node. This method is used to delete unreferenced objects
				from the scope */
				if(child == 'l')
				parentnode.left = null;		// If child is left, set left child of parent node to left
				else
				parentnode.right = null;	// If child is right, set right child of parent node to left
				System.gc();				// Activate garbage collection to delete null referenced objects
			}			
			return true;		// Return to the caller with successfull true value
        }
		
		/* With this code,remove the node which should be deleted, if it is with both left and right children.
		The node set to null with procedure. */
		if ((pointednode.left != null) && (pointednode.right != null)) 	// Check the pointed node has both child nodes
		{
            // node with two children
			if(isRoot == true)	// If isRoot is true, it is root. Then ,
			{
				//Here I used a special method to get node with minimum value and to delete current node
				root.book = getMinimum(root.right).book;	// remove root node with putting appropriate node in that place
			}
			else
			{
				/* Check if the node which should be deleted is from left or right node from its parent node. 
				Again I use getMinimum value(Node) method to find node with minimum value and to return it with 
				deleting current node. Here the node will not be deleted physically. It will restore with returning book values*/
				if(child == 'l')
				parentnode.left.book = getMinimum(pointednode.right).book;
				else
				parentnode.right.book = getMinimum(pointednode.right).book;
				System.gc();	// Activate garbage collection to delete null referenced objects			
			}			
            return true;		// Return to the caller with successfull true value
        }
		
		/* With this code,remove the node which should be deleted, if it is with left child.
		The node set to null with combining left child of pointed node. */
        if (pointednode.left != null) 
		{
			if(isRoot == true)	// If isRoot is true, it is root. Then it will be set to null and remove
			{
				root = pointednode.left;
			}
			else
			{
				/* Check if the node which should be deleted is from left or right node from its parent node. 
				Node will restore with next left child node book values*/
				if(child == 'l')
				parentnode.left = pointednode.left;
				else
				parentnode.right = pointednode.left;
				System.gc();	// Activate garbage collection to delete null referenced objects
				pointednode.left = null;	// Left child node of pointed node set to null after get its values.
			}
            return true;	// Return to the caller with successfull true value
        }

		/* With this code,remove the node which should be deleted, if it is with right child.
		The node set to null with combining right child of pointed node. */
        if (pointednode.right != null) 
		{
			if(isRoot == true)	// If isRoot is true, it is root. Then it will be set to null and remove
			{
				root = pointednode.right;
			}
			else
			{
				/* Check if the node which should be deleted is from left or right node from its parent node. 
				Node will restore with next right child node book values*/
				if(child == 'l')
				parentnode.left = pointednode.right;
				else
				parentnode.right = pointednode.right;
				System.gc();	// Activate garbage collection to delete null referenced objects
				pointednode.right = null;	// Right child node of pointed node set to null after get its values.
			}		
            return true;	// Return to the caller with successfull true value
        }
		
		parent = pointednode;        
		return remove(isbn);
    }
	
	/* This method will find the node with minimum value and return it to the caller.
	When it was found node will delete with set it into remove method with recursivly checking.
	This method accept one parameter with node object. */
	protected Node getMinimum(Node node) 
	{		
			if(node.left == null)		// If pointed node has not left child,
			{
				Node b = new Node(node.book);	// Temporarly store node in new object of node with reference 'b'	
				remove(node.book.title);		// call remove method with book title to find and delete it
				return b;						// Return stored data of b
			}
			else if (node.left.left == null)  	// If pointed node has left child and the child has no left child,
			{
				Node b = node.left;				// New referencr 'b' refer to left child of 'node'
				remove(b.book.title);			// call remove method with book title to find and delete it	
				return b;						// Return stored data of b
			}				
		return getMinimum(node.left);	// Recursively find the node minimum value
    }
	
}