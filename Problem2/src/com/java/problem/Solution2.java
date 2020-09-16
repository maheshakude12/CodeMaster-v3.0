package com.java.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Solution2 {

	public static void main(String[] args) {
		
		String str = "12312";
		long number = Long.valueOf(str);
		
		
		boolean isLuckyFlag = checkLuckyNO(number);
		
		
		
		if(!isLuckyFlag) {
			//print in direct output file
			System.out.println(number); 
		} else {
			for(int i=1 ; i<number ; i++) {
				number= number-i;
				if(checkLuckyNO(number)) {
					//print in to file
					System.out.println(number); 
					break;
				}
			}
		}
		

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
		for(int i = stack.size(); i<stack.size();i++) {
			int temp1 = stack.get(i);
			int temp2 = stack.get(i++);
			if(temp1 <= temp2) {
				//isLuckyNo = true;
			} else {
				isNotLuckyNo = true;
				break;
			}
		}
		/*while (!stack.isEmpty()) {
		  
		    //System.out.println(stack.pop());
		    int temp1 = stack.pop();
		    int temp2 = 0;
		    try {
		    	temp2 = stack.pop();
		    } catch(NoSuchElementException e) {
		    	
		    }
		    if(temp1 <= temp2) {
		    	System.out.println("This is Lucky number");
		    	isLuckyNo = true;
		    	//break;
		    } else {
		    	System.out.println("This is not Lucky number");
		    	isLuckyNo = false;
		    	break;
		    }
		}*/
		
		
		
		return isNotLuckyNo;
	}

}
