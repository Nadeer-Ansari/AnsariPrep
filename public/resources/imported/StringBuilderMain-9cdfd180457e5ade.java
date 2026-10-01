package string_builder;

public class StringBuilderMain {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("Shall we stop? ");
		builder.append(true);
		builder.append(". Ok, let's continue tomorrow at ");
		builder.append(9);
		
		System.out.println(builder);
		
		String data = builder.toString();
		System.out.println(data);

	}

}
