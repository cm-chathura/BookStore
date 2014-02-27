/* I create a class 'Node' to carry all the data of a book and combine with each node in binary search tree */
/*
class	: Node
Constructors:
	Node(Book book)
*/
public class Node
{
	protected Node left;			//To identify left node
    protected Node right;			//To identify right node
	protected Book book;			//Reference for book objects
	
    /* Constructor for 'Node' Class. This accept Title of book,Author's first name,
	Autor's surname and ISBN number as integer. */
	
    public Node(Book book)
	{    
		// Assign all values to the internel data members of class 'Node'.
		this.book = book; 				
		
    }
	
	
}