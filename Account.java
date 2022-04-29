import java.util.ArrayList;
public class Account {
	private String nameOfAccount;
	
	//private double balance;
	
	private String uuid;
	
	private User holder;//owner
	
	private ArrayList<Transaction> transactions;
	
	public Account(String nameOfAccount, User holder, Bank theBank) {
		this.nameOfAccount  = nameOfAccount;
		this.holder = holder;
		
		this.uuid = theBank.getNewAccountUUID();//TO BUILD later
		
		//initalise transactions
		this.transactions = new ArrayList<Transaction>();
		
		//Add to holder and bank list
		holder.addAccount(this);
		theBank.addAcount(this);
		
		
		
	}

}
