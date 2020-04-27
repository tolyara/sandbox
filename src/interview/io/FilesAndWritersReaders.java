package interview.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilesAndWritersReaders {
	
	public static void main(String[] args) throws IOException {		
		
		io();
	}
	
	private static void io() throws IOException  {
		File file = new File("temp.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("str1\n");
		fileWriter.write("str2\n");
		fileWriter.flush();
		
		FileReader fileReader = new FileReader(file);
		
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write("str3");
		bufferedWriter.newLine();
		bufferedWriter.write("str4");
		bufferedWriter.flush();
		bufferedWriter.close();
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.ready()) {
			System.out.println(bufferedReader.readLine());
		}
	}

}
