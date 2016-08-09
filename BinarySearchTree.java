/**
 * @author Anthony Pham
 * @version 3/12/14
 * 
 * This class is the ADT: Binary Search Tree.
 * A binary search tree can handle tree operations like insertion, deletion, searching, toString, etc.
 */
public class BinarySearchTree<E extends Comparable<E>> {
	
	private BSTNode<E> root;
	
	/**
	 * default constructor
	 */
	public BinarySearchTree()
	{
		root = null;
	}
	
    /**
     * private recursive helper method of insert
     * 
     * @param T subroot of tree to insert into
     * @param newNode  the node to insert
     */
    private void insert(BSTNode<E> T, BSTNode<E> newNode) {
    	if ( T.key.compareTo(newNode.key) < 0 ) 
    	{  //key implements compareTo
    		if (T.rlink == null) 
    		{
    			T.rlink = newNode;
    		}
    		else 
    		{
    			insert(T.rlink, newNode);
    		}
    	}
    	
    	else 
    	{  // newNode should go on left
    	  if (T.llink == null) 
    	  {
    		  T.llink = newNode;
    	  }
    	  else 
    	  {
  		  insert(T.llink, newNode);
    	  }
    	}
    }
  
    /**
     * inserts data into BST    
     * @param K data to insert
     */
    public void insert(E K) {
      // use the recursive helper method
      // to do the actual work of insertion
  	  BSTNode<E> newNode = new BSTNode<E>(K);
  	  if (root==null){
  		  root = newNode;
  	  }
  	  else {
  		  insert(root,newNode);
  	  }
    }
    
    /**
     * finds inorder successor to node given
     * @param T node to find replacement for
     * @return BSTNode<E> replacement node
     */
    private BSTNode<E> findReplacement(BSTNode<E> T)
    {
    	BSTNode<E> runner = T;
    	runner = T.rlink;
    	while (runner.llink != null)
    	{
    		runner = runner.llink;
    	}
    	return runner;
    }
    
    /**
     * helper recursive method to searchForParent
     * @param T node to find parent of
     * @param subroot to begin search
     * @return parent of T or null if T is root
     */
    private BSTNode<E> searchForParent(BSTNode<E> subroot, BSTNode<E> T)
    {
    	
    	if (T.key.compareTo(subroot.key) > 0 || subroot.llink == null) // T goes on right
		{
    		if (subroot.rlink.key.compareTo(T.key) == 0)
    		{
    			return subroot;
    		}
    		
    		else
    		{
    			return searchForParent(subroot.rlink, T);
    		}
			
		}
    	
    	else // T goes on left
    	{
    		if (subroot.llink.key.compareTo(T.key) == 0)
    		{
    			return subroot;
    		}
    		
    		else
    		{
    			return searchForParent(subroot.llink, T);
    		}
    	}
    }
    
    /**
     * finds parent of node
     * @param T node to find parent of
     * @return parent of T or null if T is root
     */
    private BSTNode<E> searchForParent(BSTNode<E> T)
    {
    	return searchForParent(root, T);
   }
    
    /**
     * helper iterative method to delete
     * deletes node from Binary Search Tree
     */
    private void delete(BSTNode<E> V)
    {
    	if (V.llink == null && V.rlink == null) // Case 1 V is a leaf
    	{
    		if (V == root) // Case 1a V is the root
    		{
    			root = null;
    		}
    		
    		else //Case 1b V is not the root
    		{
    			BSTNode<E> Pv = this.searchForParent(V);
    			if (Pv.llink == V)
    			{
    				Pv.llink = null;
    			}
    			
    			else
    			{
    				Pv.rlink = null;
    			}
    			
    		}
    	}
    	
    	else if (V.rlink != null && V.llink == null) // Case 2 V has 1 (right) kid
    	{
    		if (V == root) // Case 2a V is the root
    		{
    			root = V.rlink;
    		}
    		
    		else // Case 2b V is not the root
    		{
    			BSTNode<E> Pv = this.searchForParent(V);
    			if (Pv.llink == V)
    			{
    				Pv.llink = V.rlink;
    			}
    			
    			else
    			{
    				Pv.rlink = V.rlink;
    			}
    		}
    	}
    	
    	else if (V.rlink == null && V.llink != null) // Case 2 V has one left kid
    	{
    		if (V == root) // V is the root
    		{
    			root = V.llink;
    		}
    		
    		else // V is the root
    		{
    			BSTNode<E> Pv = this.searchForParent(V);
    			if (Pv.llink == V)
    			{
    				Pv.llink = V.llink;
    			}
    			
    			else
    			{
    				Pv.rlink = V.llink;
    			}
    		}
    	}
    	
    	else if (V.rlink != null && V.llink != null) // V has 2 subtrees
    	{
    		if (V == root) //V is the root
    		{
    			BSTNode<E> Pr, R;
    			R = this.findReplacement(V);
    			Pr = this.searchForParent(R);
    			
    			if (Pr != V) //Parent of replacement is not the victim
    			{
    				Pr.llink = R.rlink;
    				R.llink = V.llink;
    				R.rlink = V.rlink;
    				root = R;
    			}
    			
    			else //Parent of replacement is the victim
    			{
    				R.llink = Pr.llink;
    				root = R;
    			}
    		}
    		
    		else //V is not the root
    		{
    			BSTNode<E> Pr, R, Pv;
    			R = this.findReplacement(V);
    			Pr = this.searchForParent(R);
    			Pv = this.searchForParent(V);
    			if (Pr != V) //Parent of replacement is not the victim
    			{
    				R.llink = V.llink;
    				Pr.llink = R.rlink;
    				R.rlink = V.rlink;
    				
    				if (Pv.llink == V)
    				{
    					Pv.llink = R;
    				}
    				
    				else
    				{
    					Pv.rlink = R;
    				}
    				
    			}
    			
    			else //Parent of replacement is the victim
    			{
    				if (Pv.llink == V)
    				{
    					Pv.llink = R;
    				}
    				
    				else
    				{
    					Pv.rlink = R;
    				}
    				
    				R.llink = V.llink;
    			}
    		}
    	}
    }
    
    /**
     * removes data from binary search tree
     * @param V data to be removed
     */
    public void delete(E V)
    {
    	if (root != null)
    	{
    		BSTNode<E> victim;
    		victim = search(root, V);
    		delete(victim);
    	}
    	
    }
    
    /**
     * helper recursive method for search
     * @param subroot root to search at
     * @param target data to look for
     * @return BSTNode<E> node to be returned containing target data
     */
    private BSTNode<E> search(BSTNode<E> subroot, E target)
    {

   	 	if (subroot == null || target.compareTo(subroot.key) == 0)
		 {
			 return subroot;
		 }
		 
		 else if (target.compareTo(subroot.key) > 0)
		 {
			 return search(subroot.rlink, target);
		 }
		 
		 else
		 {
			 return search(subroot.llink, target);
		 }
    }
    
    /**
     * Searches the binary search tree for the target 
     * @param target 
     * @return E target if it is in binary search tree, null if it does not exist
     */
    public E search(E target)
    {
    	BSTNode<E> myNode = search(root, target);
    	
    	if (myNode == null) //node not in tree
    	{
    		return null;
    	}
    	
    	else
    	{
    		return myNode.key;
    	}
    }
    
    
    /**
     * Recursive helper method of toString.
     * Uses inorder tree traversal algorithm.
     * @param N subroot of tree to print
     * @return Binary search tree as a printable string
     */
    private String toString(BSTNode<E> N) {
    	String myString = "";
    	if (N != null) // do nothing if the node is null
    	{     
	        myString += toString(N.llink);
	        myString +=  "\n" + N.key;
	        myString += toString(N.rlink);
    	}
    	return myString;
    }
  
    /** 
     * @return a printable version
     * of the tree showing the subtree structure
     */
    public String toString() {
      return toString(root);
    }
    
    /**
     * helper recursive method of size
     * @param N root to begin traversal from
     */
    private int size(BSTNode<E> N)
    {
  	  int size = 0;
  	  if (N != null) {      // do nothing if the node is null
            size += size(N.llink);
            size ++;
            size += size(N.rlink);
  	  }
  	  return size;
  	  
    }
    
    /**
     * @return the size of the Binary Search Tree
     */
    public int size()
    {
  	  return size(root);
    }
}
