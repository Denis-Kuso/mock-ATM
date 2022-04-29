
public class Transaction {
	private double amount;
	
	private Date timestamp;
	
	private String memo;//comment
	
	private Account inAccount;
	
	public Transaction(double amount, Account inAccount) {
		this.amount = amount;
		this.inAccount = inAccount;
		this.timestamp = new Date();
		this.memo ="";
	}
	
	public Transaction(double amount, String memo, Acount inAccount) {
		
		// init inital constructor first
		this(amount,inAccount);
		this.memo = memo;
	}
}
