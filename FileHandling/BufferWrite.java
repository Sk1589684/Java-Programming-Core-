package FileHandling;
import java.io.*;

public class BufferWrite {

	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw=new BufferedWriter(new FileWriter("abc.txt",true));
		
		bw.write("\nHello Sarvesh Here From OTA");
		
		bw.close();
		
		System.out.println("Data Added Successfully");

	}

}
