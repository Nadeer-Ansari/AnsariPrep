package exception_handling;

public class Account {
	private int accountNo;
	private String name;
	private float balance;
	public Account() {
		accountNo = 1122;
		name = "Jatin";
		balance = 10000;
	}
	public Account(int accountNo, String name, float balance) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + "]";
	}
	
	public void withdraw(float amount) throws InsufficientBalanceException{
		//If balance is insufficient raise an exception: 
		//InsufficientBalanceException but let the caller handle it
		if(amount > balance) {
			String errMsg = 
			"Unable to perform withdraw due to insufficient balance";
			InsufficientBalanceException ix =
			new InsufficientBalanceException(errMsg, balance);
			throw ix;
		}
		balance -= amount;
	}
	public void deposit(float amount) {
		balance += amount;
	}
}






