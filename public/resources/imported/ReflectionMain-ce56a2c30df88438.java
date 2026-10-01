package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;



public class ReflectionMain {
	private static void printClassData(Object classObject) {
		//This method prints information of the class of which an
		//object is received as a parameter
		Class currentClass = classObject.getClass();
		String currentClassName = currentClass.getName();
		System.out.println(currentClassName);
		System.out.println("------Printing Field Names-------");
		Field[] allFields = currentClass.getDeclaredFields();
		for(Field currentField : allFields) {
			String fieldName = currentField.getName();
			System.out.println(fieldName);
		}
		System.out.println("------Printing Method Names-------");
		Method[] allMethods = currentClass.getDeclaredMethods();
		for(Method currentMethod : allMethods) {
			String methodName = currentMethod.getName();
			System.out.println(methodName);
		}
	}
	
	private static void printClassInfo(String className) 
			throws ClassNotFoundException {
		Class currentClass = Class.forName(className);
		String currentClassName = currentClass.getName();
		System.out.println(currentClassName);
		System.out.println("------Printing Field Names-------");
		Field[] allFields = currentClass.getDeclaredFields();
		for(Field currentField : allFields) {
			String fieldName = currentField.getName();
			System.out.println(fieldName);
		}
		System.out.println("------Printing Method Names-------");
		Method[] allMethods = currentClass.getDeclaredMethods();
		for(Method currentMethod : allMethods) {
			String methodName = currentMethod.getName();
			System.out.println(methodName);
		}
	}

	public static void main(String[] args) {
		try {
			printClassInfo("java.util.Stack");//Class Name of the class of which information is to be displayed
			System.out.println("==================================");
			printClassData(true);//Object of the class of which information is to be displayed
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
