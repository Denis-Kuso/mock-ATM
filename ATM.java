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

	}

}
