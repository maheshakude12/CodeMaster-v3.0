package com.codemaster;

import java.util.ArrayList;
import java.util.Scanner;

public class CodemasterProblem2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Number of request");
		int req = in.nextInt();
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for (int r = 0; r < req; r++) {
			int a = in.nextInt();
			ls.add(a);
		}
		for (int counter = 0; counter < ls.size(); counter++) {
			System.out.println("Request-" + (counter + 1) + ":" + myLuckyNumber(ls.get(counter)));
		}
	}

	static int myLuckyNumber(int n) {
		if (Integer.toString(n).length() == 1) {
			return n;
		} else {
			for (int i = n; i >= 0; i--) {
				boolean flag = false;
				String str = Integer.toString(i);
				for (int j = 0; j < str.length() - 1; j++) {
					if (str.charAt(j) > str.charAt(j + 1)) {
						break;
					}
					if (j == str.length() - 2 && str.charAt(j) <= str.charAt(j + 1)) {
						flag = true;
					}
				}
				if (flag) {
					return i;
				}
			}
			return n;
		}
	}
}