
public class InheritanceMain {

	public static void main(String[] args) {
		CricketPlayer crPlayer = new CricketPlayer();
		crPlayer.setName("Sanju");
		crPlayer.setAge(27);
		crPlayer.setRuns(2343);
		
		System.out.println(crPlayer.getName() + " has scored " + crPlayer.getRuns() + " runs");
		System.out.println("-------------");
		CricketPlayer crPlayer2 = new CricketPlayer("Smriti", 26, 1232);

	}

}
