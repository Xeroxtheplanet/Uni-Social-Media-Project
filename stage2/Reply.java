package stage2;

import stage1.User;

public class Reply {
	public User from;
	public User[] to;
	public String message;
	public int views;
	
	/**
	 * @param from		- for from
	 * @param to		- for to
	 * @param message	- for message
	 */
	public Reply(User from, User[] to, String message) {
		this.from = from; 
		this.to = to;
		if(message == null) { // Accounting for null case
			this.message = "This is a test reply.";
		}
		else
		this.message = message;
		
	}
	
	/**
	 * @param message - for message
	 * The 'from' instance variable should be set to a new User object containing: 
	 * - handle = "unknown"
	 * - bio = ""
	 * - followers = [] (an empty String array)
	 * - following = [] (an empty String array)
	 * - verified  = false
	 * The 'to' instance variable should be set to an empty User array.
	 * The 'views' instance variable should be set to 0.
	 */
	public Reply(String message) {
		
		this.from = new User("unknown", "", new String[0], new String[0], false); //Creates new empty string arrays for user in third and 4th parameters
		this.to = new User[0]; // Assigned a new empty user array
		this.views = 0;
		if(message == null) { //Accounting for null case
			this.message = "This is a test reply.";
		}
		else
		this.message = message; //assigning this.message the message if not the null case
	}
	
	
	/**
	 * return 1 if calling object has a longer message than the parameter object
	 * return -1 if calling object has a shorter message than the parameter object
	 * return 0 if the calling object has a message of the same length as the parameter object
	 */
	public int compareTo(Reply other) {
		
		if(this.message==null&other.message==null) { //Accounting for null exceptions first.
			return 0;
		}
		
		
		if(this.message==null&other.message!=null) {
			return -1;
		}
		
		if(this.message!=null&other.message==null) {
			return 1;
		}
		
		if(this.message!=null&&other.message!=null) { //Assigning the values based on the message length ratio
			if (this.message.length()>other.message.length()) {
				return 1;
			}
			if (this.message.length()<other.message.length()) {
				return -1;
			}
			if (this.message.length()==other.message.length()) {
				return 0;
			}
		}
	    return -100;
	}
	
	/**
	 * @param action - the action to take
	 * @param phrase - the phrase to use or check against.
	 * Perform the following based on the value of 'action'
	 * - If action is 1: Add a space character and 'phrase'
	 *   to the end of the instance variable message
	 * - If action is 2: Remove all occurrences of 'phrase'
	 *   from the instance variable message. Hint .replaceAll()
	 * - If action is 3: Set the instance variable message to
	 *   "[This reply has been removed]"
	 * You may assume that action will only be a value between 1 to 3.
	 */
	public void modifyMessage(int action, String phrase) {
		
		if (action == 1) { // add space and 'phrase' to end of instance variable message
			if (this.message != null) {
				this.message = this.message + ' ' + phrase;
			}
			if (this.message == null) { // Accounting for null case
				this.message = "This is a test reply. " + phrase;
			}
		}
		
		if (action == 2) {
			if (this.message.contains(phrase)) {
				this.message = this.message.replaceAll(phrase, ""); //Replaces the phrase with nothing
			}
		}
		
		if (action == 3) {
			this.message = "[This reply has been removed]";
		}
	    //TODO To be completed
	}
	
	/**
	 * DO NOT MODIFY
	 */
	public String toString() {
		String result = "Replying to ";
		if(to == null || to.length < 1)
			result += "no one";
		else {
			for(User u : to)
				result += "@" + u.handle + ", ";
			result = result.substring(0, result.length() - 2);
		}
		
		result += "\n" + message;
		return result;
	}
	
	/**
	 * DO NOT MODIFY
	 */
	public String[] toUsersToString() {
		String[] toUsers = new String[to.length]; 
		for(int i = 0; i < to.length; i++) {
    		toUsers[i] = to[i].toString();
    	}
		return toUsers;
	}
	
	/**
	 * DO NOT MODIFY - this constructor is only used for testing
	 */
	public Reply(User from, User[] to, String message, int views) {
		//TODO To be completed
		this(from, to, message);
		this.views = views;
	}
}
