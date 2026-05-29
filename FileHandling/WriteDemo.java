package FileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class WriteDemo {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw= new FileWriter("abc.txt",true);

		fw.write("\nHello Sarvesh Here From IMA");
		
		fw.close();
		
		System.out.println("Data  Added in File");
	}
	

}
