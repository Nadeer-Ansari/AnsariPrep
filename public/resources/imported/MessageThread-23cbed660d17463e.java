package multithreading;

public class MessageThread extends Thread {
	private String decorationPattern;
	private Message messageObject;
	public MessageThread(String decorationPattern, Message messageObject) {
		this.decorationPattern = decorationPattern;
		this.messageObject = messageObject;
	}
	public void run() {
		synchronized (messageObject) {
			try {
				messageObject.print(decorationPattern);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}
