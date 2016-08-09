/**
 * @author Anthony Pham
 * @version 2/26/14
 * 
 * LinkedList<E> is a collection of data nodes. All methods here relate to how
 * one can manipulate those nodes.
 */
public class LinkedList<E> {

	private int length;          // number of nodes
    private ListNode<E> firstNode;  // pointer to first node

    public LinkedList()
    {
        length=0;
        firstNode=null;
    }
    
    /** insert new Event at linked list's head
     * 
     * @param newData the Event to be inserted
     */
    public void insertAtHead(E newData)
    {
    	ListNode<E> newnode = new ListNode<E>(newData);
        if (getLength() == 0)
        {
            firstNode=newnode;
        }
        else
        {
            newnode.next=firstNode;
            firstNode=newnode;
        }
        length++;
    }
    
    /**
     * Takes an event and inserts it to the end of the linked list
     * @param new event
     */
    public void insertAtTail(E newData)
    {
    	ListNode<E> newNode;
    	newNode = new ListNode<E>(newData);
    	if (getLength() == 0)
    	{
    		firstNode = newNode;
    	}
    	
    	else
    	{
    		ListNode<E> tempNode;
    		tempNode = firstNode;
    		while (tempNode.next != null)
    		{
    			tempNode = tempNode.next;
    		}
    		tempNode.next = newNode;
    	}
    	length ++;
    }
    
    /**
     * adds data at certain point in linked list
     * @param data new String to be added
     * @param index point at which to add new data
     */
    public void add(E newData, int index)
    {
    	ListNode<E> newNode, currentNode, lastNode;
    	newNode = new ListNode<E>(newData);
    	
    	if (index == 0)
    	{
    		this.insertAtHead(newData);
    	}
    	
    	else if (index == getLength())
    	{
    		this.insertAtTail(newData);
    	}
    	
    	else if (index < getLength())
    	{
    		currentNode = this.getNode(index);
    		lastNode = this.getNode(index-1);
    		lastNode.next = newNode;
    		newNode.next = currentNode;
    		length ++;
    	}
    }
    
    /**
     * removes head node
     * @return head node if there is one, null if there is not
     */
    public E removeHead()
    {
    	if (getLength() == 0)
    	{
    		return null;
    	}
    	
    	else
    	{
    		ListNode<E> tempNode;
    		tempNode = firstNode;
    		firstNode = firstNode.next;
    		length --;
    		return tempNode.data;
    	}
    }
    
    /**
     * removes end of linked list
     * @return data of removed node
     */
    public E removeTail()
    {
    	if (getLength() == 0)
    	{
    		return null;
    	}
    	
    	else
    	{
    		ListNode<E> tempNode;
    		tempNode = firstNode;

    		while (tempNode.next != null)
    		{
    			tempNode = tempNode.next;
    		}
    		length --;
    		return tempNode.data;
    	}
    }
    
    /**
     * removes the data of a node at an index in the linked list
     * @return data of removed node
     */
    public E remove(int index)
    {
    	ListNode<E> currentNode, lastNode;
		
    	if (index >= getLength() || index < 0)
    	{
    		return null;
    	}
    	
    	else if (index == 0)
    	{
    		return this.removeHead();
    	}
    	
    	else if (index == getLength()-1)
    	{
    		return this.removeTail();
    	}
    	
    	else
    	{
    		currentNode = this.getNode(index);
    		lastNode = this.getNode(index-1);
    		lastNode.next = currentNode.next;
    		length --;
    		return currentNode.data;
    	}
    }
    
    /**
     * getter
     * gets node in linked list
     * returns null if node is not in list
     */
    private ListNode<E> getNode(int index)
    {
    	ListNode<E> myNode;
    	myNode = firstNode;
    	
    	
    	if (this.isEmpty() || index > (this.getLength()-1) || index < 0)
    	{
    		return null;
    	}
    	
    	else
    	{
    		int count;
        	count = 0;
    		
    		while (myNode != null && count < index)
        	{
        		
        		myNode = myNode.next;
        		count ++;
        	}
    		return myNode;
    	}
    }
    
    /**
     * getter
     * gets data from index in linked list
     * @return data of node at index
     */
    public E getData(int index)
    {
    	if (this.getNode(index) == null)
    	{
    		return null;
    	}
    	else
    	{
    		return this.getNode(index).data;
    	}
    	
    }
    
    /** Turn entire chain into a string
     *  
     *  @return return linked list as printable string
     */
    public String toString() 
    {
    	String toReturn="(";
    	ListNode<E> n;
    	n=firstNode;
    	while (n!=null)
    	{
    		toReturn = toReturn + n;  //call node's toString automatically
    		n=n.next;
    		if (n!=null)
    		{
    			toReturn = toReturn + ", ";
    		}
    	}
    	toReturn = toReturn + ")";
    	return toReturn;
    }
    
    /**
     * 
     */
    public boolean isEmpty()
    {
    	if (getLength() == 0)
    	{
    		return true;
    	}
    	
    	else
    	{
    		return false;
    	}
    }
    
    /** getter for number of nodes in the linked list
     * 
     * @return length of LL
     */
    public int getLength() {return length;}

}
