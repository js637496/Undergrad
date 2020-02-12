import java.io.Serializable;
import java.util.ArrayList;

public class userObject implements Serializable{
	
	/*name
	 * image
	 * status
	 * friends list
	 * 
	 * create profile
	 * modify profile
	 * add friends
	 * delete profile
	 * 
	 */
	
	public String name;
	public String imageLocation;
	public String status;
	public ArrayList<userObject> friendList = new ArrayList<userObject>();
	public String password;
	public boolean isMe;
	
	userObject(String name, String imageLocation, String status, String password){
		this.name = name;
		this.imageLocation = imageLocation;
		this.status = status;
		this.password = password;
	}
	
	public void setStatus(String status){
		this.status  = status;
	}
	
	public void setimage(String img){
		this.imageLocation  = img;
	}
	
	public void setPassword(String password){
		this.password  = password;
	}
	
	public void addFriend(userObject user){
		this.friendList.add(user);
		
	}
	
	public boolean loginSucessfull(String name, String password){
		if(this.name == name || this.password == password)
			return true;
		else 
			return false;
		
	}
	

}
