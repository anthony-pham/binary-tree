/**
 * @author Anthony Pham
 * @version 3/12/14
 * 
 * This class performs the algorithm to create an index and dictionary from a text file
 */
public class Converter {
	
	private FileReader myReader;
	private BinarySearchTree<String> dictionary;
	private BinarySearchTree<indexContent> index;
	
	private final int MAX_LENGTH = 3;
	
	/**
	 * default constructor
	 */
	public Converter()
	{
		myReader = new FileReader("/Volumes/PHAMA/csc150/workspace/Pham - Project 7/uscons.txt"); //change text file here
		dictionary = new BinarySearchTree<String>();
		index = new BinarySearchTree<indexContent>();
	}
	
	/**
	 * performs algorithm to create index and dictionary from text file
	 */
	public void convert()
	{
		int page = 1; //starting page
		
		boolean keepGoing = true;
		String nextToken;
		
		while (keepGoing)
		{
			nextToken = myReader.nextToken();
			
			if (nextToken == null)
			{
				keepGoing = false;
			}
			
			else if (nextToken.equals("#"))
			{
				page ++;
			}	
			
			else if (nextToken.length() >= MAX_LENGTH && dictionary.search(nextToken) == null)
			{
				indexContent searchIndex, myIndex;
				searchIndex = new indexContent(nextToken);
				myIndex = index.search(searchIndex);
				if (myIndex != null)
				{
					if (!myIndex.getList().contains(page)) //word's pagelist doesn't yet have current page
					{
						if (myIndex.getList().size() < PageList.MAX_SIZE) //pagelist isn't full
						{
							myIndex.insert(page);
						}
						
						else //pagelist is full
						{
							System.out.println(myIndex.toString()); //print word and page list
							index.delete(myIndex); //delete word from index
							dictionary.insert(myIndex.getWord()); //insert word into dictionary
						}
					}

				}
				
				else //word is not in index yet
				{
					searchIndex.insert(page);
					index.insert(searchIndex);
				}
			}
		}
		
		System.out.println("\nIndex\n" + index.toString());
		System.out.println("\nDictionary\n" + dictionary.toString());
	}

}
