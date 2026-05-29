package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//import java.io.*;

public class BufferedRead {

	public static void main(String[] args) throws IOException{
	
		BufferedReader br= new BufferedReader(new FileReader("abc.txt"));
		
		String line;
		
		while((line=br.readLine())!=null) {
			System.out.println(line);
			
			
			
			
		}
		System.out.println("Data Read Succesfully");
		br.close();
		

	}

}
