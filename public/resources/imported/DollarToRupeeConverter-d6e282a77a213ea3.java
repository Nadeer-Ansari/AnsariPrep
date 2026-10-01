
public class DollarToRupeeConverter implements CurrencyConverter{

	@Override
	public float doConvert(float amountInDollars) {
		float amountInRupees = amountInDollars * DOLLAR_TO_RUPEE;
		return amountInRupees;
	}

}
