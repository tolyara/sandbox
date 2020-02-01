package interview;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
	
	public static void main(String[] args) throws IOException {
		
		int byteSymbol = 0;
		String word = "Java2";
		FileInputStream fileInputStream = new FileInputStream("D:\\paths.txt");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
//		FileOutputStream fileOutputStream = new FileOutputStream("D:\\test.txt");
		FileWriter fileWriter = new FileWriter("D:\\test.txt", true);
		
//		while ((byteSymbol = fileInputStream.read()) != -1) {
//			System.out.print( (char) byteSymbol);
//		}
		
//		while ((byteSymbol = inputStreamReader.read()) != -1) {
//			System.out.print((char) byteSymbol);
//		}
		
//		fileOutputStream.write(word.getBytes());
		
		fileWriter.write(word);
		
		fileInputStream.close();
		inputStreamReader.close();
//		fileOutputStream.close();
		fileWriter.close();
		
	}	

}
