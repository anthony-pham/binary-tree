/**
 * @author Anthony Pham
 * @version 3/12/14
 * 
 * Tester for Binary Search Tree
 */
public class BSTTester {

	public static void main(String[] args)
    {
    	System.out.println("Starting Tests");
    	
    	BSTTester c = new BSTTester();
    	c.insertTests();
    	c.searchTests();
    	c.deleteTests();
    	c.sizeTests();
    	
    	System.out.println("Tests Complete");
    }
	
	/**
	 * insert tests
	 */
	public void insertTests() {

		System.out.println("\nInsert Tests \n");
		
        BinarySearchTree<String> t1 = new BinarySearchTree<String>(); 
        t1.insert("A"); //insert into empty tree
        System.out.println(t1);
        
        BinarySearchTree<String> t2 = new BinarySearchTree<String>();
        t2.insert("D");
        t2.insert("B"); //insert to left of root
        t2.insert("G"); //insert to right of root
        t2.insert("F"); //insert to left of non-root
        t2.insert("H"); //insert to right of non-root
        System.out.println(t2);
        
        
    }
    
	/**
	 * Search tests
	 */
    public void searchTests() {
    	
    	System.out.println("\nSearch Tests\n ");
    	
    	BinarySearchTree<String> t1 = new BinarySearchTree<String>();
        t1.insert("D");
        t1.insert("B");
        t1.insert("G");
        t1.insert("F");
        t1.insert("H");
        
        System.out.println(t1.search("A")); // not in tree
        System.out.println(t1.search("D")); // root
        System.out.println(t1.search("B")); // leaf
        System.out.println(t1.search("G")); // non leaf
        
        BinarySearchTree<String> t2 = new BinarySearchTree<String>();
        
        System.out.println(t2.search("A")); // search empty tree
    }
    
    /**
     * remove tests
     */
    public void deleteTests()
    {
    	System.out.println("\nDelete Tests \n");
    	
    	BinarySearchTree<String> t1 = new BinarySearchTree<String>();
    	
    	t1.delete("A"); //remove from empty tree
    	System.out.println(t1);
    	
    	BinarySearchTree<String> t2 = new BinarySearchTree<String>();
    	
    	t2.insert("A");
    	t2.delete("A"); //remove leaf that is also the root
    	System.out.println(t2);
    	
    	BinarySearchTree<String> t3 = new BinarySearchTree<String>();
    	
    	t3.insert("D");
    	t3.insert("B");
    	t3.delete("B"); //remove leaf non-root
    	System.out.println(t3);
    	
    	BinarySearchTree<String> t4 = new BinarySearchTree<String>();
    	
    	t4.insert("D");
    	t4.insert("G");
    	t4.delete("D"); // Victim has a right child and is the root
    	System.out.println(t4);
    	
    	BinarySearchTree<String> t5 = new BinarySearchTree<String>();
    	t5.insert("G");
    	t5.insert("D");
    	t5.insert("E");
    	t5.delete("E"); // Right child non-root
    	System.out.println(t5);
    	
    	BinarySearchTree<String> t6 = new BinarySearchTree<String>();
    	
    	t6.insert("D");
    	t6.insert("B");
    	t6.delete("D"); // Victim has a left child and is the root
    	System.out.println(t6);
    	
    	BinarySearchTree<String> t7 = new BinarySearchTree<String>();
    	
    	t7.insert("E");
    	t7.insert("H");
    	t7.insert("F"); 
    	t7.delete("F");// Left child non-root
    	System.out.println(t7);
    	
    	BinarySearchTree<String> t8 = new BinarySearchTree<String>();
    	
    	t8.insert("G");
    	t8.insert("A");
    	t8.insert("J");
    	t8.insert("L");
    	t8.insert("K");
    	t8.delete("G"); // V is root, replacement is child
    	System.out.println(t8);
    	
    	BinarySearchTree<String> t9 = new BinarySearchTree<String>();
    	
    	t9.insert("G");
    	t9.insert("A");
    	t9.insert("K");
    	t9.insert("J");
    	t9.insert("I");
    	t9.insert("L");
    	t9.delete("G"); // V is the root and replacement is not child
    	System.out.println(t9);
    	
    	BinarySearchTree<String> t10 = new BinarySearchTree<String>();
    	
    	t10.insert("G");
    	t10.insert("L");
    	t10.insert("K");
    	t10.insert("M");
    	t10.insert("N");
    	t10.delete("L"); // V is not the root and replacement is child of V
    	System.out.println(t10);
    	
    	BinarySearchTree<String> t11 = new BinarySearchTree<String>();
    	
    	t11.insert("L");
    	t11.insert("C");
    	t11.insert("B");
    	t11.insert("G");
    	t11.insert("D");
    	t11.insert("E");
    	t11.delete("C"); // V is not the root and replacement is not a child of V
    	System.out.println(t11);     
    }
    
    /**
     * test size method
     */
    public void sizeTests()
    {
    	System.out.println("\nDelete Tests \n");
    	
    	BinarySearchTree<String> t1 = new BinarySearchTree<String>();
    	
    	System.out.println(t1.size()); //empty tree
    	
    	t1.insert("G");
    	System.out.println(t1.size()); //tree with only root
    	
    	t1.insert("D"); //tree with root and one left child
    	System.out.println(t1.size());
    	
    	t1.insert("I"); //root with two children
    	System.out.println(t1.size()); 
    	
    	t1.insert("B");
    	t1.insert("F");
    	System.out.println(t1.size());
    	
    	t1.insert("H");
    	t1.insert("K");
    	System.out.println(t1.size());
    }
}
