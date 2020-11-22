package jonus.cassius.projects.wordcounter;

import java.io.*;
import java.util.Scanner;
//import java.util.*;

public class App {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		WordCounter counter = new WordCounter(getFile());

		try {
			System.out.print("""
					What do you want to do with the file?
					Type w for counting words.
					Type c for counting characters:  """);
			char answer = Character.toLowerCase(input.nextLine().charAt(0));
			switch (answer) {
			case 'w': {
				System.out.println("The number of words in the file is " + counter.countWords());
				break;
			}
			case 'c': {
				System.out.print("""
						Do you want to ignore white space characters?
						Type y or n: """);
				char selection = Character.toLowerCase(input.nextLine().charAt(0));
				switch (selection) {
				case 'y': {
					System.out.println("The number of non-whitespace characters in the file is " + counter.countChars(true));
					break;
				}
				case 'n': {
					System.out.println("The number of characters in the file is " + counter.countChars(false));
					break;
				}
				default: {
					
				}
				}
				break;
			}
			default: {
				
			}
			}
		} catch (FileNotFoundException e) {
			System.out.println("The specified file could not be found.");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("There was a problem reading the file.");
			e.printStackTrace();
		}
	}

	private static File getFile() {
		System.out.print("Enter the full path to a file on your computer: ");
		String filePath = input.nextLine();
		
		
		return new File(filePath).getAbsoluteFile();
	}

}
