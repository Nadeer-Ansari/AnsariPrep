package collections_framework;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesMain {

	public static void main(String[] args) {
		// A program to load system properties and display them.
		Properties systemProps =  System.getProperties();
		Enumeration propNames = systemProps.propertyNames();
		
		while(propNames.hasMoreElements()) {
			Object obj = propNames.nextElement();
			String propName = (String)obj;
			String propValue = systemProps.getProperty(propName);
			System.out.println(propName + " = " + propValue);
		}

	}

}
