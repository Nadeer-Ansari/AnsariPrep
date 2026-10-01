package io_programming;

import java.util.Scanner;

public class UserInputMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				Scanner scr = new Scanner(System.in)
			){
			System.out.println("Enter your name: ");
			String name = scr.nextLine();
			System.out.println("Enter your height (cm): ");
			int height = scr.nextInt();
			System.out.println("Enter your weight (kg): ");
			float weight = scr.nextFloat();
			
			System.out.println("Your name: " + name);
			System.out.println("Your height (cm): " + height);
			System.out.println("Your weight (kg): " + weight);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

}
