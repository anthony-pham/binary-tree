/**
 * @author Anthony Pham
 * @version 2/26/14
 * 
 * ListNode<E> is a building block for a linked list of data items
 */
public class ListNode<E> {
	
	 public E data;
	 public ListNode<E> next;   // pointer to next node
	    
	 /** Non-default constructor
	 * 
	 * @param String you want stored in this node
	 */
	 public ListNode(E newData)
	 {
		 this.data = newData;
	     this.next = null;
	 }
	    
	 // if you say "System.out.println(N)" where N is a ListNode<E>, the
	 // compiler will call this method automatically to print the contents
	 // of the node.  It's the same as saying "System.out.println(N.toString())"
	 public String toString()
	 {
	     return data.toString();  // call the toString() method in Event class
	 }	    
}
