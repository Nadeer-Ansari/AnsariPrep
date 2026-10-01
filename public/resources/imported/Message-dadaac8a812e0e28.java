package multithreading;

public class Message {
	//This class is for the object that will be shared by 2 threads
	private String content;

	public Message(String content) {
		this.content = content;
	}
	
	public void print(String decoration) throws InterruptedException {
		System.out.println(decoration);
		Thread.sleep(2000);
		System.out.println(content);
		Thread.sleep(2000);
		System.out.println(decoration);
		Thread.sleep(2000);
	}
	
}
