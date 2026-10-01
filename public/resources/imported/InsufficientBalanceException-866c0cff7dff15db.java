package exception_handling;

public class InsufficientBalanceException extends Exception{
	private float insufficientBalance;
	public InsufficientBalanceException
	(String errorMessage, float insufficientBalance) {
		super(errorMessage);
		this.insufficientBalance = insufficientBalance;
	}
	
	@Override
	public String getMessage() {
		String finalMessage = 
				super.getMessage() + " : " + insufficientBalance;
		return finalMessage;
	}
}
