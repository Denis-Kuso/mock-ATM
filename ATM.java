import java.util.Scanner;
import java.util.HashMap;
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
	private static String getMenuMessage(int choice) {
		HashMap<Integer, String> menuMessages = new HashMap<Integer, String>();
		// TODO reimplement with a loop and list of messages
		menuMessages.put(1,"Show account transaction history");
		menuMessages.put(2, "Withdrawal");
		menuMessages.put(3,"Deposit");
		menuMessages.put(4, "Transfer");
		menuMessages.put(5, "Quit");
		
		return menuMessages.get(choice);
	}
	 public static void printUserMenu(User theUser, Scanner scanner) {
		 theUser.printAccountSummary();
		 
		 int usersChoice;
		 int numOfChoices = 5;// TODO moves this elsewhere
		 // menu of choices
		 do {
			 System.out.printf("Welcome %s:", theUser.getFirstName());
			 for(int i = 0; i < numOfChoices; i++) {
				 System.out.printf("%s) %s",i,getMenuMessage(i));
			 }
			 System.out.print("Enter choice: ");
			 usersChoice = scanner.nextInt(); // TODO catch wrong input
		 } while(usersChoice < 1 | usersChoice > numOfChoices);
		 
		 
	 }

}
