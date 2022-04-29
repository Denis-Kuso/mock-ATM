import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	
	public User(String firstName, String lastName, String pin, Bank theBank) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//md95 hashing for storage of PIN
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.hashedPin = md.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Caught NoSuchAlgorithmException");
			e.printStackTrace();
			System.exit(1);
		}
		
		// get a new unique universal ID for the user
		this.uuid = theBank.getNewUserUUID();
		
		// Create empty list of accounts
		this.accounts = new ArrayList<Account>();
		
		System.out.printf("New user %s, %s with ID %s created.\n", lastName, firstName,this.uuid);
		
		
	}
}
