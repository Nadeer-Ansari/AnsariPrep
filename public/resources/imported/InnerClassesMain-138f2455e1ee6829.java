
public class InnerClassesMain {

	public static void main(String[] args) {
		Outer.StaticInner si = 
				new Outer.StaticInner();
		si.print();
		System.out.println("---------------");
		Outer ot = new Outer();
		Outer.Nested ns = ot.new Nested();
		//Outer.Nested ns = new Outer().new Nested();
		ns.display();
		System.out.println("---------------");
		ot.showMessage();
		System.out.println("----------------");
		CurrencyConverter converter;
		converter = new CurrencyConverter() {
			
			@Override
			public float doConvert(float amountInEuros) {
				// TODO Auto-generated method stub
				return amountInEuros * 100.05f;
			}
		};
		float inr = converter.doConvert(10000);
		System.out.println("Euro 10000 = INR." + inr);
		/*converter = new CurrencyConverter() {//Anonymous Inner Class starts
			public float doConvert(float amountInEuros) {
				return amountInEuros * 100.05f;
			}
		};//Anonymous Inner Class ends
		*/

	}

}



