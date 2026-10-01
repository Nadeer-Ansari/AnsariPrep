
public class InterfaceMain {

	public static void main(String[] args) {
		System.out.println("Today's conversion rates: ");
		System.out.println("USD to INR: " + CurrencyConverter.DOLLAR_TO_RUPEE);
		System.out.println("GBP to INR: " + CurrencyConverter.POUND_TO_RUPEE);
		
		//CurrencyConverter.DOLLAR_TO_RUPEE = 95.37f; Error because the variable is by default final
		CurrencyConverter converter;
		converter = new DollarToRupeeConverter();
		float inr = converter.doConvert(50000);
		System.out.println("$50000 = INR. " + inr);
		
		converter = new RupeeToPoundConverter();
		float gbp = converter.doConvert(2500000);
		System.out.println("INR. 2500000 = GBP. " + gbp);

	}

}

interface I1 { }
interface I2 { }
class C implements I1, I2 { }

interface I3 extends I1, I2 { }















