
public class RupeeToPoundConverter implements CurrencyConverter {

	@Override
	public float doConvert(float amountInRupees) {
		float amountInPounds = amountInRupees / POUND_TO_RUPEE;
		return amountInPounds;
	}

}
