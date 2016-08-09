/**
 * @author Anthony Pham
 * @version 3/12/14
 * 
 * indexContent is a wrapper class that holds a word along with its associated pagelist
 */
public class indexContent implements Comparable<indexContent> {
	
	private String word;
	private PageList myList;
	
	/**
	 * non-default constructor
	 * @param word
	 * @param pageList
	 */
	public indexContent(String word)
	{
		this.word = word;
		myList = new PageList();
	}
	
	/**
	 * Compares the Word of indexContent with another indexContent
	 * 
	 * Extra credit: ignores case of word so a word is not repeated if it has a different case
	 * 
	 * @param otherIndex to compare to
	 * @return 0 if their words are the same, -1 if this word's is less than other, 1 if it is greater
	 */
	public int compareTo(indexContent otherIndex)
	{
		return this.getWord().compareToIgnoreCase(otherIndex.getWord());
	}
	
	/**
	 * getter
	 * @return word of indexContent
	 */
	public String getWord()
	{
		return word;
	}
	
	/**
	 * getter
	 * @return pagelist associated with word
	 */
	public PageList getList()
	{
		return myList;
	}
	
	/**
	 * returns indexContent as a printable string
	 * @return printable string of indexContent 
	 */
	public String toString()
	{
		return word + "  " + myList.toString();
	}
	
	/**
	 * setter
	 * adds page to pagelist
	 * @param newData new index to add
	 */
	public void insert(int newData)
	{
		myList.insert(newData);
	}

}
