
public class BookMain {

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book();
		
		book1.bookId = 1;
		book1.title = "Java Projects";
		book1.author = "James";
		book1.price = 530.25f;
		
		book2.bookId = 2;
		book2.title = "Thinking in Java";
		book2.author = "Jack";
		book2.price = 580.25f;
		
		System.out.println("1st Book Details:");
		System.out.println("Title: " + book1.title);

	}

}
