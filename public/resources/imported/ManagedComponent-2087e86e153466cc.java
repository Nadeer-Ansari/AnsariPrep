package example.spring.core;

import org.springframework.stereotype.Component;

@Component
public class ManagedComponent {
	public void doWork() {
		System.out.println("ManagedComponent works...");
	}
}
