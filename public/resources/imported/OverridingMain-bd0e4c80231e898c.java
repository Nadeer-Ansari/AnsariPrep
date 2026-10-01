
public class OverridingMain {

	public static void main(String[] args) {
		OfflineTraining trg1 = new OfflineTraining();
		trg1.conductTraining();
		
		OnlineTraining trg2 = 
		new OnlineTraining("Dot Net", 80, "https://meet.google.com/6545");
		trg2.conductTraining();
		
		System.out.println("------------------");
		System.out.println(trg1.getInfo());
		System.out.println(trg2.getInfo());
		
		/*Training trg3 = new OnlineTraining();
		trg3.conductTraining();
		
		//OnlineTraining tr = (OnlineTraining)trg3;
		
		System.out.println(((OnlineTraining)trg3).getMeetingLink());*/

	}

}
