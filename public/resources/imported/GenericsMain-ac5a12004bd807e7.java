package collections_framework;

public class GenericsMain {

	public static void main(String[] args) {
		Adder<String> strAdder = new StringAdder();
		Adder<Integer> intAdder = new IntegerAdder();
		System.out.println(strAdder.doAdd("Hello", "Welcome"));
		System.out.println(intAdder.doAdd(100, 200));

	}

}
