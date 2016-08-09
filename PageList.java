/**
 * @author Anthony Pham
 * @version 3/12/14
 * 
 * This class represents a list of pages where a word appears in text.
 */
public class PageList {

	private LinkedList<Integer> myList;
	
	public final static int MAX_SIZE = 4;
	
	/**
	 * default constructor
	 */
	public PageList()
	{
		myList = new LinkedList<Integer>();
		
	}
	
	/**
	 * number of elements in pagelist
	 * @return size of PageList
	 */
	public int size()
	{
		return myList.getLength();
	}
	
	/**
	 * inserts new page into page list
	 * pagelist must not exceed size of 4
	 * @param newPage to insert
	 */
	public void insert(int newPage)
	{
		if (this.size() < MAX_SIZE)
		{
			myList.insertAtTail(newPage);
		}
	}
	
	/**
	 * checks to see if the pagelist already contains a page
	 * @param data to compare
	 * @return true if data is in PageList, false if not
	 */
	public boolean contains(int data)
	{
		for (int i = 0; i < this.size(); i++)
		{
			if(this.getData(i) == data)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * gets data of page list at a given index
	 * @return page at index in page list
	 */
	public int getData(int index)
	{
		return myList.getData(index);
	}
	
	/**
	 * returns pagelist as a printable String
	 * 
	 * Extra credit: pages that are consecutive are connected using a "-" between the first and last page
	 * 
	 * @return myList as a printable String
	 */
	public String toString()
	{
		String myString = "";
		for (int i = 0; i < this.size()-1; i++)
		{
			int currentData = this.getData(i);
			int nextData = this.getData(i+1);
			
			if (nextData == currentData +1)
			{
				if (!myString.endsWith("-"))
				{
					myString += currentData + "-";
				}
			}
			
			else
			{
				myString += currentData + ",";
			}
		}
		myString += this.getData(this.size()-1);
		return myString;
	}
}
