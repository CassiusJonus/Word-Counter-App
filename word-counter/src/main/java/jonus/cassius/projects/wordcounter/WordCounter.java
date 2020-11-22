package jonus.cassius.projects.wordcounter;

/**
 * @author Cassaries Johnson
 * 
 * This class handles the counting of words in f file. 
 * This class also lets the user count the numbers of characters in a file, 
 * letting them decide whether or not to include white space characters ( ).
 *
 */

import java.io.*;


public class WordCounter {
	private File source;

	public WordCounter(File source) {
		this.source = source;
	}

	public void setSourceFile(File source) {
		if (source == null) {
			throw new NullPointerException("The file cannot be null");
		}
		this.source = source;
	}
	public File getSourceFile() {
		return source;
	}

	/**
	 * Returns the number of words in the file associated with this object.
	 * 
	 * @return The number of words in the file
	 * @throws IOException
	 */
	public int countWords() throws IOException {
		int numWords = 0;
		BufferedReader reader = new BufferedReader(new FileReader(this.source));
		String line;
		while ((line = reader.readLine()) != null) {
			if (!line.isEmpty()) {
				numWords += line.trim().split("\\W*\\s+\\W*").length;
			}
		}
		reader.close();
		return numWords;
	}

	/**
	 * Counts the number of characters in the file associated with this object If
	 * ignoreWhiteSpace is true, the white space character ( ) will be ignored.
	 * 
	 * @param ignoreWhiteSpace If true, white space characters will not be included
	 *                         in the total count
	 * @return the number of characters in the file
	 * @throws IOException
	 */
	public int countChars(boolean ignoreWhiteSpace) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(this.source));
		int currentChar;
		int charCount = 0;
		while ((currentChar = reader.read()) != -1) {
				if (ignoreWhiteSpace) {
					if (!Character.isSpaceChar(currentChar)) {
						charCount++;
					}
				} else {
					charCount++;
				} 
			}
		reader.close();
		return charCount;
	}
}
