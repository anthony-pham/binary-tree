/**
 * @author Anthony Pham
 * @version 3/12/14
 *
 * BSTNode<E> is a building block for a Binary Search Tree of data items
 */
public class BSTNode<E> {

	public E key;
    public BSTNode<E> llink;
    public BSTNode<E> rlink;
    
    /**
     * default constructor
     * @param data new data
     */
    public BSTNode(E data){
    	key = data;  
    	llink=null;
    	rlink=null;
    }
    
    /**
     * @return BSTNode as a printable string
     */
    public String toString() {
    	return "" + key;
    }
}
