import java.util.ArrayList;

/**
 * 
 */

/**
 * @author James Speers
 *
 */
public interface chirstmasPerson {
	public String name;
	public ArrayList<String> giftList = new ArrayList<String>();
	public boolean naughtyOrNice;
	

	/**
	 * Sets the name for the person to be added to Santa's lists
	 * @param name the name of the person being created
	 */
	public void setName(String name);
	
	/**
	 * Sets an item to be placed on the persons gift list
	 * @param gift the name of the gift to be added to the list
	 * @return the name if the gift that was successfully added,.
	 */
	public String addToGiftList(String gift);
	
	/**
	 * Sets if this person is naughty or nice for santas list
	 * @param naughtyOrnice false is naughty true is nice
	 */
	public void setNaughtyOrNice(boolean naughtyOrnice);
	
	/**
	 * Gets persons name
	 * @param 
	 * @return returns persons name
	 */
	public String getName();
	
	/**
	 * Gets the person gift list
	 * @return the gift list for person.
	 */
	public ArrayList<String> getGiftList();
	
	/**
	 * gets if this person is naughty or nice for santas list
	 * @return naughtyOrnice false is naughty true is nice
	 */
	public boolean getNaughtyOrNice(boolean naughtyOrnice);
	
	

}
