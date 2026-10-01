package exception_handling;

public class AccountMain {
	public static void main(String[] args) {
		Account a1 = new Account(456, "Gautam", 50000);
		System.out.println(a1);
		
		a1.deposit(15000);
		System.out.println(a1);
		
		try {
			a1.withdraw(125000);
			System.out.println(a1);
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
