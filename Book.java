/* This class is used for storing data of a book. Each object of this class represents a book of bookshop */
/*
class	: Book
Constructor:
	Book(String title,String author_fname,String author_sname,int isbn)
*/

class Book
{
	protected int isbn;				//ISBN number
    protected String title;			//Title of a book. Title is used as a key of the node.
    protected String author_fname;	//Author's first name
    protected String author_sname;	//Author's surname
	
	// Constructor of Book Class
	public Book(String title,String author_fname,String author_sname,int isbn)
	{    
		// Assign all values to the internel data members of class 'Node'.
		this.title = title; 				// Title is used as a key of the node.
		this.author_fname = author_fname;	// Author first name
		this.author_sname = author_sname;	// Author surname
		this.isbn = isbn;					// ISBN Number as integer
    }
}
