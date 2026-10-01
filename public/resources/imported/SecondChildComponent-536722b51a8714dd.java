package second.child;

import org.springframework.stereotype.Component;

@Component("second_child")//Assigning an ID to this component
public class SecondChildComponent {
	public void doWork() {
		System.out.println("SecondChildComponent works...");
	}
}
