package example.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//@Aspect //Marks this class as an aspect
public class Audience {
	@Pointcut("execution(* example.spring.aop.Musician.perform(..))")
	private void myPointCut() {}
	
	@Before("myPointCut()")
	public void takeSeats() {
		System.out.println("Take your seats");
	}
	@Before("myPointCut()")
	public void turnOffMobile() {
		System.out.println("Turn off your mobile");
	}
	@AfterReturning("myPointCut()")
	public void clap() {
		System.out.println("Clap Clap Clap");
	}
	@AfterThrowing("myPointCut()")
	public void demandForRefund() {
		System.out.println("Please give my money back");
	}
	@After("myPointCut()")
	public void leave() {
		System.out.println("Bye, leaving now");
	}

}
