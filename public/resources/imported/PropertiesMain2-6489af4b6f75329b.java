package collections_framework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JFrame;

public class PropertiesMain2 {

	public static void main(String[] args) {
		Properties winProps = new Properties();
		String filePath = "./src/assets/window.properties";
		File currentFile = new File(filePath);
		if(currentFile.exists() && currentFile.isFile()) {
			try(
					FileInputStream fin = new FileInputStream(currentFile)
				){
				winProps.load(fin);
				String title = winProps.getProperty("windowTitle");
				String width = winProps.getProperty("windowWidth");
				String height = winProps.getProperty("windowHeight");
				System.out.println(title);
				System.out.println(width);
				System.out.println(height);
				
				int wt = Integer.parseInt(width);
				int ht = Integer.parseInt(height);
				//javax.swing => JFrame
				JFrame frame = new JFrame();
				frame.setTitle(title);
				frame.setSize(wt, ht);
				frame.setVisible(true);
				
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		else
			System.out.println("Unable to proceed as the path is invalid.");

	}

}
