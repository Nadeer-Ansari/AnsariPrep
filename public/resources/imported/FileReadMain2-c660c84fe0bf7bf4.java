package nio_programming;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileReadMain2 {

	public static void main(String[] args) {
		String filePath = "./src/assets/trainings.txt";
		try(
				FileInputStream fin = new FileInputStream(filePath);
				//Obtaining a FileChannel on the top of fin
				FileChannel fc = fin.getChannel();
				){
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			fc.read(buffer);//Reads the data from file channel and stores it into byte buffer
			buffer.flip();//Changes the mode from WRITE to READ so that data can be read.
			while(buffer.hasRemaining()) {
				byte dataByte = buffer.get();
				char ch = (char)dataByte;
				System.out.print(ch);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
