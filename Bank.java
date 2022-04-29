import java.util.ArrayList;
import java.util.Random;
public class Bank {
	private String name;
	
	private ArrayList<User> users;
	
	private ArrayList<Account> accounts;
	
	/**
	 * Generate a new universally unique ID for a user.
	 * @return the uuid
	 */
	public String getNewUserUUID() {
		String uuid;
		Random randomGenerator = new Random();
		int lengthOfUUID = 6;
		boolean nonUnique;
		int UPPERBOUND = 10;// for random number generator
		//Generate unique number
		do {
			uuid = "";
			for(int i = 0; i < lengthOfUUID; i++) {
				uuid += ((Integer)randomGenerator.nextInt(UPPERBOUND)).toString();
			} 
			
			//Check if unique
			nonUnique = false;
			for(User u : this.users) {
				if(uuid.compareTo(u.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
			
		}while (nonUnique);
		return uuid;
	}
	
	public String getNewAccountUUID() {
		String uuid;
		Random randomGenerator = new Random();
		int lengthOfUUID = 10;
		boolean nonUnique;
		int UPPERBOUND = 10;// for random number generator
		//Generate unique number
		do {
			uuid = "";
			for(int i = 0; i < lengthOfUUID; i++) {
				uuid += ((Integer)randomGenerator.nextInt(UPPERBOUND)).toString();
			} 
			
			//Check if unique
			nonUnique = false;
			for(Account a : this.accounts) {
				if(uuid.compareTo(a.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
			
		}while (nonUnique);
		
		return uuid;
	}
	
	public void addAccount(Account anAccount) {
		this.accounts.add(anAccount);
	}
	
	public User addUser(String firstName, String lastName, String pin) {
		User newUser = new User(firstName, lastName, pin, this);
		
		this.users.add(newUser);
		
		// make a savings account
		
		Account newAccount = new Account("Savings", newUser, this);
		newUser.addAccount(newAccount);
		this.addAccount(newAccount);
		
		return newUser;
	}
	
	
	

}
