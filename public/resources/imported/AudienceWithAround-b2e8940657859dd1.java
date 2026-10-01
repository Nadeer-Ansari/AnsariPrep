package example.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect //Marks this class as an aspect
public class AudienceWithAround {
	@Pointcut("execution(* example.spring.aop.*.perform(..))")
	private void myPointCut() {}
	
	
	private void takeSeats() {
		System.out.println("Take your seats using Around");
	}
	
	private void turnOffMobile() {
		System.out.println("Turn off your mobile using Around");
	}
	
	private void clap() {
		System.out.println("Clap Clap Clap using Around");
	}
	
	private void demandForRefund() {
		System.out.println("Please give my money back using Around");
	}
	
	private void leave() {
		System.out.println("Bye, leaving now using Around");
	}
	
	@Around("myPointCut()")
	public void monitorPerformance(ProceedingJoinPoint joinPoint) {
		try {
			takeSeats();
			turnOffMobile();
				joinPoint.proceed();//Proceed towards target
			clap();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			demandForRefund();
			//e.printStackTrace();
		}
		leave();		
	}

}










