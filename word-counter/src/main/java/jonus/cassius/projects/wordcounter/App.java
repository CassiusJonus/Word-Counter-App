package jonus.cassius.projects.wordcounter;

import java.io.*;
//import java.util.*;

public class App {

	public static void main(String[] args) {

		WordCounter counter = new WordCounter(new File("C:\\Users\\Veget\\Documents\\Case_Study_5.txt"));
		
		try {
			System.out.println(counter.countChars(false));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}


}
