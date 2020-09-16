package com.java.problem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution2 {	
	

	public static void main(String[] args) throws IOException {
		
		
		Scanner scanner = new Scanner(new File("Problem2_input.txt"));
		FileWriter fw = new FileWriter("Problem2_ouput.txt");   
		File fout = new File("Problem2_ouput.txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		while (scanner.hasNextLine()) {			
			
			long number = Long.valueOf(scanner.nextLine());
			
			boolean isLuckyFlag = checkLuckyNO(number);			
			
			
			if(!isLuckyFlag) {
				//print in the output file
				
				//bw.write(String.valueOf(number));
				//bw.newLine();
				
			} else {
				
				for(int i=1 ; i<number ; i++) {
					number= number-i;
					if(!checkLuckyNO(number)) {
						//print in to file
						System.out.println(number); 
						osw.write(String.valueOf(number));
						//bw.newLine();
						break;
					}
				}
			}
		}
		scanner.close();
		osw.close();
		

	}
	
	private static boolean checkLuckyNO(long number) {
		List<Integer> stack = new ArrayList<Integer>();
		while (number > 0) {
			int temp = (int)(number % 10);
		    stack.add(temp);
		    number = number / 10;
		}
		
			
		boolean isNotLuckyNo = false;
		Collections.reverse(stack);
		
		Integer[] array = new Integer[stack.size()];
		stack.toArray(array);
		boolean flag = isSorted(array);
		if(flag) {			
			isNotLuckyNo = false;
		}else {
			isNotLuckyNo = true;
		}
			
		
		return isNotLuckyNo;
	}
	
	public static boolean isSorted(Integer[] array) { 
		int prev = array[0]; 
		for (int i = 1; i < array.length; i++) { 
			if (array[i] > prev) { 
				return false; 
	        } 
			prev = array[i]; 
		} 
	    return true; 
	} 

}
