import java.util.Scanner;
public class ATM {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		Bank theBank = new Bank("Bank of Shire");
		
		//Use for testing user
		User someUser = theBank.addUser("Frodo", "Baggins", "0123");
		
		Account newAccount = new Account("Checking", someUser, theBank);
		someUser.addAccount(newAccount);
		theBank.addAccount(newAccount);
		
		User currentUser;
		while(true) {
			
			// Try a succesful login
			currentUser = ATM.mainMenuPrompt(theBank, scanner);
			
			// keep menu open for user to navigate
			ATM.printUserMenu(currentUser, scanner);
		}

	}
	
	public static User mainMenuPrompt(Bank theBank, Scanner scanner) {
		String userID;
		String pin;
		User authUser;
		
		// ask for login details
		
		do {
			System.out.printf("\n\nWelcome %s\n\n", theBank.getName());
			System.out.print("Enter user ID: ");
			userID = scanner.nextLine();
			System.out.print("Enter PIN: ");
			pin = scanner.nextLine();
			
			// Is this user our customer
			authUser = theBank.userLogin(userID, pin);
			if(authUser == null) {
				System.out.println("Invalid user ID and/or PIN. " + "Please try again.");
			}
		} while(authUser == null); // TODO reduce to, say, 3 attempts
		
		return authUser;
	}

}
