package com.techforum.codemaster;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author A581781
 *
 */
public class ProblemSolution {

	public static void main(String[] args) throws IOException {

		File file = new File("./Problem2/Problem2_input.txt");
		Scanner scanner = new Scanner(new FileInputStream(file));
		
		FileWriter fileWriter = new FileWriter("./Problem2/Output.txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    
	    int counter = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			
			if(counter == 0) {
				// do nothing
			}
			else
			{
				// process the following line
				processInput(counter, line, printWriter);
			}
			counter += 1;
		}
	    
		scanner.close();
		printWriter.close();
	}
	
	private static void processInput(int count, String numberStr, PrintWriter printWriter) {
		long number = Long.parseLong(numberStr);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Request-").append(count).append(": ");
		if(number < 10) {
			stringBuilder.append(number);
		}
		else {
			for(long i = number; i > 0; i--) {
				int[] numar = convertToLongArray(String.valueOf(i));
				if(!isInValid(numar)) {
					stringBuilder.append(i);
					break;
				}
			}
			
		}
		String output = stringBuilder.toString();
		printWriter.println(output);
		System.out.println(output);
	}
	
	private static int[] convertToLongArray(String temp) {
		int[] newGuess = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
			newGuess[i] = temp.charAt(i) - '0';
		}
		return newGuess;
	}
	
	private static boolean isInValid(int[] numberArray) {
		for (int i = 0; i < numberArray.length - 1; i++) {
			if (numberArray[i] > numberArray[i + 1])
				return true;
		}
		return false;
	}

}
