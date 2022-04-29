import java.util.ArrayList;
public class User {
	//Define attributes
	
	private String firstName;
	private String lastName;
	private String uuid;
	/**
	 * MD5 hashed version of user's pin code.
	 */
	private byte hashedPin[];
	
	/**
	 * The list of accounts for this instance of user.
	 */
	private ArrayList<Account> accounts;
}
